package mike.sample.kotlin

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/11/27
 * @description:
 */

class A {
    var mCount = 10

    fun getCount(): Int {
        return mCount
    }
}

class B(val a: A?) {
    var count = 0
        get() {
            return a?.getCount() ?: 0
        }
    val countVal: Int
        get() {
            return a?.getCount() ?: 0
        }

}


fun main() {
    val a = A()
    val b = B(a)
    println("b = ${b.count}")
    println("b = ${b.countVal}")
    a.mCount = 20
    println("b = ${b.count}")
    println("b = ${b.countVal}")


}