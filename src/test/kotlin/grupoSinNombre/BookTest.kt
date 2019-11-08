package grupoSinNombre

import grupoSinNombre.model.Book
import grupoSinNombre.model.Genre
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