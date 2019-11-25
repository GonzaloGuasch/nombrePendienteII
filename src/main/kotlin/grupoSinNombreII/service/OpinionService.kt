package grupoSinNombreII.service

import grupoSinNombreII.model.Book
import grupoSinNombreII.model.Opinion
import grupoSinNombreII.repository.OpinionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping

@Service
@Transactional
class OpinionService(private val opinionRepository: OpinionRepository) {

    fun create(opinion : Opinion) = opinionRepository.save(opinion)

    fun findById(id : Long) = opinionRepository.findById(id)

    fun findAll() = opinionRepository.findAll()

    fun findByBook(aId : Long) = opinionRepository.findByBook(aId)

    fun findByUser(aId : Long) = opinionRepository.findByUser(aId)

    fun findEspecific(id_book : Long, id_user : Long) = opinionRepository.findEspecific(id_book, id_user)

    fun deleteById(id: Long) {
        opinionRepository.deleteById(id)
    }
}