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
        nuevoMail.setTo(mailWrapper.to)
        nuevoMail.setSubject(mailWrapper.subject!!)
        nuevoMail.setText(mailWrapper.message!!)

        javaMailSender.send(nuevoMail)
    }
}