package grupoSinNombreII.service

import grupoSinNombreII.model.BookApp
import grupoSinNombreII.model.LoginWrapper
import grupoSinNombreII.repository.BookAppRepository
import grupoSinNombreII.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookAppService(var bookAppRepository: BookAppRepository){


    fun canLogin(bookApp: BookApp, loginWrapper: LoginWrapper): Boolean {
        println(loginWrapper)
        println(loginWrapper.password)
        println(loginWrapper.username)
       return bookApp.logInUser(loginWrapper.username!!, loginWrapper.password!!)
    }
}