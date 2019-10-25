package grupoSinNombre

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class BooksApplication

fun main(args: Array<String>) {
	runApplication<BooksApplication>(*args)
}
