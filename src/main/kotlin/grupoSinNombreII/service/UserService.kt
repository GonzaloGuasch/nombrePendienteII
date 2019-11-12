package grupoSinNombreII.service

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.User
import grupoSinNombreII.repository.BookRepository
import grupoSinNombreII.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(private val userRepository: UserRepository,
                  private val bookService: BookService) {

    fun create(user: User) = userRepository.save(user)
    fun findById(id: Long) = userRepository.findById(id)
    fun findAll() = userRepository.findAll()
    fun findByName(userName: String) = userRepository.findByName(userName)
    fun addBookToWishList(name: String, bookName: String) {
        println(name)
        println(bookName)
        val book = bookService.findByName(bookName)
        println(book)
        userRepository.findByName(name).addBookToWishList(book!!)
    }

}