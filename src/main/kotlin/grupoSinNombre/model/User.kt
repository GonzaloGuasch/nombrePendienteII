package grupoSinNombre.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class User(
        var userName: String,
        var email: String,
        var birthday_date: LocalDate,
        @ManyToMany(fetch = FetchType.EAGER)
        var wishlist: MutableSet<Book> = mutableSetOf(),
       @ManyToMany
       var orderhistory: MutableSet<Book> = mutableSetOf(),
        @Id @GeneratedValue
        var id: Long = 0
){

    fun addBookToWishList(aBook: Book) {  this.wishlist.add(aBook) }
    fun valueOfAllWishList(): Int {
        return wishlist.sumBy { aBookInwishlist -> aBookInwishlist.priceInPesos }
    }
}
