fun main(args: Array<String>) {
    println("Hello World!")
}


fun extractPassword(input: String): String {
    return PasswordPolicy.extractInputGroups(input)[4]
}