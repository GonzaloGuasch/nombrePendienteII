package grupoSinNombreII.repository

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Message
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.RequestParam

interface MessageRepository: CrudRepository<Message, Long> {

    @Query("SELECT * FROM message WHERE lower(name) = :lower(aName)", nativeQuery = true )
    fun findByName(@RequestParam("aName") aName : String)
}