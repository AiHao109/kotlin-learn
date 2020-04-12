package club.chenzhong.kotlin.paragraph2

fun paramFun(arg: () -> Unit) {
    arg.invoke()
}

fun none2None() {
    println("hello i am none.")
}

fun fun1(arg: () -> Unit) {}
fun fun2(arg: (Int, String) -> Unit) {}

fun fun3(arg: (code: Int, msg: String) -> Unit) {}

fun fun4(arg: ((code: Int, msg: String?) -> Unit)?) {}

fun fun5(arg: (Int) -> ((Int) -> Unit)){}

fun fun6(arg: (((Int) -> Int) -> Unit)){}

fun main() {
    paramFun { none2None() }
}