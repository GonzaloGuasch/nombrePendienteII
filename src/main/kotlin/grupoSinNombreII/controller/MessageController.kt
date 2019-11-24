package grupoSinNombreII.controller

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Message
import grupoSinNombreII.service.MessageService
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("/message")
class MessageController(var messageService : MessageService) {

    @RequestMapping("/")
    fun index(): String = "Working"

    @PostMapping("/new")
    fun create(@RequestBody message : Message) = messageService.create(message)

    @GetMapping("/id/{id}")
    fun findById(@PathVariable id: Long) = messageService.findById(id)

    @GetMapping("/messages")
    fun findAllBooks() = messageService.findAll()

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String) = messageService.findByName(name)
}