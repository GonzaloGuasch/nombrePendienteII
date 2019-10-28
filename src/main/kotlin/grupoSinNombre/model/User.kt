package grupoSinNombre.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class User(
        var userName: String,
        var email: String,
        var birthday_date: LocalDate,
        @ManyToMany
        var wishlist: MutableSet<Book> = mutableSetOf(),
        @ManyToMany
        var orderhistory: MutableSet<Book> = mutableSetOf(),
        @Id @GeneratedValue
        var id: Long
){

    fun addBookToWishList(aBook: Book) {  this.wishlist.add(aBook) }
    fun valueOfAllWishList(): Int {
        return wishlist.sumBy { aBookInwishlist -> aBookInwishlist.priceInPesos }
    }
}
