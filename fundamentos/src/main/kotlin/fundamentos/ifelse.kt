package fundamentos

fun main() {
    resultadoPorNota(3)
    resultadoPorNota(5)
    resultadoPorNota(9)

    println(parOuImpar(8))
    println(parOuImpar(15))
}

fun resultadoPorNota(nota: Int) {
    if (nota >= 7) {
        println("Passou!")
    } else if (nota >= 4) {
        println("Recuperação!")
    } else {
        println("Reprovou!")
    }
}

fun parOuImpar(numero: Int): String {
    return if (numero %2 == 0) {
        "Par"
    } else {
        "Impar"
    }
}