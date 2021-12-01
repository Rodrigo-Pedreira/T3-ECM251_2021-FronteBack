package shared;

/**
 * Classe que define algumas constantes ("Macros").
 */
class SharedPath {
    companion object{
//        const val STRING_CONNECTION_JDBC = "jdbc:sqlite:bancot3t4.db"

        /**
         * Referencia ao banco de dados.
         */
        const val STRING_CONNECTION_JDBC = "jdbc:mariadb://192.168.56.104:3306/SiteReviews"

        /**
         * Nome do usuario para conectar ao banco de dados.
         */
        const val DATABASE_USERNAME      = "admin"

        /**
         * Senha de um usuario para conectar ao banco de dados
         */
        const val DATABASE_PASSWORD      = "admin"
    }
}
