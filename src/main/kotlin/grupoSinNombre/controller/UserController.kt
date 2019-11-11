package grupoSinNombre.controller

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins= ["http://localhost:3000"])
@RequestMapping("users")
class UserController {

    @RequestMapping("/")
    fun index(): String = "Chequeo que el controller funcione correctamente"

    @PostMapping("/create")
    fun create(){

    }
}