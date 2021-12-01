package models;

import kotlinx.serialization.Serializable

/**
 * Representa uma entrada da tabela de filmes.
 * @param id Chave principal de identificacao.
 * @param name Nome do filme.
 * @param genre Genero do filme.
 * @param director Diretor do filme.
 * @param data Data de estreia do filme.
 */
@Serializable
data class Film (
    val id : Int,
    val name : String,
    val genre : String,
    val director : String,
    val date : String,
)