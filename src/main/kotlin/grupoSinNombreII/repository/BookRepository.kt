package grupoSinNombreII.repository

import grupoSinNombreII.model.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.data.domain.PageRequest



@Repository
interface BookRepository: CrudRepository<Book, Long> {

    @Query("SELECT * FROM book WHERE lower(name) = :aName", nativeQuery = true )
    fun findByName(@RequestParam("aName") aName : String): Book?

    @Query("SELECT * FROM book WHERE lower(author_name) = :anAuthorName", nativeQuery = true)
    fun findByAuthorName(anAuthorName: String) : MutableList<Book>

    @Query("SELECT * FROM book b ORDER BY b.votes DESC LIMIT 5", nativeQuery = true)
    fun topN() : MutableList<Book>
}

