package br.com.alura.bytebank.collection

fun testaMapAssociete() {
    val pedidos = listOf(
        Pedido(1, 20.0), //esse pedido aqui é a classe Pedido
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )

    println(pedidos)

    //para usar Associete é sempre preciso percorrer e se faz através do proprio pedido
    //então o proprio pedido irá percorrer para conseguir associar a o que for chamado
    val pedidosMapeadosAssocieteBy = pedidos.associateBy { pedido -> //aqui  no associeteBy ao colocar o pedido
        //a propria maquina entende que vem de pedido e só pede pra informar por qual valor ela vai alterar, ou começar
        pedido.numero
    }
    println(pedidosMapeadosAssocieteBy)

    //ambos os associete nesse momento vão devolver a mesma coisa

    val pedidosMapeadosAssociete = pedidos.associate { pedido: Pedido -> //pedido vem de Pedido classe
        Pair(pedido.numero, pedido) //busca o numero do pedido e imprime antes de buscar o pedido (que seria tudo,
        // então fica,  o numero no caso, 1 - Pedido(numero 1 - valor 20.0) )
    }
    println(pedidosMapeadosAssociete)

    println(pedidosMapeadosAssociete[1]) //aqui imprime a função de cima, só que apenas o numero que ta na posição de escrita
    //exemplo, se ta escrita 1 será impresso pedido numero=1, valor=20.0 pq só chamou o numero 1

    //associateWith associa com algum outro valor
    val pedidosFreteGratis= pedidos.associateWith { pedido -> //pedido - lista
        pedido.valor > 50.0 //se o valor do pedido for maior que 50.0 retorne true ou false do lado do proprio pedido
    }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(numero = 2, valor = 60.0)]) //nessa caso verifica apenas um valor, mas é preciso
    //buscar por pedido e identificar qual numero e/ou valor


    //O uso do groupBy é feito para agrupar valores, nesse caso true ou false será o retorno
    val pedidosFreteGratisAgrupado = pedidos.groupBy { pedido: Pedido->
        pedido.valor > 50.0
    }

    println(pedidosFreteGratisAgrupado) //nesse caso fica agrupado por true ou falso aqueles que são maiores que 50.0
    println(pedidosFreteGratisAgrupado[true]) //só irá imprimir o que tem true, ou seja, maior que 50.0
    //ai sim esse valores terão frete grátis
    println(pedidosFreteGratisAgrupado[false])

    val nomes = listOf(
        "Alex",
        "Fran",
        "Gui",
        "Ana",
        "Paulo",
        "Maria",
        "Mario",
        "Gisele"
    )

    //esse groupBy é para agrupar pela primeira letra - no caso da lista nome
    val agenda = nomes.groupBy { nome -> // unica coisa que tem dentro de val nomes é nome
        nome.first()  //primeira letra de nomes
    }
    println(agenda)
    println(agenda['A']) //como procurar pela primeira letra, busca um char, char usa '', então se quiser
    //procurar alguma que inicia por A
}

data class Pedido(val numero: Int, val valor: Double)