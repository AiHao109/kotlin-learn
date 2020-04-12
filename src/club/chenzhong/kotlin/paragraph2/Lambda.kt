package club.chenzhong.kotlin.paragraph2

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val sum2 = { x: Int, y: Int -> x + y }
var sum3: (Int, Int) -> Int = { x, y -> x + y }
var foo = { x: Int ->
    val y = x + 1
    y
}

fun main() {
    println("sum=${sum}, sum2=$sum2, sum3=$sum3, foo=$foo")
    println(sum(1, 2))
    println(sum2(5, 6))
    println(sum3(7, 10))
    println(foo(1))
    foo(1)
}