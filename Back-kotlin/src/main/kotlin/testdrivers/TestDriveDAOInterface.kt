package testdrivers

/**
 * Metodos para realizar testes dos DAOs, estes que interagem com um banco de dados MariaDB.
 */
interface TestDriveDAOInterface {

    /**
     * Testa o metodo que realiza um query SELECT, da linguagem MySQL, de uma entrada especificada.
     * Exibe resultado no console.
     * @param id Chave primaria da entrada que sera selecionada.
     */
    fun selectTest(id: Int = 1) { println("-------------------- SelectTest id: $id --------------------")}

    /**
     * Testa o metodo que realiza um query SELECT, da linguagem MySQL, de todos as entradas de uma tabela.
     * Exibe resultado no console.
     */
    fun selectAllTest()         { println("-------------------- SelectAllTest --------------------")}

    /**
     * Testa o metodo que realiza um INSERT, da linguagem MySQL, de uma entrada, pre definida para este teste.
     * Exibe resultado no console.
     */
    fun insertTest()            { println("-------------------- InsertTest --------------------")}

    /**
     * Testa o metodo que realiza um INSERT, da linguagem MySQL, de mais de uma entrada, pre definidas para este teste.
     * Exibe resultado no console.
     * Exibe resultado no console.
     */
    fun insertManyTest()        { println("-------------------- InsertManyTest --------------------")}

    /**
     * Testa o metodo que realiza um UPDATE, da linguagem MySQL, de uma entrada especificada, os novos dados a serem atualizados estão pre definidos.
     * Exibe resultado no console.
     * @param id Chave primaria da entrada que sera atualizada.
     */
    fun updateTest(id: Int = 1) {
        println("******************** UpdateTeste id: $id ********************")
        selectTest(id)
    }

    /**
     * Testa o metodo que realiza um DELETE, da linguagem MySQL, de uma entrada especificada.
     * Exibe resultado no console.
     * @param id Chave primaria da entrada que sera excluida.
     */
    fun deleteTest(id: Int = 1) {
        println("******************** DeleteTest id: $id ********************")
        selectTest(id)
    }

    /**
     * Invoca todos os metodos de teste desta interface de forma organizada e exibe resultados bem formatados no console.
     */
    fun testAll(select: Int = 1, update: Int = 1, delete: Int = 1) {
        selectTest(select)
        selectAllTest()
        insertTest()
        insertManyTest()
        selectAllTest()
        updateTest(update)
        deleteTest(delete)
        selectAllTest()
    }

    /**
     * Exibe no console uma sequencia de 40 tracos '-' e pula uma linha.
     */
    fun printDash() { println("----------------------------------------\n")}

    /**
     * Exibe no console uma sequencia de 40 asteriscos '*' e pula uma linha.
     */
    fun printStar() { println("****************************************\n")}
}