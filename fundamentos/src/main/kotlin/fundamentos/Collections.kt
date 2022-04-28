package fundamentos

fun main() {
    imutable()
    mutable()
    mutableNomes()
    conjunto()
    mutableConjunto()
    mapa()
    mutableMapa()
}

fun imutable() {
    var lista = listOf<Int>(1, 2, 3, 4, 6, 3, 2)
    println("Lista = ${lista}")

    lista.forEach { println(it) }

    println(lista.size)
    println(lista.first())
    println(lista.last())
    println(lista[0])
    println(lista.get(0))

    val pares = lista.filter { it % 2 == 0 }
    println("Os pares da lista = ${pares}")
}

fun mutable() {
    val lista = mutableListOf(4, 3, 1, 15, 6, 2)
    println("Lista Mutavel = ${lista}")

    lista.add(8)
    println("Lista = ${lista}")

    lista.remove(1)
    lista.removeAt(0)
    println("Lista = ${lista}")

    lista[2] = 20
    println("Lista = ${lista}")

    lista.sort()
    println("Lista ordenado = ${lista}")

    lista.shuffle()
    println("Lista embaralhada = ${lista}")
}


fun mutableNomes() {
    val listaNomes = mutableListOf("Gustavo", "Luciano", "Francisco", "Daniel")
    println("Lista = ${listaNomes}")

    listaNomes.sort()
    println("Lista ordenada = ${listaNomes}")
}

fun conjunto() {
    var conjunto = setOf<Int>(1, 2, 3, 4, 6, 3, 2)
    println("Conjunto = ${conjunto}")

    conjunto.forEach { println(it) }
}

fun mutableConjunto() {
    var conjunto = mutableSetOf<Int>(1, 2, 3, 4, 6, 4, 3, 2)
    println("Conjunto = ${conjunto}")

    println("Contém 2? ${conjunto.contains(2)}")
}

fun mapa() {
    var mapaNomeIdade=  mapOf("Gustavo" to 24, "Francisco" to 45, "Daniel" to 20)

    println(mapaNomeIdade)
}

fun mutableMapa() {
    var mapaNomeIdade=  mutableMapOf("Gustavo" to 24, "Francisco" to 45, "Daniel" to 20)

    mapaNomeIdade.put("Bruno", 30)
    mapaNomeIdade["Marcos"] = 60
    println(mapaNomeIdade)

    mapaNomeIdade.remove("Marcos")
    println(mapaNomeIdade)
}