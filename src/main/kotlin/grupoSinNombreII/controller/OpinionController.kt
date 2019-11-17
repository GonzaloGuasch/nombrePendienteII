package grupoSinNombreII.controller

import grupoSinNombreII.model.Opinion
import grupoSinNombreII.model.User
import grupoSinNombreII.service.OpinionService
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("/opinion")
class OpinionController(var opinionService : OpinionService) {

    @RequestMapping("/")
    fun index(): String = "Opinion working"

    @PostMapping("/new_opinion")
    fun create(@RequestBody opinion : Opinion) = opinionService.create(opinion)

    @RequestMapping("/{id}")
    fun findById(id : Long) = opinionService.findById(id)

    @RequestMapping("/all_opinion")
    fun findAll() = opinionService.findAll()

    @RequestMapping("/op_book/{id}")
    fun findByBook(id : Long) = opinionService.findByBook(id)

    @RequestMapping("/op_user/{id}")
    fun findByUser(id : Long) = opinionService.findByUser(id)

    @RequestMapping("/find_especific/{id_book}/{id_user}")
    fun findEspecific(id_book : Long, id_user : Long) = opinionService.findEspecific(id_book, id_user)
}