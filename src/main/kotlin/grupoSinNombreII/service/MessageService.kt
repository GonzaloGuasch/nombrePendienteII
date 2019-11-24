package grupoSinNombreII.service

import grupoSinNombreII.model.Message
import grupoSinNombreII.repository.MessageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MessageService(private val msjRepository: MessageRepository) {

    fun create(aMsj: Message) = msjRepository.save(aMsj)
    fun findById(id: Long) = msjRepository.findById(id)
    fun findAll() = msjRepository.findAll()
}