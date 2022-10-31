import java.nio.file.Paths

private val USER_HOME = System.getProperty("user.home")

const val APP_NAME = "Currency Viewer"
const val APP_VERSION = "1.0-SNAPSHOT"
val APP_FULL_NAME = String.format("%s v.%s", APP_NAME, APP_VERSION)
val USER_HOME_PATH = Paths.get(USER_HOME ?: "./")
val APP_DB_PATH = Paths.get("db")

fun main(args: Array<String>) {
	println("Hello World!")

	// Try adding program arguments via Run/Debug configuration.
	// Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
	println("Program arguments: ${args.joinToString()}")
}