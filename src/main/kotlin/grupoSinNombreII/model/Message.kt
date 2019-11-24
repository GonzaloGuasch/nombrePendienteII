package grupoSinNombreII.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="message")
class Message (var name : String,
               var tel : String?,
               var address : String?,
               var message : String,
               var date : LocalDateTime = LocalDateTime.now(),
               @Id @GeneratedValue
               val id: Long = 0)
