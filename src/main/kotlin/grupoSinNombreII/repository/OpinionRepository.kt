package grupoSinNombreII.repository

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Opinion
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.RequestParam

interface OpinionRepository: CrudRepository<Opinion, Long> {

    @Query("SELECT * FROM opinion WHERE id_book = :id", nativeQuery = true )
    fun findByBook(@RequestParam("id") id : Long) : MutableList<Opinion>

    @Query("SELECT * FROM opinion WHERE id_user = :id", nativeQuery = true )
    fun findByUser(@RequestParam("id") id : Long) : MutableList<Opinion>

    @Query("SELECT * FROM opinion WHERE id_user = :aid_user && id_book = :aid_book", nativeQuery = true )
    fun findEspecific(@RequestParam("aid_book") aid_book : Long, @RequestParam("aid_user") aid_user : Long)
}