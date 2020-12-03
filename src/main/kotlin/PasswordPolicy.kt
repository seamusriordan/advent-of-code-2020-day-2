class PasswordPolicy {
    var lowerBound: Int = 0
    var upperBound: Int = 0
    var policyCharacter: Char = '0'

    companion object {
        fun build(input: String): PasswordPolicy {
            val matchingGroups = extractInputGroups(input)
            return PasswordPolicy().apply {
                lowerBound = matchingGroups[1].toInt()
                upperBound = matchingGroups[2].toInt()
                policyCharacter = matchingGroups[3].toCharArray().first()
            }
        }

        fun extractInputGroups(input: String): List<String> {
            val inputRegex = Regex("""(\d+)-(\d+)\s+(\w):\s+(\w+)""")
            val match = inputRegex.find(input)
            return match?.groups!!.map {group -> group!!.value}
        }
    }
}