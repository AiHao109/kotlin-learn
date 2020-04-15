package club.chenzhong.kotlin.paragraph2

fun foo(int: Int) = {
    print(int)
}

fun main() {
    listOf(1, 2, 3).forEach { foo(it) }
    println("invoke...")
    listOf(1, 2, 3).forEach { foo(it).invoke() }
    listOf(1, 2, 3).forEach { item -> foo(item) }
    println("()()")
    listOf(1, 2, 3).forEach { item -> foo(item)() }
    foo4(1, 2)
    foo4.invoke(1, 2)
    foo5(1).invoke(2)
    foo5(1)(2)
    changeVar()
    autoRun()
    println(sum3(10, 20, 30))
    println(sumCurringBrief(4)(5)(6))
    println(sumCurring4(-1)(-2)(-3)(-4))
}

//普通函数
fun foo1(x: Int) {
    print(x)
}

fun foo2(x: Int, y: Int): Int {
    return x * y
}

//普通函数，单函数
fun foo3(x: Int, y: Int) = x + y

//={}一定是lambda，如果左侧是fun是lambda表达式函数体
val foo4 = { x: Int, y: Int -> x + y }

fun foo5(x: Int) = { y: Int -> x + y }

//lambda改变函数外结果
var xxx = 0

fun changeVar() {
    listOf(1, 2, 3).filter { it > 0 }.forEach { xxx += it }
    println("xxxx=$xxx")
}

//auto run fun
fun autoRun() {
    { println("自运行函数") }();
    { x: Int -> println(x) }(1)
}

//currying
fun foo6(x: Int): (Int) -> Int {
    return { y: Int -> x + y }
}

fun sum3(x: Int, y: Int, z: Int): Int {
    return x + y + z
}

//暂时没想到不简化的写法
/*
fun sumCurring(x: Int): (y: Int) -> (z: Int) -> Int {
    return {x -> {y + z}}
} */

fun sumCurringBrief(x: Int) = { y: Int ->
    { z: Int -> x + y + z }
}

fun sumCurring4(a: Int) = { b: Int ->
    { c: Int ->
        { d: Int ->
            a + b + c + d
        }
    }
}