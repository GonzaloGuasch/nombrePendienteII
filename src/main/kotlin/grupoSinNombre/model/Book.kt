package grupoSinNombre.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book(
        var name: String,
        var authorName: String,
        val genders: MutableList<String>,
        var releaseYear: Int,
        var amountOfPages: Int,
        var priceInPesos: Int,
        @Id @GeneratedValue
        val id: Long = 0
)
