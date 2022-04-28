package fundamentos

class Carro(var cor: String, val anoFabricacao: Int, var dono: Dono) {
}

data class Dono(var nome: String, var idade: Int) {
}

fun main() {
    var carro = Carro("Branco", 2021, Dono("Gustavo", 24))

    println(carro.cor)

    carro.cor = "Preto"
    println(carro.cor)

    println(carro.dono)
}