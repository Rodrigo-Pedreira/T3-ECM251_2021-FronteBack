package dao;

/**
 * Declara metodos que sao usados para interagir com o banco de dados.
 */
interface GenericDAOInterface {
    /**
     * Seleciona uma entrada de uma tabela no banco de dados, usa uma query SELECT.
     * @param id Chave primaria identificadora da entrada a ser selecionada.
     * @return Retorna uma das data classes que corresponde a tabela. Caso id= -1 e campos de texto= "ERROR" ocorreu algum erro.
     */
    fun select(id:Int) : Any

    /**
     * Seleciona todas as entradas de uma tabela no banco de dados, usa uma query SELECT *.
     * @return Retorna uma lista com data classes que correspondem a tabela. Em caso de erro contem somente uma entrada com id= -1 e campos de texto são "ERROR".
     */
    fun selectAll() : List<Any>

    /**
     * Adiciona uma nova entrada numa tabela do banco de dados, usa INSERT.
     * @param obj Data class que sera adicionada
     */
    fun insert(obj: Any)

    /**
     * Adiciona varias entradas numa tabela do banco de dados, usa INSERT.
     * @param list Lista com objetos da data class que serao adicionados, tem de ser da mesma classe.
     */
    fun insertMany(list : List<Any>)

    /**
     * Atualiza uma entrada especifica de uma tabela num banco de dados, usa UPDATE.
     * @param obj Data class que substituira a entrada antiga.
     */
    fun update(obj : Any)

    /**
     * Remove uma entrada especifica de uma tabela no banco de dados, usa DELETE.
     * @param id Chave primaria identificadora da entrada a ser removida.
     */
    fun delete(id : Int)
}
