import org.junit.jupiter.api.Test
import unionfind.WeightedQuickUnion
import kotlin.system.measureNanoTime
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WeightedQuickUnionTest {
    @Test
    fun test() {
        val sut = WeightedQuickUnion(5)

        sut.union(1, 3)
        sut.union(3, 4)

        assertTrue(sut.connected(1, 3))
        assertTrue(sut.connected(1, 4))
        assertTrue(sut.connected(3, 1))
        assertTrue(sut.connected(3, 4))
        assertTrue(sut.connected(4, 1))
        assertTrue(sut.connected(4, 3))
        assertFalse(sut.connected(0, 1))
        assertFalse(sut.connected(0, 2))
        assertFalse(sut.connected(0, 3))
        assertFalse(sut.connected(0, 4))
        assertFalse(sut.connected(1, 2))
        assertFalse(sut.connected(2, 1))
        assertFalse(sut.connected(2, 3))
        assertFalse(sut.connected(2, 4))

        sut.union(0, 4)

        assertTrue(sut.connected(0, 1))
        assertTrue(sut.connected(0, 3))
        assertTrue(sut.connected(0, 4))
        assertTrue(sut.connected(1, 0))
        assertTrue(sut.connected(1, 3))
        assertTrue(sut.connected(1, 4))
        assertTrue(sut.connected(3, 0))
        assertTrue(sut.connected(3, 1))
        assertTrue(sut.connected(3, 4))
        assertTrue(sut.connected(4, 0))
        assertTrue(sut.connected(4, 1))
        assertTrue(sut.connected(4, 3))
        assertFalse(sut.connected(2, 0))
        assertFalse(sut.connected(2, 1))
        assertFalse(sut.connected(2, 3))
        assertFalse(sut.connected(2, 4))
        assertFalse(sut.connected(0, 2))
        assertFalse(sut.connected(1, 2))
        assertFalse(sut.connected(3, 2))
        assertFalse(sut.connected(4, 2))
    }

    @Test
    fun `union 100 000 numbers`() {
        val value = 100_000
        val sut = WeightedQuickUnion(value)

        val unionTime = measureNanoTime {
            for (num in 0 until value - 1) {
                sut.union(num, num + 1)
            }
        }

        println("WeightedQuickUnion union time in nanoseconds: $unionTime")

        val findTime = measureNanoTime {
            sut.find(0)
        }

        println("WeightedQuickUnion find first item root time in nanoseconds: $findTime")

        assertTrue(sut.connected(0, value - 1))
        assertTrue(sut.connected(value - 2, value - 1))
    }
}
