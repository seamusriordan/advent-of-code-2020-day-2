import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    internal fun `1-3 a abcde extracts password abcde`() {
        val input = "1-3 a: abcde"

        val password = extractPassword(input)

        assertEquals("abcde", password)
    }

    @Test
    internal fun `2-4 d abrdz extracts password abrdz`() {
        val input = "2-4 d: abrdz"

        val password = extractPassword(input)

        assertEquals("abrdz", password)
    }

    @Test
    internal fun `doesPasswordConform with one char equal to lower bounds passes`() {
        val policy = PasswordPolicy().apply {
            lowerBound = 1
            upperBound = 1
            policyCharacter = 'a'
        }

        assertEquals(true, doesPasswordConform("a", policy))
    }

    @Test
    internal fun `doesPasswordConform with one char below lower bounds fails`() {
        val policy = PasswordPolicy().apply {
            lowerBound = 2
            upperBound = 2
            policyCharacter = 'a'
        }

        assertEquals(false, doesPasswordConform("a", policy))
    }

    @Test
    internal fun `doesPasswordConform with one char above upper bounds fails`() {
        val policy = PasswordPolicy().apply {
            lowerBound = 2
            upperBound = 2
            policyCharacter = 'a'
        }

        assertEquals(false, doesPasswordConform("aaa", policy))
    }

    @Test
    internal fun `doesPasswordConform with two char within bounds passes`() {
        val policy = PasswordPolicy().apply {
            lowerBound = 1
            upperBound = 1
            policyCharacter = 'a'
        }

        assertEquals(true, doesPasswordConform("ba", policy))
    }

    @Test
    internal fun `doesPasswordConform 1-3 a abcde example passes`() {
        val input = "1-3 a: abcde"

        val policy = PasswordPolicy.build(input)
        val password = extractPassword(input)

        assertEquals(true, doesPasswordConform(password, policy))
    }

    @Test
    internal fun `doesPasswordConform 1-3 b cdefg example fails`() {
        val input = "1-3 b: cdefg"

        val policy = PasswordPolicy.build(input)
        val password = extractPassword(input)

        assertEquals(false, doesPasswordConform(password, policy))
    }

    @Test
    internal fun `doesPasswordConform 2-9 c ccccccccc example passes`() {
        val input = "2-9 c: ccccccccc"

        val policy = PasswordPolicy.build(input)
        val password = extractPassword(input)

        assertEquals(true, doesPasswordConform(password, policy))
    }
}