package model

import grupoSinNombre.model.Genre
import org.junit.Assert
import org.junit.jupiter.api.Test

class GenreTest {

    @Test
    fun genreSCIFIHasACorrectName(){
        Assert.assertEquals("Ciencia ficción", Genre.SCIFI.toShow)
    }

    @Test
    fun genreFANTASTICHasACorrectName(){
        Assert.assertEquals("Fantastico/Ëpico", Genre.FANTASTIC.toShow)
    }

    @Test
    fun genreTERRORHasACorrectName(){
        Assert.assertEquals("Terror", Genre.TERROR.toShow)
    }

    @Test
    fun genrePINKNOVELHasACorrectName(){
        Assert.assertEquals("Novela rosa", Genre.PINKNOVEL.toShow)
    }

    @Test
    fun genreTHEATERHasACorrectName(){
        Assert.assertEquals("Obra de teatro", Genre.THEATER.toShow)
    }

    @Test
    fun genreStoryHasACorrectName(){
        Assert.assertEquals("Cuentos cortos", Genre.STORY.toShow)
    }

    @Test
    fun genreDETECTIVESTORYHasACorrectName(){
        Assert.assertEquals("Novela negra", Genre.DETECTIVESTORY.toShow)
    }

    @Test
    fun genrePOETRYHasACorrectName(){
        Assert.assertEquals("Poesía", Genre.POETRY.toShow)
    }
    @Test
    fun genreDYSTOPIANHasACorrectName(){
        Assert.assertEquals("Distópico", Genre.DYSTOPIAN.toShow)
    }
    @Test
    fun genreESSAYHasACorrectName(){
        Assert.assertEquals("Ensayo", Genre.ESSAY.toShow)
    }
    @Test
    fun genreCOMEDYHasACorrectName(){
        Assert.assertEquals("Comedia", Genre.COMEDY.toShow)
    }
}
