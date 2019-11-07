package grupoSinNombre.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Book(
        var name: String,
        var authorName: String,
        var releaseYear: Int,
        var amountOfPages: Int,
        var priceInPesos: Int,
        @Id @GeneratedValue
        val id: Long = 0
)