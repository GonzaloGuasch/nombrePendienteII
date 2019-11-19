package grupoSinNombreII.service

import grupoSinNombreII.model.*
import grupoSinNombreII.repository.BookAppRepository
import grupoSinNombreII.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookAppService(var bookAppRepository: BookAppRepository, var bookRepository: BookRepository){

    fun canLogin(bookApp: BookApp, loginWrapper: LoginWrapper): Boolean {
       return bookApp.logInUser(loginWrapper.username!!, loginWrapper.password!!)
    }

    fun register(bookApp: BookApp, registerWrapper: RegisterWrapper): User {
        var newUser = User(registerWrapper.name!!, registerWrapper.email!!, registerWrapper.birth!!)
       val userWithPassword =  bookApp.registerUser(newUser, registerWrapper.password!!)
        return userWithPassword
    }

    fun addToWishList(bookApp: BookApp, wishlistWrapper: WishListWrapper): User {
        val user: User = bookApp.findUser(wishlistWrapper.username)
        val book: Book = this.bookRepository.findByName(wishlistWrapper.bookName)!!
        user.addBookToWishList(book)
        return user
    }

    fun findByname(bookApp: BookApp, username: String): Any {
       return bookApp.findUser(username);
    }

    fun getAllUsers(bookApp: BookApp): MutableList<User> {
        return bookApp.getAllUser()
    }
}