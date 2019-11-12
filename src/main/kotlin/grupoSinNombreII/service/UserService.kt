package grupoSinNombreII.service

import grupoSinNombreII.model.User
import grupoSinNombreII.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(private val userRepository: UserRepository) {

    fun create(user: User) = userRepository.save(user)
    fun findById(id: Long) = userRepository.findById(id)
    fun findAll() = userRepository.findAll()
    fun findByName(userName: String) = userRepository.findByName(userName)
}