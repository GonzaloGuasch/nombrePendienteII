package grupoSinNombreII.repository

import grupoSinNombreII.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: CrudRepository<User, Long> {

    @Query("SELECT * FROM user WHERE userName = :userName", nativeQuery = true)
    fun findByName(@Param("userName") userName : String): User
}