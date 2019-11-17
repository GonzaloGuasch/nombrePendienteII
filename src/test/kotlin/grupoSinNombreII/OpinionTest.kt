package grupoSinNombreII

import grupoSinNombreII.model.Opinion
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime


class OpinionTest {
    var date = LocalDateTime.now()
    private var opinion = Opinion(1, 2, date, "Este es el cuerpo de la opinion", 0)

    @Test
    fun opinionIsCreate(){
        Assert.assertEquals(0, opinion.id)
        Assert.assertEquals(1, opinion.id_user)
        Assert.assertEquals(2, opinion.id_book)
        Assert.assertEquals(date, opinion.date)
        Assert.assertEquals("Este es el cuerpo de la opinion", opinion.msj)
    }
}