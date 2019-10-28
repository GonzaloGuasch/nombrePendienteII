package grupoSinNombre.persistencia

import grupoSinNombre.model.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Long> {

    @Query("SELECT * FROM book WHERE name = :aName", nativeQuery = true)
    fun findByName(@Param("aName") aName : String): Book?
}