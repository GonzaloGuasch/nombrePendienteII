package grupoSinNombre.service

import grupoSinNombre.model.Book
import grupoSinNombre.persistencia.BookRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class BookService(private val bookRepository: BookRepository) {

    fun create(book: Book) = bookRepository.save(book)

    fun findById(id: Long) = bookRepository.findById(id)

    fun findAll() = bookRepository.findAll()

    fun findByName(name : String) = bookRepository.findByName(name)
}