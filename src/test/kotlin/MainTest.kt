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
}