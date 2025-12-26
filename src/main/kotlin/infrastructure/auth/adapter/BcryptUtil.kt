package infrastructure.auth.adapter

import io.ktor.server.config.*
import org.mindrot.jbcrypt.BCrypt

class BcryptUtil(
    private val config: ApplicationConfig,
) {
    private val bcryptVersion = "2a"
    private val bcryptCost = "12"
    private val bcryptSalt = config.property("bcrypt.salt").getString()

    private val salt = "$$bcryptVersion$$bcryptCost$$bcryptSalt"

    fun hashPassword(password: String): String = BCrypt.hashpw(password, salt)

    fun verify(hashedPassword: String, password: String): Boolean = BCrypt.hashpw(password, salt) == hashedPassword
}