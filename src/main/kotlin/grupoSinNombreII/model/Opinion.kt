package grupoSinNombreII.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Opinion(var id_user: Int,
                   var id_book : Int,
                   var date : LocalDateTime = LocalDateTime.now(),
                   var msj: String,
                   @Id @GeneratedValue
                   val id : Long)
