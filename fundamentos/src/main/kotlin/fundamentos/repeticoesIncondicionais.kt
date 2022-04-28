package fundamentos

fun main() {
    loopDe1a10()
    loopDe10a1()
    loopDe2a10()
}

fun loopDe1a10() {

    println("De 1 a 10")
    for(numero in 1 .. 10) {
        println(numero)
    }

}

fun loopDe10a1() {

    println("De 10 a 1")
    for (numero in 10 downTo 1) {
        println(numero)
    }

}

fun loopDe2a10() {

    println("De 2 a 10")
    for(numero in 2 .. 10 step 2) {
        println(numero)
    }

}