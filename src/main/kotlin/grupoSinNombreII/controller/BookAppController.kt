package grupoSinNombreII.controller

import grupoSinNombreII.model.BookApp
import grupoSinNombreII.model.LoginWrapper
import grupoSinNombreII.model.RegisterWrapper
import grupoSinNombreII.model.WishListWrapper
import grupoSinNombreII.service.BookAppService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("/app")
class BookAppController(var bookAppService: BookAppService) {

    private var bookApp: BookApp = BookApp()

    @RequestMapping("/")
    fun index(): String = "Book app controller funca"

    @PostMapping("/login")
    fun canLogin(@RequestBody loginWrapper: LoginWrapper) = bookAppService.canLogin(this.bookApp, loginWrapper)

    @PostMapping("/register")
    @ResponseBody
    fun register(@RequestBody registerWrapper: RegisterWrapper) = bookAppService.register(this.bookApp, registerWrapper)

    @PostMapping("/addToWishlist")
    fun addToWishList(@RequestBody wishlistWrapper: WishListWrapper) = bookAppService.addToWishList(this.bookApp, wishlistWrapper)
}