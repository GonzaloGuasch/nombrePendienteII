package grupoSinNombreII.service


import grupoSinNombreII.model.LoginWrapper
import grupoSinNombreII.model.RegisterWrapper
import grupoSinNombreII.model.User
import grupoSinNombreII.model.WishListWrapper
import grupoSinNombreII.model.Book
import grupoSinNombreII.model.SaldoWrapper
import grupoSinNombreII.repository.BookRepository
import grupoSinNombreII.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class BookAppService(var bookRepository: BookRepository,
                     var userRepository: UserRepository){

    fun canLogin(loginWrapper: LoginWrapper): Boolean {
        val user = this.userRepository.findByName(loginWrapper.username!!)
        return user != null && user.password == loginWrapper.password

    }

    fun register(registerWrapper: RegisterWrapper): User {
        val newUser = User(registerWrapper.name!!, registerWrapper.email!!, registerWrapper.birth!!)
        newUser.setPassWord(registerWrapper.password!!);
        this.userRepository.save(newUser)
        return newUser
    }

    fun addToWishList(wishlistWrapper: WishListWrapper): User {
        val user: User = this.userRepository.findByName(wishlistWrapper.username)
        val book: Book = this.bookRepository.findByName(wishlistWrapper.bookName)!!
        user.addBookToWishList(book)
        this.userRepository.save(user)
        return user
    }

    fun findByname(username: String): User {
       return this.userRepository.findByName(username);
    }

    fun getAllUsers(): MutableList<User> {
        return this.userRepository.findAll().toMutableList();
    }

    fun addSaldoToUser(saldoWrapper: SaldoWrapper): User {
        val userByName = this.findByname(saldoWrapper.username)
        userByName.agregarSaldo(saldoWrapper.saldo)
        this.userRepository.save(userByName)
        return userByName
    }

    fun addToCarrito(wishlistWrapper: WishListWrapper): User {
        val user: User = this.findByname(wishlistWrapper.username)
        val book: Book = this.bookRepository.findByName(wishlistWrapper.bookName)!!
        user.addToCarrito(book)
        this.userRepository.save(user);
        return user
    }

    fun comprar(username: String): User {
        val user = this.findByname(username)
        user.comprar()
        return user;
    }
}