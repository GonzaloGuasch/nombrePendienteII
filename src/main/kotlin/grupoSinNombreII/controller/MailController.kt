package grupoSinNombreII.controller

import grupoSinNombreII.model.MailWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MailController {

       @Autowired
       private lateinit var javaMailSender: JavaMailSender

    @PostMapping("/mail")
    fun enviarMail(@RequestBody mailWrapper: MailWrapper) = this.sendEmail(mailWrapper);

    fun sendEmail(mailWrapper: MailWrapper){
        val nuevoMail = SimpleMailMessage()
        val message =   "Gracias por elegirnos \n" +
                        "el libro ${mailWrapper.bookname} llegara pronto ;) \n" +
                        "Saludos. Book 9-3/4!"

        nuevoMail.setTo(mailWrapper.to)
        nuevoMail.setSubject("Compra exitosa!")
        nuevoMail.setText(message)

        javaMailSender.send(nuevoMail)
    }
}