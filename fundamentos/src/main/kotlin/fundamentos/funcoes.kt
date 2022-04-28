package fundamentos

fun main() {
    falaOi(retornaNome(), 24)
    falaOi(idade = 30, nome = "Daniel")
    falaOi("Daniel")
}

fun retornaNome(): String {
    return "Gustavo"
}

fun falaOi (nome: String, idade: Int = 20) {
    println("Oi ${nome}. Sua idade é ${idade}")
}