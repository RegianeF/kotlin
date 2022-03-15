package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaNull() {
    //criar um objeto
    //var enderecoNulo: Endereco? = null
    //endereco!!.logradouro | nesse caso vai dar erro Null Pointer - significa que esse endereco nao existe
    var enderecoNulo: Endereco? = Endereco(logradouro = "Rua")
    val logradouro: String? = enderecoNulo?.logradouro
    //println(enderecoNulo?.logradouro?.length) nessa caso é necessario colocar ? em tudo
    enderecoNulo?.let {
        //let pega um objeto e envolve em uma função
        println(it.logradouro) //it é a maneira implicit de chamar endereco
        println(it.logradouro.length)
        //ao usar o let é possivel trabalhar com endereços nulo ou não através do ?
        //sem precisar o ? para todas as chamadas
    }

    //elvis operator
    //elvis operator, pega a variavel l que um int e retorna um int se for nulo
    //se nao for nao retorna e chama o que pede, no exemplo o lenght
    /*val b: String? = null
    val l = b?.length ?: throw IllegalArgumentException("Valor não esperado, não pode ser vazio")
    println("valor: $l")*/

    val c = "isso aqui"
    val j = c.length ?: 0
    println("valor: $j")

    //safe cast
    teste("1") // assim vai devolver null pq la embaixo em teste foi adicionado que pode ser null
    //se fosse um int iria devolver o valor informado, exmplo teste(4) : imprime 4
}
fun teste(valor: Any){
    val numero: Int? = valor as? Int
    println(numero)
}