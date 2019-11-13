package grupoSinNombreII.service

import grupoSinNombreII.model.BookApp
import grupoSinNombreII.model.LoginWrapper
import grupoSinNombreII.model.RegisterWrapper
import grupoSinNombreII.model.User
import grupoSinNombreII.repository.BookAppRepository
import grupoSinNombreII.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookAppService(var bookAppRepository: BookAppRepository){

    fun canLogin(bookApp: BookApp, loginWrapper: LoginWrapper): Boolean {
       return bookApp.logInUser(loginWrapper.username!!, loginWrapper.password!!)
    }

    fun register(bookApp: BookApp, registerWrapper: RegisterWrapper): Int {
        var newUser = User(registerWrapper.name!!, registerWrapper.email!!, registerWrapper.birth!!)
       return bookApp.registerUser(newUser, registerWrapper.password!!)
    }
}