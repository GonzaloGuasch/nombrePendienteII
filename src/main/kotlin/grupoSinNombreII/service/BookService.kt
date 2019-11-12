package grupoSinNombreII.service

import grupoSinNombreII.model.Book
import grupoSinNombreII.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(var bookRepository: BookRepository) {

    fun create(book: Book) = bookRepository.save(book)

    fun findById(id: Long) = bookRepository.findById(id)

    fun findAll() = bookRepository.findAll()

    fun findByName(name : String) = bookRepository.findByName(name)
}