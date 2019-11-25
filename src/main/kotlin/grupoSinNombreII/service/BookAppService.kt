package grupoSinNombreII.service

import grupoSinNombreII.model.LoginWrapper
import grupoSinNombreII.model.BookApp
import grupoSinNombreII.model.RegisterWrapper
import grupoSinNombreII.model.User
import grupoSinNombreII.model.WishListWrapper
import grupoSinNombreII.model.Book
import grupoSinNombreII.model.SaldoWrapper
import grupoSinNombreII.repository.BookAppRepository
import grupoSinNombreII.repository.BookRepository
import grupoSinNombreII.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class BookAppService(var bookAppRepository: BookAppRepository,
                     var bookRepository: BookRepository,
                     var userRepository: UserRepository){

    fun canLogin(bookApp: BookApp, loginWrapper: LoginWrapper): Boolean {
       return bookApp.logInUser(loginWrapper.username!!, loginWrapper.password!!)
    }

    fun register(bookApp: BookApp, registerWrapper: RegisterWrapper): User {
        var newUser = User(registerWrapper.name!!, registerWrapper.email!!, registerWrapper.birth!!)
        val userWithPassword =  bookApp.registerUser(newUser, registerWrapper.password!!)
       //  this.bookAppRepository.save(bookApp)
        return userWithPassword
    }

    fun addToWishList(bookApp: BookApp, wishlistWrapper: WishListWrapper): User {
        val user: User = bookApp.findUser(wishlistWrapper.username)
        val book: Book = this.bookRepository.findByName(wishlistWrapper.bookName)!!
        user.addBookToWishList(book)
        return user
    }

    fun findByname(bookApp: BookApp, username: String): User {
       return bookApp.findUser(username);
    }

    fun getAllUsers(bookApp: BookApp): MutableList<User> {
        return bookApp.getAllUser()
    }

    fun addSaldoToUser(bookApp: BookApp, saldoWrapper: SaldoWrapper): User {
        val userByName = this.findByname(bookApp, saldoWrapper.username)
        userByName.agregarSaldo(saldoWrapper.saldo)
        return userByName
    }

    fun addToCarrito(bookApp: BookApp, wishlistWrapper: WishListWrapper): Any {
        val user: User = bookApp.findUser(wishlistWrapper.username)
        val book: Book = this.bookRepository.findByName(wishlistWrapper.bookName)!!
        user.addToCarrito(book)
        return user
    }

    fun comprar(bookApp: BookApp, username: String): User {
        val user = this.findByname(bookApp, username)
        user.comprar()
        return user;
    }
}