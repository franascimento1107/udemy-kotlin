package fundamentos

fun main() {

    var nome : String? = "Gustavo"
    println(nome)
    println(nome?.length)

    nome = null
    println(nome)

    var numero: Int?

    numero = null
    println(numero ?: 0)

}