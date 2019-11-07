package grupoSinNombere

import grupoSinNombre.BooksApplication
import grupoSinNombre.controller.BookController
import grupoSinNombre.model.Book
import grupoSinNombre.persistencia.BookRepository
import grupoSinNombre.service.BookService
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.After
import org.junit.Before
import org.junit.Test;
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
//import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration



@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(BooksApplication::class),
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksApplicationTests {
	var aBook0 = Book("Prueba0", "L",0,1, 2)
	var aBook1 = Book("Prueba1", "H", 0, 1, 2)

	@Autowired
	lateinit var bookRepository: BookRepository

	@Before
	fun saveBooks(){
		bookRepository.save(aBook0)
		bookRepository.save(aBook1)
	}
	@Test
	fun contextLoads() {
	}

	@org.junit.jupiter.api.Test
	fun test0_when_called_should_return_hola(){
		var controller = BookController(BookService(bookRepository))
		assertEquals("Hola", controller.index())
	}
	@org.junit.jupiter.api.Test
	fun test1_when_save_a_book_repository_should_return_the_same_book(){
		var otherBook = bookRepository.findById(1)
		assertEquals(1, otherBook.get().id)
		assertEquals("Prueba0", otherBook.get().name)
		assertEquals("L", otherBook.get().authorName)
		assertEquals(0, otherBook.get().releaseYear)
		assertEquals(1, otherBook.get().amountOfPages)
		assertEquals(2, otherBook.get().priceInPesos)
	}

	@org.junit.jupiter.api.Test
	fun test2_when_search_by_id_with_a_non_existent_id_should_throws_a_exception(){
		var otherBook = bookRepository.findById(42)
		assertThrows<Exception> {  otherBook.get()}
	}

	@org.junit.jupiter.api.Test
	fun test3__when_save_a_lot_of_books_repository_should_return_them(){
		var name_books = bookRepository.findAll().map{book -> book.name}
		var otherBook = Book("", "", 0, 1, 2)
		assert(name_books.contains(aBook0.name))
		assert(name_books.contains(aBook1.name))
		assertFalse(name_books.contains(otherBook.name))
		assertEquals(2, name_books.count())
	}

	@org.junit.jupiter.api.Test
	fun test4__when_search_a__book_by_name_should_return_it(){
		var book = bookRepository.findByName("Prueba0")
		assertEquals(1, book!!.id)
		assertEquals("Prueba0", book!!.name)
		assertEquals("L", book!!.authorName)
		assertEquals(0, book!!.releaseYear)
		assertEquals(1, book!!.amountOfPages)
		assertEquals(2, book!!.priceInPesos)
	}

	@org.junit.jupiter.api.Test
	fun test5__when_search_a__book_by_non_existentname_should_return_null(){
		var book = bookRepository.findByName("Asd")
		assertEquals(null, book)
	}
}
