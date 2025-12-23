package infrastructure.auth.adapter

import io.ktor.server.config.*
import org.mindrot.jbcrypt.BCrypt

class BcryptUtil(
    private val config: ApplicationConfig,
) {
    private val bcryptSalt = config.property("bcrypt.salt").getString()
    private val bcryptVersion = "2a"
    private val bcryptCost = "12"

    private val salt = "$$bcryptVersion$$bcryptCost$$bcryptSalt"

    fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, salt)
    }

    fun verify(hashedPassword: String, password: String): Boolean {
        return BCrypt.hashpw(password, salt) == hashedPassword
    }
}