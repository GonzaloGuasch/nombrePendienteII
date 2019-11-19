package grupoSinNombreII.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="opinion")
data class Opinion(@JoinColumn(name = "id_user", nullable = false)
                   @ManyToOne(optional = false, cascade = [], fetch = FetchType.EAGER)
                   val user : User,
                   @JoinColumn(name = "id_book", nullable = false)
                   @ManyToOne(optional = false, cascade = [], fetch = FetchType.EAGER)
                   val book : Book,
                   var date : LocalDateTime = LocalDateTime.now(),
                   var msj: String,
                   @Id @GeneratedValue
                   val id : Long = 0)
