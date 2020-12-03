class PasswordPolicy {
    var lowerBound: Int = 0
    var upperBound: Int = 0
    var policyCharacter: Char = '0'

    companion object {
        fun build(input: String): PasswordPolicy {
            val inputRegex = Regex("""(\d+)-(\d+)\s+(\w):\s+(\w+)""")
            val match = inputRegex.find(input)

            return PasswordPolicy().apply {
                lowerBound = match?.groups?.get(1)!!.value.toInt()
                upperBound = match.groups[2]!!.value.toInt()
                policyCharacter = match.groups[3]!!.value.toCharArray().first()
            }
        }
    }
}