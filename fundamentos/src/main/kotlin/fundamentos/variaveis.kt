package fundamentos

fun main() {
    var nomeVar = "Daniel"
    val nomeVal = "Luciano"

    println(nomeVar)
    println(nomeVal)

    val idade = 24
    println(idade)
}

class Variavel {

    lateinit var nome: String

    fun inicia() {
        nome = "Teste"
    }
}
