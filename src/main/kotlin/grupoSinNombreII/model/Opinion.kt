package grupoSinNombreII.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "opinion")
data class Opinion(@Column(name="id_user")
                   @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
                   val id_user : MutableSet<User> = mutableSetOf(),
                   @Column(name="id_book")
                   @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
                   val id_book : MutableSet<Book> = mutableSetOf(),
                   var date : LocalDateTime = LocalDateTime.now(),
                   var msj: String,
                   @Id
                   @GeneratedValue(strategy = GenerationType.AUTO)
                   val id : Long = 0)
