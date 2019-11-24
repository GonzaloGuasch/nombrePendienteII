package grupoSinNombreII.service

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Message
import grupoSinNombreII.model.User
import grupoSinNombreII.repository.BookRepository
import grupoSinNombreII.repository.MessageRepository
import grupoSinNombreII.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MessageService(private val msjRepository: MessageRepository) {

    fun create(aMsj: Message) = msjRepository.save(aMsj)
    fun findById(id: Long) = msjRepository.findById(id)
    fun findAll() = msjRepository.findAll()
    fun findByName(aName: String) = msjRepository.findByName(aName)
}