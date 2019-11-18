package grupoSinNombreII

import grupoSinNombreII.BooksApplication
import grupoSinNombreII.controller.BookController
import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Genre
import grupoSinNombreII.repository.BookRepository
import grupoSinNombreII.service.BookService
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.After
import org.junit.Before
import org.junit.Test;
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.springframework.beans.factory.annotation.Autowired
//import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SearchByAuthorNameTest {
	var aBook0 = Book("Prueba0", "L", Genre.PINKNOVEL,0,1, 2)
	var aBook1 = Book("Prueba1", "L", Genre.PINKNOVEL,0,1, 2)
	var aBook2 = Book("Prueba2", "L", Genre.PINKNOVEL,0,1, 2)
	var aBook3 = Book("Prueba3", "L", Genre.PINKNOVEL,0,1, 2)
	var aBook4 = Book("Prueba4", "L", Genre.DYSTOPIAN,0,1, 2)
	var aBook5 = Book("Prueba5", "H", Genre.DYSTOPIAN, 0,1, 2)
	var aBook6 = Book("Prueba6", "H", Genre.DYSTOPIAN, 0,1, 2)
	var aBook7 = Book("Prueba7", "H", Genre.DYSTOPIAN, 0,1, 2)
	var aBook8 = Book("Prueba8", "H", Genre.DYSTOPIAN, 0,1, 2)
	var otherBook = Book("other", "otherGuy", Genre.ESSAY, 0,1, 2)
	var books = mutableListOf(aBook0, aBook1, aBook2, aBook3, aBook4, aBook5, aBook6, aBook7, aBook8, otherBook)


	@Autowired
	lateinit var bookRepository : BookRepository

	@Before
	fun saveBooks() {
		for (book in books) {
			bookRepository.save(book)
		}
	}

	@After
	fun dropBooks(){
		for (book in books) {
			bookRepository.delete(book)
		}
	}

	fun mapNames(books : MutableList<Book>) = books.map{ book -> book.name}

	@Test
	fun test1_when_search_by_authorName_H_should_return_four_books(){
		var searchResults = bookRepository.findByAuthorName("H")
		assert(this.mapNames(searchResults).contains("Prueba5"))
		assert(this.mapNames(searchResults).contains("Prueba6"))
		assert(this.mapNames(searchResults).contains("Prueba7"))
		assert(this.mapNames(searchResults).contains("Prueba8"))
		assertFalse(this.mapNames(searchResults).contains("other"))
		assertEquals(4, searchResults.count())
	}

	@Test
	fun test2_when_search_by_authorName_L_should_return_five_books(){
		var searchResults = bookRepository.findByAuthorName("L")
		assert(this.mapNames(searchResults).contains("Prueba0"))
		assert(this.mapNames(searchResults).contains("Prueba1"))
		assert(this.mapNames(searchResults).contains("Prueba2"))
		assert(this.mapNames(searchResults).contains("Prueba3"))
		assert(this.mapNames(searchResults).contains("Prueba4"))
		assertFalse(this.mapNames(searchResults).contains("other"))
		assertEquals(5, searchResults.count())
	}

	@Test
	fun test3_when_search_by_non_existent_authorName_(){
		var searchResults = bookRepository.findByAuthorName("asd")
		print(mapNames(searchResults))
		assertEquals(0, searchResults.count())
	}

	@Test
	fun test4_when_search_by_authorName_H_UpperCase_and_LowCase_should_return_the_same_books_(){
		var searchResults = bookRepository.findByAuthorName("h")
		assert(this.mapNames(searchResults).contains("Prueba5"))
		assert(this.mapNames(searchResults).contains("Prueba6"))
		assert(this.mapNames(searchResults).contains("Prueba7"))
		assert(this.mapNames(searchResults).contains("Prueba8"))
		assertFalse(this.mapNames(searchResults).contains("other"))
		assertEquals(4, searchResults.count())
	}
}
