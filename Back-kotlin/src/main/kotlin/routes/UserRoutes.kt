package routes

import dao.UserDAO
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import models.User

/**
 * Define as rotas relacionadas a '/user' e seus respectivos comportamentos.
 */
fun Route.userRouting() {
    route("/user"){

        /**
         * Seleciona todas as entradas da tabela de users.
         */
        get ("/selectAll"){
            val users = UserDAO.selectAll()
            if (users[0].id == -1){
                call.respondText("No user registered.",status = HttpStatusCode.NotFound)
            }
            call.respond(users)
        }

        /**
         * Seleciona uma entrada especifica da tabela de users.
         */
        get ("/select/{id}"){
            val id = call.parameters["id"]!!.toInt()
            val user = UserDAO.select(id)
            if (user.id == -1){
                call.respondText("Invalid user id.",status = HttpStatusCode.BadRequest)
            } else {
                call.respond(user)
            }
        }

        /**
         * Adiciona uma entrada a tabela de users.
         */
        post ("/insert") {

            val parameters = call.receiveParameters()
            val name = parameters["name"] ?: return@post call.respondText(
                "Missing user name.",status = HttpStatusCode.NoContent)
            val password = parameters["password"] ?: return@post call.respondText(
                "Missing password.",status = HttpStatusCode.NoContent)
            val email = parameters["email"] ?: return@post call.respondText(
                "Missing email.",status = HttpStatusCode.NoContent)

            UserDAO.insert(User(1,name,password,email))

            call.respondText(
                "User stored correctly",
                status = HttpStatusCode.Created
            )
        }

        /**
         * Atualiza uma entrada da tabela de users.
         */
        put ("/update/{id}") {

            val id = call.parameters["id"]?.toInt() ?: return@put call.respond(
                HttpStatusCode.BadRequest
            )

            val user = UserDAO.select(id)

            if (user.id == -1) {
                call.respondText("No user with such id.",status = HttpStatusCode.NotFound)
            } else {

                val parameters = call.receiveParameters()
                val name = parameters["name"] ?: user.name
                val password = parameters["password"] ?: user.password
                val email = parameters["email"] ?: user.email
                //ou
                /*
                val name = parameters["name"] ?: return@put call.respondText(
                    "Missing user name.",status = HttpStatusCode.NoContent)
                val password = parameters["password"] ?: return@put call.respondText(
                    "Missing password.",status = HttpStatusCode.NoContent)
                val email = parameters["email"] ?: return@put call.respondText(
                    "Missing email.",status = HttpStatusCode.NoContent)
                */

                val newUser = User(id,name,password,email)

                UserDAO.update(newUser)

                call.respondText("Update successful.",status = HttpStatusCode.Accepted)
            }
        }

        /**
         * Exclui uma entrada especifica da tabela de users.
         */
        delete("/delete/{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(
                HttpStatusCode.BadRequest
            )

            val user = UserDAO.select(id.toInt())

            if (user.id == -1){
                call.respondText(
                    "No user with this id.",
                    status = HttpStatusCode.NotFound
                )
            } else {
                UserDAO.delete(id.toInt())
                call.respondText(
                    "User removed successfully.",
                    status = HttpStatusCode.Accepted
                )
            }
        }
    }
}

fun Application.registerUserRoutes() {
    routing {
        userRouting()
    }
}