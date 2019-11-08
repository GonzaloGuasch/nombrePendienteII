package grupoSinNombre

import grupoSinNombre.model.Genre
import org.junit.Assert
import org.junit.jupiter.api.Test

class GenreTest {

    @Test
    fun genreSCIFIHasACorrectName(){
        Assert.assertEquals("SCIFI", Genre.SCIFI.name.toString())
    }

    @Test
    fun genreFANTASTICHasACorrectName(){
        Assert.assertEquals("FANTASTIC", Genre.FANTASTIC.name.toString())
    }

    @Test
    fun genreTERRORHasACorrectName(){
        Assert.assertEquals("TERROR", Genre.TERROR.name.toString())
    }

    @Test
    fun genrePINKNOVELHasACorrectName(){
        Assert.assertEquals("PINKNOVEL", Genre.PINKNOVEL.name.toString())
    }

    @Test
    fun genreTHEATERHasACorrectName(){
        Assert.assertEquals("THEATER", Genre.THEATER.name.toString())
    }

    @Test
    fun genreStoryHasACorrectName(){
        Assert.assertEquals("STORY", Genre.STORY.name.toString())
    }

    @Test
    fun genreDETECTIVESTORYHasACorrectName(){
        Assert.assertEquals("DETECTIVESTORY", Genre.DETECTIVESTORY.name.toString())
    }

    @Test
    fun genrePOETRYHasACorrectName(){
        Assert.assertEquals("POETRY", Genre.POETRY.name.toString())
    }
    @Test
    fun genreDYSTOPIANHasACorrectName(){
        Assert.assertEquals("DYSTOPIAN", Genre.DYSTOPIAN.name.toString())
    }
    @Test
    fun genreESSAYHasACorrectName(){
        Assert.assertEquals("ESSAY", Genre.ESSAY.name.toString())
    }
    @Test
    fun genreCOMEDYHasACorrectName(){
        Assert.assertEquals("COMEDY", Genre.COMEDY.name.toString())
    }
}
