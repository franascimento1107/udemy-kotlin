package fundamentos

class Pessoa(var nome: String, var idade: Int) {

    override fun toString(): String {
        return "Classe Pessoa = Nome: ${nome}, Idade: ${idade}"
    }

}

fun main() {
    var pessoa = Pessoa("Gustavo Luna", 24)
    println(pessoa)
}