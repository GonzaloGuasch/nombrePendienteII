package grupoSinNombreII.model

import javax.persistence.*

@Entity
class BookApp(
        @OneToMany(cascade = [CascadeType.ALL])
        private val registedUsers: MutableList<User>  = mutableListOf(),
        @Id @GeneratedValue
        private var id: Long = 0
) {

    fun amountOfUsers(): Int = registedUsers.size
    fun registerUser(newUser: User, password: String): User {
       newUser.setPassWord(password)
        this.registedUsers.add(newUser)
        return newUser
    }

    fun logInUser(userName: String, userPassword: String): Boolean {
        var res = false
        this.registedUsers.map {user -> res = user.userName == userName &&
                                              user.password == userPassword }

        return res
    }

    fun findUser(username: String): User {
     return this.registedUsers.find { it.userName == username }!!
    }

    fun getAllUser(): MutableList<User> {
        return this.registedUsers
    }

}