package grupoSinNombreII.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book(
        var name: String,
        var authorName: String,
        var genre : Genre = Genre.STORY,
        var releaseYear: Int,
        var amountOfPages: Int,
        var priceInPesos: Int,
        var votes: Int = 0,
        var stock: Int = 0,
        @Id @GeneratedValue
        val id: Long = 0
) {
        fun upVote() {
                this.votes = this.votes + 1
        }

        fun downVote() {
                this.votes = this.votes - 1
        }

        fun agregarStock(stockParaAgregar: Int) {
                this.stock += stockParaAgregar;
        }
        fun quitarStcok(stockParaQuitar: Int){
                this.stock -= stockParaQuitar
        }
}