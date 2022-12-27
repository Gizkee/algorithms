package unionfind
class QuickFind(n: Int) {

    private val ids: IntArray = IntArray(n)

    init {
        for (i in 0 until n) {
            ids[i] = i
        }
    }

    fun union(p: Int, q: Int) {
        if (p < 0 || p > ids.lastIndex) return
        if (q < 0 || q > ids.lastIndex) return

        val pid = ids[p]
        val qid = ids[q]

        if (pid == qid) return

        for (index in ids.indices) {
            if (ids[index] == pid) {
                ids[index] = qid
            }
        }
    }

    fun connected(p: Int, q: Int): Boolean = ids[p] == ids[q]

    fun find(p: Int) = ids[p]
}
