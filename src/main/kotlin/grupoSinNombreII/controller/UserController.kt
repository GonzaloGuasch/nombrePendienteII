package grupoSinNombreII.controller

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.User
import grupoSinNombreII.service.UserService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("/users")
class UserController(var userService: UserService) {

    @RequestMapping("/skere")
    fun index(): String = "Testing"

    @PostMapping("/new")
    fun create(@RequestBody user: User) = userService.create(user)

    @GetMapping("/all")
    fun findAllBooks() = userService.findAll()

    @GetMapping("/id/{id}")
    fun findById(@PathVariable id: Long) = userService.findById(id)

    @GetMapping("/userName/{name}")
    fun findByName(@PathVariable name: String) = userService.findByName(name)

    @PostMapping("/addToWishList/{userName}/{bookName}")
    fun addBookToWishList(@PathVariable bookName: String, @PathVariable userName: String)= userService.addBookToWishList(userName, bookName)

}