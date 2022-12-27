import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LinkedStackTest {

    @Test
    fun test() {
        val sut = LinkedStack()

        assertEquals(true, sut.isEmpty)
        assertEquals(0, sut.size)
        assertNull(sut.pop())

        sut.push("World!")

        assertEquals(false, sut.isEmpty)
        assertEquals(1, sut.size)

        sut.push("Hello")

        assertEquals(false, sut.isEmpty)
        assertEquals(2, sut.size)
        assertEquals("Hello", sut.pop())
        assertEquals(false, sut.isEmpty)
        assertEquals(1, sut.size)
        assertEquals("World!", sut.pop())
        assertEquals(true, sut.isEmpty)
        assertEquals(0, sut.size)
        assertNull(sut.pop())
    }
}
