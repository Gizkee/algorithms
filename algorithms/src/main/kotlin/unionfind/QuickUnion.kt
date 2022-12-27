package unionfind

class QuickUnion(n: Int) {

    private val ids: IntArray = IntArray(n)

    init {
        for (i in 0 until n) {
            ids[i] = i
        }
    }

    fun union(p: Int, q: Int) {
        if (p < 0 || p > ids.lastIndex) return
        if (q < 0 || q > ids.lastIndex) return

        val pid = rootOf(p)
        val qid = rootOf(q)

        if (pid == qid) return

        ids[pid] = qid
    }

    fun connected(p: Int, q: Int): Boolean = rootOf(p) == rootOf(q)

    fun find(p: Int) = rootOf(p)

    private fun rootOf(num: Int): Int {
        var i = num
        while (i != ids[i]) {
            i = ids[i]
        }
        return i
    }
}
