package fundamentos

fun main() {
    loopPreAte10()
    loopPosAte10()
}

fun loopPreAte10() {

    println("Pré de 1 a 10")
    var numero = 0
    while (numero<10) {
        println(numero)
        numero++
    }

}

fun loopPosAte10() {

    println("Pós de 1 a 10")
    var numero = 0
    do {
        println(numero)
        numero++
    } while (numero<10)

}