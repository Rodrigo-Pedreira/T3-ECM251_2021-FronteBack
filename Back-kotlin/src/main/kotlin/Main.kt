import controller.MainController
import testdrivers.FilmDAOTestDrive
import testdrivers.ReviewDAOTestDrive
import testdrivers.UserDAOTestDrive

/**
 * Main class usada para comeca o programa.
 */
fun main() {
    MainController.runKtor()    // Roda o programa

//    Testes:

//    val id : Int = 11
//    MainController.testDAOs(id,id,id)

//    FilmDAOTestDrive.selectTest(id)
//    FilmDAOTestDrive.selectFromStringTest("Inser", "many", date="003")

//    UserDAOTestDrive.selectTest(id)

//    ReviewDAOTestDrive.selectTest(id)
}