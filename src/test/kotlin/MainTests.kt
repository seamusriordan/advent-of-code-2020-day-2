import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTests {
    @Test
    internal fun `1-3 a abcde extracts policy with lower bound 1`() {
        val input = "1-3 a: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals(1, policy.lowerBound)
    }

    @Test
    internal fun `2-3 a abcde extracts policy with lower bound 1`() {
        val input = "2-3 a: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals(2, policy.lowerBound )
    }

    @Test
    internal fun `1-3 a abcde extracts policy with upper bound 3`() {
        val input = "1-3 a: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals(3, policy.upperBound)
    }

    @Test
    internal fun `2-4 a abcde extracts policy with lower bound 4`() {
        val input = "2-4 a: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals(4, policy.upperBound)
    }

    @Test
    internal fun `1-3 a abcde extracts policy with char a`() {
        val input = "1-3 a: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals('a', policy.policyCharacter)
    }

    @Test
    internal fun `2-4 d abcde extracts policy with char d`() {
        val input = "2-4 d: abcde"

        val policy: PasswordPolicy = PasswordPolicy.build(input)

        assertEquals('d', policy.policyCharacter)
    }
}