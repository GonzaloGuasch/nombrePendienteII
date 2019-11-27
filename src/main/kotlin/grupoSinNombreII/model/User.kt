package grupoSinNombreII.model
import javax.persistence.*

@Entity
class User(
        var userName: String,
        var email: String,
        var birthday_date: String,
        @ElementCollection
        @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        var wishlist: MutableSet<Book> = mutableSetOf(),
        @ElementCollection
        @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        var carrito: MutableSet<Book> = mutableSetOf(),
        @Id @GeneratedValue
        var id: Long = 0,
        var saldo: Long = 0,
        var password: String? = ""
) {
    fun addBookToWishList(book: Book) {
        this.wishlist.add(book)
    }
    fun setPassWord(newPassword: String){
        this.password = newPassword
    }

    fun agregarSaldo(saldoParaSerAgregado: Long) {
        this.saldo += saldoParaSerAgregado
    }

    fun addToCarrito(book: Book) {
        this.carrito.add(book)
    }

    fun comprar() {
        var res = 0;
        this.carrito.forEach { it  -> res += it.priceInPesos  }
        this.saldo -= res;
        this.carrito = mutableSetOf();
    }
}