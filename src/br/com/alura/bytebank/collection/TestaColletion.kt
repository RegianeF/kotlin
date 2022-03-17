package br.com.alura.bytebank.collection

fun testaCopia() {
    val banco = BancoDeNomes()
    banco.salva("ALex")
    banco.salva("Bruna")
    println(banco.nomes)
    println(BancoDeNomes().nomes)

    val banco2 = BancoDeNomes()
    println(banco2.nomes) //utilizando object
}

class BancoDeNomes(){

    val nomes: Collection<String> get() = dados.toList() //convertendo para lista imutavel, "dados" não podem ser alterados
    //variavel nomes que é do tipo collection que é de leitura que sua implementação pege e devolva os dados

    //o metodo salva - salva nome no metodo dados
    fun salva(nome: String) {
        dados.add(nome)
    }
    //ao encapsular dados - fica restrito o uso, fica privado, para pode ser adicionado nome podem ser feito:

    companion object { //foi utilizado o companion object para levar esses dados para qualquer parte do código
        private val dados = mutableListOf<String>() //lista mutavel de strings que podem ser adicionadas
    }
}

fun testaColecao() {
    val nomes: Collection<String> = mutableListOf(
        "Alex",
        "Fran",
        "Gui",
        "Maria",
        "Ana"
    )
    //para passar por [] nome é necessario fazer um for
    //aquele que passa é o "contador = i = ponteiro"
    //então dentro de cada i vai ser impresso o nome pq ele ta absorvendo o nome[n]
    //pois se imprimir nomes, vai apresentar a lista [n,m,]
    for (nome in nomes) {
        println(nome) //A partir de agora o i terá um nome que faça sentido
    }
    println(nomes)
    println("Tem o nome Alex? ${nomes.contains("Alex")}")
    println("Tamanho da coleção ${nomes.size}")
    //quanto mais pra cima for menos elementos de apoio terá - o começo é iterable -> colletion(e mutaveis) -> list, set, map e depois as suas mutaveis
    //alem disso existe aqueles que podem ser apenas lidos ou aqueles que pode mutaveis
}
