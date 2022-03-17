package br.com.alura.bytebank.collection

fun testaComportamentosMap() {
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        //val pedidos: MutableMap<Int, Double?> = mutableMapOf( - quando precisar de null
        Pair(1, 20.0),
        Pair(2, 64.0),
        3 to 50.0,
        4 to 100.0,
        5 to 100.0,
        6 to 80.0
    )
    /*val valorPedidos = pedidos.getValue(5)
    println(valorPedidos)*/
    //nesse caso estamos tentando acessar a chave 5 que não existe, então através do getValue, como a chave não existe
    //devolve uma exception
    //e se houver um resultado null devolve null
    //não usar o get pq tanto para chaves com valores nulos, ou chaves sem serem adicionadas devolve valor
    //então tudo vira nulo, quando nem sempre é nulo

    val mensagem = pedidos.getOrElse(0) {
        "Não existe esse pedido"
    }
    println(mensagem)
    //nesse caso do getOrElse é preciso passar alem da chave,
    // uma lambda que pode retornar uma mensagem
    //se o valor não for encontrado, se for devolve o valor correspondente a chave exeplo
    //getOrElse(1) = devolve 20
    //getOrElse(36) = devolve uma mensagem: Não existe esse pedido

    val valorDefautlt = pedidos.getOrDefault(36, -1)
    println("valor Default: $valorDefautlt")
    //nesse caso o getOrdefault serve para se não existir aquela chave, devolver um valor padrão
    //esse valor representa que não existe pedido, como o -1, sempre -1 significa que não existe pedido

    println("\nFor - que imprime as chaves: ")
    for (numero in pedidos.keys) {
        println("Essas são as chaves: $numero")
    }
    println("For - que imprime os valores: ")
    for (valor in pedidos.values) {
        println("Esse são os valores: $valor")
    }
    //usando .keys ou .values | é possivel só acessar,o valor especifico de keys ou valores já registrados até o momento

    println()
    val pedidosFiltrados = pedidos.filter { (numero, valor) -> //numero é referente a key e valor é referente a valor
        numero % 2 == 0 && valor > 50.0 //então verifica se a key é par e o valor é maior que 50
    }
    println("Pedidos filtrados por par e valor > 50 $pedidosFiltrados")

    val pedidosAcima = pedidos.filterValues { valor ->
        valor > 50.0
    }
    println("Pedidos filtrados acima de 50, por valor: $pedidosAcima")

    val pedidosPares = pedidos.filterKeys { chave ->
        chave % 2 == 0
    }
    println("Pedidos filtrados por pares, por chave: $pedidosPares")
    println()
    println("Vários prints\n")

    //operator plus and minus
    //nesse caso, os operadores adicionam ou removem, porem apenas naquele momento e não no map original
    println("Adiconado com +:  ${pedidos + Pair(7, 90.0)}") //nesse caso adiciona um elemento, mas não altera o map original
    val plusMap = pedidos + Pair(60, 200.0) //foi criado uma variavel que adiciona um valor mas nao altera o map original
    println("Adicionado com +, a partir de VAL: $plusMap") //apenas na variavel chamada plusMap é possivel ver o valor adicionado, não no pedidos (map original)
    //usar o Pair, evitar com o uso de infix : 8 to 200.0
    println("Varios pedidos adicionados com + e map: ${pedidos + mapOf(70 to 10.0, 61 to 60.0)}") // usado com o infix
    println("Varios pedidos adicionados com + e Pair: ${pedidos + Pair(62, 60.0) + Pair(63, 65.0)}") //varias adições com o Pair
    println("Impressão do map atual: $pedidos") //aqui podemos ver que o map original nao foi alterado

    println("Remover com - : ${pedidos - 6}") //foi removido a chave 6 + valor, porem só nesse momento
    println("Impressão do map atual: $pedidos") //aqui a chave 6 existe, pq é o map original

    println("Remover com o listOf: ${pedidos - listOf(5, 6)}") //removendo uma lista, removendo varios dentro de map, sem afetar o original
    println("Impressão do map atual: $pedidos")
    println()
    //Adicionando e removendo elementos, porem alterando o map original

    pedidos.putAll(setOf(Pair(62, 60.0), Pair(63, 65.0))) //adicionando varios elementos com o Pair - setof
    pedidos.putAll(setOf(70 to 10.0, 71 to 60.0)) //adicionando varios elementos com o infix - setof
    println("Impressão do map atual: $pedidos")
    pedidos.putAll(listOf(70 to 500.0, 71 to 300.0)) //adicionando varios elementos com o infix e o listOf
    //nesse caso foi usado a palavra putAll
    println("Impressão do map atual: $pedidos") //é possivel ver que os valores foram "Atualizados", ou seja, foram trocados valores já estabelecidos
    pedidos += (listOf(70 to 700.0, 71 to 600.0)) //adicionando varios elementos com o infix e o listOf, só que usando
    // a sintaxe "menor" do puttAll : += , funciona igual
    println("Impressão do map atual: $pedidos")

    pedidos.keys.remove(1) //remove a partir da chave, remove tudo
    println("Impressão do map atual: $pedidos")
    pedidos-= 6 //é a sintaxe menor de keys.remove -=
    println("Impressão do map atual: $pedidos")
    pedidos.values.remove(50.0) //remove a chave 3 total, pq o valor é igual e é primeiro 50.0 que apareceu
    println("Impressão do map atual: $pedidos")
    pedidos.values.remove(100.0) //REMOVE a chave 4, pois é a primeira chave que apresenta o valor 100.0
    //tanto que a chave 5 que apresenta o valor de 100.0 continua intacta e viva
    println("Impressão do map atual: $pedidos")

}

fun testaMap() {
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

fun testaMutableMap() {
    //assim como pode ser criado um map
    //pair e to são as mesmas expressões
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0
    )
    println("Pedidos: $pedidos")
    val pedido = pedidos[1] //nesse caso é diferente pq ele pega o valor que está na chave e não a posição da chave


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