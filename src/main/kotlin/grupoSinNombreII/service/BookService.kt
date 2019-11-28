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

    fun findByAuthorName(name : String) = bookRepository.findByAuthorName(name.toLowerCase())

    fun upVoteBook(id: Long): Book{
       val recoverBook = this.findById(id).get();
        recoverBook.upVote();
        this.create(recoverBook);
        return recoverBook;
    }

    fun downVoteBook(id: Long): Book {
        val recoverBook = this.findById(id).get();
        recoverBook.downVote();
        this.create(recoverBook);
        return recoverBook;
    }

    fun agregarStock(stockParaAgregar: Int, bookname: String): Book {
        val bookRecuperado: Book = this.findByName(bookname)!!
        bookRecuperado.agregarStock(stockParaAgregar)
        this.bookRepository.save(bookRecuperado)
        return bookRecuperado
    }

    fun quitarStcok(stockParaQuitar: Int, bookname: String): Book{
        val bookRecuperado: Book = this.findByName(bookname)!!
        bookRecuperado.quitarStcok(stockParaQuitar)
        this.bookRepository.save(bookRecuperado)
        return bookRecuperado
    }
}