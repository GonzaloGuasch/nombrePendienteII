package grupoSinNombreII.controller

import grupoSinNombreII.model.*
import grupoSinNombreII.service.BookAppService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("/app")
class BookAppController(var bookAppService: BookAppService) {

    @RequestMapping("/")
    fun index(): String = "Book app controller funca"

    @PostMapping("/login")
    fun canLogin(@RequestBody loginWrapper: LoginWrapper) = bookAppService.canLogin(loginWrapper)

    @PostMapping("/register")
    @ResponseBody
    fun register(@RequestBody registerWrapper: RegisterWrapper) = bookAppService.register(registerWrapper)

    @PostMapping("/addToWishlist")
    fun addToWishList(@RequestBody wishlistWrapper: WishListWrapper) = bookAppService.addToWishList(wishlistWrapper)

    @GetMapping("/getUser/{username}")
    fun getUser(@PathVariable username: String ) = bookAppService.findByname(username)

    @GetMapping("/all")
    fun getAllUser() = bookAppService.getAllUsers()

    @PostMapping("/addSaldo")
    fun addSaldo(@RequestBody saldoWrapper: SaldoWrapper) = bookAppService.addSaldoToUser(saldoWrapper)

    @PostMapping("/agregarACarrito")
    fun addToCarrito(@RequestBody wishlistWrapper: WishListWrapper) = bookAppService.addToCarrito(wishlistWrapper);

    @CrossOrigin
    @PostMapping("/comprar")
    fun comprar(@RequestBody username: UserName) = bookAppService.comprar(username.username)

}