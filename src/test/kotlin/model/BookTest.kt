package model

import grupoSinNombre.model.Book
import org.junit.Assert
import org.junit.jupiter.api.Test

class BookTest {

    @Test
    fun aBookHasANameAuthorReleaseYearAmountOfPagesAndAPrice(){
        val aBook = Book("Tokio blues", "Murakami", mutableListOf<String>("Fiction", "Novel", "Pink Novel"),1987, 454, 100)

        Assert.assertEquals("Tokio blues", aBook.name)
        Assert.assertEquals("Murakami", aBook.authorName)
        Assert.assertTrue(aBook.genders.contains("Fiction"))
    }

}