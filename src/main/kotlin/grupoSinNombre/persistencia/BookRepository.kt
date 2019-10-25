package grupoSinNombre.persistencia

import grupoSinNombre.model.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Long> {
}