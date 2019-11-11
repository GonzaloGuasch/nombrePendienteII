package grupoSinNombre.controller

import grupoSinNombre.service.BookService
import grupoSinNombre.model.Book
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("books")
class BookController(private val bookService: BookService) {

    @RequestMapping("/")
    fun index(): String = "Chequeo que el controller funcione correctamente"

    @PostMapping("/new")
    fun create(@RequestBody book: Book) = bookService.create(book)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = bookService.findById(id)

    @GetMapping("/books")
    fun findAllBooks() = bookService.findAll()

    @GetMapping("/name/{name}")
    fun findAllBooks(@PathVariable name: String) = bookService.findByName(name)

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String) = bookService.findByName(name)

    @GetMapping("/author/{author_name}")
    fun findBookByAuthor(@PathVariable author_name: String) = bookService.findByAuthorName(author_name.toLowerCase())

}