package grupoSinNombre.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Book(
        var name: String,
        var authorName: String,
        @ManyToMany(mappedBy = "user")
        val genders: MutableList<String>,
        var releaseYear: Int,
        var amountOfPages: Int,
        var priceInPesos: Int,
        @Id @GeneratedValue
        val id: Long = 0
)
