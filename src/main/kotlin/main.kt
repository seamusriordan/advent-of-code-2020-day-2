import java.io.File

fun main() {
    val inputs = File("src/main/resources/input.txt").readLines()

    val validInputs = inputs.filter { input ->
        val policy = PasswordPolicy.build(input)
        val password = extractPassword(input)
        doesPasswordConform(password, policy)
    }

    println("Number passing ${validInputs.size}")
}

fun doesPasswordConform(password: String, policy: PasswordPolicy): Boolean {
    val instances = password.toCharArray().filter { char -> char == policy.policyCharacter }.size
    return instances >= policy.lowerBound && instances <= policy.upperBound
}

fun doesPasswordPositionConform(password: String, policy: PasswordPolicy): Boolean {
    return password[policy.lowerBound - 1] != password[policy.upperBound - 1] &&
            (password[policy.upperBound - 1] == policy.policyCharacter
                    || password[policy.lowerBound - 1] == policy.policyCharacter)
}

fun extractPassword(input: String): String {
    return PasswordPolicy.extractInputGroups(input)[4]
}