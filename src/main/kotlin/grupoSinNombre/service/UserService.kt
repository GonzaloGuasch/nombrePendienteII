package grupoSinNombre.service

import grupoSinNombre.model.User
import grupoSinNombre.persistencia.UserRepository
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