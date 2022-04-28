package funcdamentos

fun main() {
    var numero = 25
    when (numero) {
        5 -> println("Cinco")
        6, 7, 8 -> println("Seis, Sete ou Oito")
        in 11..15 -> println("Entre Onze e Quinze")
        !in 16..20 -> println("Fora de 16 e 20")
        else -> println("Não mapeado!")
    }

    when {
        comecaComOi(5) -> println ("5")
        comecaComOi("oi, tudo bem?") -> println ("começou com oi")
    }
}

fun comecaComOi(x: Any): Boolean {
    return when (x) {
        is String -> x.startsWith("oi")
        else -> false
    }
}