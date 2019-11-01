package model

import grupoSinNombre.model.Book
import grupoSinNombre.model.User
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest{

    @Test
    fun an_user_has_a_mail_a_name_a_wishlist_and_an_orderhistorylist(){
        val aUser = User("Alfredo", "alfredo@gmail.com", LocalDate.now())

        Assert.assertEquals("Alfredo", aUser.userName)
        Assert.assertEquals("alfredo@gmail.com", aUser.email)
        Assert.assertEquals("2019-10-28", aUser.birthday_date.toString())

        Assert.assertEquals(mutableSetOf<Book>(), aUser.wishlist)
        //Assert.assertEquals(mutableSetOf<Book>(), aUser.orderhistory)

    }

    @Test
    fun an_user_can_add_a_book_to_his_wishlist(){
        val aUser = User("albreto", "alberto@gmail.com", LocalDate.now())
        val aBook = Book("It", "Stephen King", 1986, 1138, 1000)

        aUser.addBookToWishList(aBook)

        Assert.assertEquals(1, aUser.wishlist.size)
    }
    @Test
    fun an_user_cannot_add_twice_the_same_book_to_his_wishlist(){
        val aUser = User("albreto", "alberto@gmail.com", LocalDate.now())
        val aBook = Book("It", "Stephen King", 1986, 1138, 1000)

        aUser.addBookToWishList(aBook)
        aUser.addBookToWishList(aBook)
        aUser.addBookToWishList(aBook)

        Assert.assertEquals(1, aUser.wishlist.size)
    }

    @Test
    fun an_user_has_cero_pesos_in_his_wishlist(){
        val aUser = User("albreto", "alberto@gmail.com", LocalDate.now())

        Assert.assertEquals(0, aUser.valueOfAllWishList())
    }
    @Test
    fun an_user_can_know_how_much_money_has_in_the_wishlist_with_one_book(){
        val aUser = User("albreto", "alberto@gmail.com", LocalDate.now())
        val aBook = Book("It", "Stephen King", 1986, 1138, 1000)

        aUser.addBookToWishList(aBook)

        Assert.assertEquals(1000, aUser.valueOfAllWishList())
    }

}