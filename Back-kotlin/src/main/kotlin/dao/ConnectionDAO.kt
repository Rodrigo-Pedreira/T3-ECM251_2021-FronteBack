package dao

import shared.SharedPath
import java.sql.*

/**
 * API para interagir diretamente com um banco de dados do tipo SQL.
 */
class ConnectionDAO {

    /**
     * Referencia da conexao estabelecida com o banco de dados.
     */
    private val connection = DriverManager.getConnection(SharedPath.STRING_CONNECTION_JDBC,SharedPath.DATABASE_USERNAME,SharedPath.DATABASE_PASSWORD)

    /**
     * Statement SQL que sera usado para manipular o banco de dados.
     */
    private var statement: Statement? = null

    /**
     * Referencia para objeto que recebe os resultados de uma consulta no banco de dados.
     */
    private var resultSet: ResultSet? = null

    /**
     * Statement SQL pre compilado que sera usado para manipular o banco de dados.
     */
    private var preparedStatement: PreparedStatement? = null

    /**
     * Realiza tod0 o prodedimento para executar uma query.
     *
     * @param sqlString Texto da query a ser realizada.
     *
     * @return Retorna um resultSet referente a query.
     */
    fun executeQuery(sqlString: String): ResultSet? {
        this.statement = this.connection?.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet
    }

    /**
     * Getter do preparedStatement.
     * @return Retorna o preparedStatement.
     */
    fun getPreparedStatement(sqlString: String): PreparedStatement? {
        this.preparedStatement = this.connection?.prepareStatement(sqlString)
        return this.preparedStatement
    }

    /**
     * Termina a conexao com o banco de dados e libera as referencias a resultSet, statement, preparedStatement.
     */
    fun close() {
        this.resultSet?.close()
        this.statement?.close()
        this.preparedStatement?.close()
        this.connection?.close()
    }

    /**
     * Commit as alteracoes feitas no banco de dados.
     */
    fun commit(){
        this.connection?.commit()
    }
}
