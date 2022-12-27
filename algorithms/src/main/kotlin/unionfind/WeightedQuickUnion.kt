package unionfind

class WeightedQuickUnion(n: Int) {

    private val ids: IntArray = IntArray(n)
    private val sizes: IntArray = IntArray(n)

    init {
        for (i in 0 until n) {
            ids[i] = i
        }
        for (i in 0 until n) {
            sizes[i] = 1
        }
    }

    fun union(p: Int, q: Int) {
        if (p < 0 || p > ids.lastIndex) return
        if (q < 0 || q > ids.lastIndex) return

        val pid = rootOf(p)
        val qid = rootOf(q)

        if (pid == qid) return

        if (sizes[pid] < sizes[qid]) {
            ids[pid] = qid
            sizes[pid] += sizes[qid]
        } else {
            ids[qid] = pid
            sizes[qid] += sizes[pid]
        }
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
