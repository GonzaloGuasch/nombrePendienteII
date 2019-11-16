package grupoSinNombreII

import grupoSinNombreII.model.Genre
import grupoSinNombreII.model.Book
import org.junit.Assert
import org.junit.jupiter.api.Test

class BookTest {

    @Test
    fun aBookHasANameAuthorReleaseYearAmountOfPagesAndAPrice(){
        val aBook = Book("Tokio blues", "Murakami", Genre.PINKNOVEL, 1987, 454, 100)
        Assert.assertEquals("Tokio blues", aBook.name)
        Assert.assertEquals("Murakami", aBook.authorName)
        Assert.assertEquals("PINKNOVEL", aBook.genre.name.toString())
    }

}