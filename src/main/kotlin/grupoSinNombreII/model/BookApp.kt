package grupoSinNombreII.model

import javax.persistence.*

@Entity
class BookApp(
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        private val registedUsers: MutableList<User>  = mutableListOf(),
        @Id @GeneratedValue
        private var id: Long = 0
) {

    fun amountOfUsers(): Int = registedUsers.size
    fun registerUser(newUser: User, password: String) {
       newUser.setPassWord(password)
        this.registedUsers.add(newUser)
    }

    fun logInUser(userName: String, userPassword: String): Boolean {
        var res = false
        this.registedUsers.map {user -> res = user.userName == userName &&
                                              user.password == userPassword }
        if(!res){
            throw Exception("Check your password or your user name")
        }else{
            return res
        }
    }

}