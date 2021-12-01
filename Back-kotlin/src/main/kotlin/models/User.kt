package models;

import kotlinx.serialization.Serializable

/**
 * Representa uma entrda da tabela de usuarios
 * @param id Chave primaria identificadora.
 * @param name Nome de usuario.
 * @param password Senha.
 * @param email E-mail.
 */
@Serializable
data class User (
    val id:Int,
    val name : String,
    val password : String,
    val email : String,
)
