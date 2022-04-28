package fundamentos

class Primeira(val nome: String, val endereco: String, val idade: Int) {

    fun criaPrimeiraClasse(): Primeira {
        return Primeira("Gustavo", "Santa Efigenia", 24)
    }
}

class Segunda(nome: String, endereco: String, idade: Int) {
    companion object {
        fun criaComValores(): Segunda {
            return Segunda("Gustavo", "Santa Efigenia", 24)
        }

        fun criaClone(primeira: Primeira): Segunda {
            return Segunda(primeira.nome, primeira.endereco, primeira.idade)
        }

    }
}

fun main() {
    val primeira = Primeira("XXX", "YYY", 0).criaPrimeiraClasse()
    val segunda = Segunda.criaClone(primeira)
}