package grupoSinNombreII.repository

import grupoSinNombreII.model.BookApp
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookAppRepository: CrudRepository<BookApp, Long> {
}