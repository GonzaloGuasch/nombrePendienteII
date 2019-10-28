package grupoSinNombre.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins= ["http://localhost:3000"])
@RequestMapping("users")
class UserController {

    @RequestMapping("/")
    fun index(): String = "Chequeo que el controller funcione correctamente"
}