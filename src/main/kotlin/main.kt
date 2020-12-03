fun main(args: Array<String>) {
    println("Hello World!")
}

fun doesPasswordConform(password: String, policy: PasswordPolicy): Boolean {
    val instances = password.toCharArray().filter { char -> char == policy.policyCharacter}.size
    return instances >= policy.lowerBound && instances <= policy.upperBound
}

fun extractPassword(input: String): String {
    return PasswordPolicy.extractInputGroups(input)[4]
}