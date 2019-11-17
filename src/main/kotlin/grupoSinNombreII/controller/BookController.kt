package grupoSinNombreII.controller
import grupoSinNombreII.model.Book
import grupoSinNombreII.service.BookService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
class BookController(val bookService: BookService) {

    @RequestMapping("/")
    fun index(): String = "Chequeo que el controller funcione correctamente"

    @PostMapping("/new")
    fun create(@RequestBody book: Book) = bookService.create(book)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = bookService.findById(id)

    @GetMapping("/books")
    fun findAllBooks() = bookService.findAll()

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String) = bookService.findByName(name)

    @GetMapping("/author/{author_name}")
    fun findBookByAuthor(@PathVariable author_name: String) = bookService.findByAuthorName(author_name.toLowerCase())

    @GetMapping("/upvote/{id}")
    fun upvote(@PathVariable id: Long) = bookService.upVoteBook(id);

    @GetMapping("/downvote/{id}")
    fun downvote(@PathVariable id: Long) = bookService.downVoteBook(id);
}