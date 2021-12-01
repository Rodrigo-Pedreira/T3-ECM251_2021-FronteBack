package models;

import kotlinx.serialization.Serializable

/**
 * Representa uma entrada da tabela de reviews.
 * @param id Chave primaria identificadora.
 * @param idUser Chave do usuario autor.
 * @param idFilm Chave do filme.
 * @param review Texto da review.
 * @param likes Quantidade de likes.
 * @param score Pontuacao da review.
 * @param date Data de publicacao.
 */
@Serializable
data class Review (
    val id : Int,
    val idUser : Int,
    val idFilm : Int,
    val review : String,
    val likes : Int,
    val score : Double,
    val date : String,
)
