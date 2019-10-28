package grupoSinNombre.controller

import grupoSinNombre.service.BookService
import grupoSinNombre.model.Book
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
class BookController(private val bookService: BookService) {

    @RequestMapping("/")
    fun index(): String = "Hola"

    @PostMapping("/new")
    fun create(@RequestBody book: Book) = bookService.create(book)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = bookService.findById(id)

    @GetMapping("/books")
    fun findAllBooks() = bookService.findAll()
}