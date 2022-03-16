package br.com.alura.bytebank.collection

fun main() {
    mutableMap()
}

fun map() {
    //assim como pode ser criado um map
    //pair e to são as mesmas expressões
    val pedidos = mapOf(Pair(1, 20.0), Pair(2, 34.0), 3 to 50.0)
    println(pedidos)
    val pedido = pedidos[3] //nesse caso é diferente pq ele pega o valor que está na chave e não a posição da chave


    //o let também pode retornar um valor
    //let faz uma cópia do it e devolve um resultado
    pedido?.let {
        println("pedido $it")
    }
    //let é usado para nulos, então como [] pode ser nulo é preciso envolver em um let
    //it é o valor 50.0

    //pq usa map.Entry?
    //pq o entry significa cada "pair", cada pair tem uma chave e um valor
    //então o for passa em cada "pair" e encontra a chave e o valor
    for (p: Map.Entry<Int, Double> in pedidos) {
        println("número de pedido: ${p.key}")
        println("valor do pedido: ${p.value}")
    }
}

fun mutableMap() {
    //assim como pode ser criado um map
    //pair e to são as mesmas expressões
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0
    )
    println(pedidos)
    val pedido = pedidos[3] //nesse caso é diferente pq ele pega o valor que está na chave e não a posição da chave


    //o let também pode retornar um valor
    //let faz uma cópia do it e devolve um resultado
    pedido?.let {
        println("pedido $it")
    }
    //let é usado para nulos, então como [] pode ser nulo é preciso envolver em um let
    //it é o valor 50.0

    //pq usa map.Entry?
    //pq o entry significa cada "pair", cada pair tem uma chave e um valor
    //então o for passa em cada "pair" e encontra a chave e o valor
    for (p: Map.Entry<Int, Double> in pedidos) {
        println("número de pedido: ${p.key}")
        println("valor do pedido: ${p.value}")
    }

    pedidos[4] = 50.0 //forma de adicionar
    println(pedidos)
    pedidos.put(5, 80.0) //esse aqui é a mesma coisa que em cima, só que com put
    println(pedidos)
    pedidos[5] = 50.0 //nessa caso a chave 5 foi "atualizada"
    println(pedidos)
    pedidos.putIfAbsent(5, 100.0) //ele add chave e valor, mas se o elemento estiver ocupado, não deixa alterar o valor
    //e devolve o 5 com o valor que foi passado primeiramente, que seria 50.0
    println(pedidos)
    pedidos.putIfAbsent(6, 300.0) //nesse caso como o 6 está livre, foi usado
    println(pedidos)
    pedidos.remove(6) //remove pela chave
    println(pedidos)
    pedidos.remove(3, 100.0)
    println(pedidos) //nesse caso só remove se o valor da chave, se o valor for igual ao anterior explo era 3, 50.0
    //não ira remover pois o valor que diz ali é 100.0
    pedidos.remove(4, 50.0)
    println(pedidos) //como o valor bateu removeu o 4


}



