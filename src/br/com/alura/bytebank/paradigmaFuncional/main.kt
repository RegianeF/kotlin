package br.com.alura.bytebank.paradigmaFuncional

import br.com.alura.bytebank.modelo.Endereco

fun main() {
    /*  val endereco = Endereco(logradouro = "rua Aqui", numero = 30)
      val endereoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
      println(endereoEmMaiusculo)
      //essa maneira também deixa o valor em maisculo, porem é cria uma variavel a mais, para pode usar
      //existe como fazer a partir do let
  */
/*    val enderecoEmMaiusculo2 = Endereco(logradouro = "rua Aqui", numero = 30).let {
        endereco -> //endereco é it
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        //usado uma variavel a menos, a partir do let, mas precisando passar para variaveis ainda
    }
    println(enderecoEmMaiusculo2)*/

    /*  Endereco(logradouro = "rua Aqui", numero = 30).let { endereco -> //endereco é it
          "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
      }.let { enderecoEmMaiusculo ->
          println(enderecoEmMaiusculo)
      }*/
    //usando higher order function é possivel usar uma "funcao" dentro de outra "funcao"
    //então assim não foi criado varias funções e o resultado foi o mesmo

    Endereco(logradouro = "rua Aqui", numero = 30).let { endereco -> //endereco é it
        "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
    }.let(::println) //nesse caso a gente pegou a referencia do println
    //ou seja, a partir do let que pode receber qualquer coisa e retornar qualquer coisa
    //é possivel pegar a referencia de println - e retorna o que foi feito acima
    //ou seja, esse ultimo código é o mais enxuto em relação a todos apresentados

    listOf(Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento"))
        .filter { endereco -> endereco.complemento.isNotEmpty() }
        .let (::println)
    //tem umas lista com detalhes, a partir dessa lista é possivel filtrar se ela não está vazia, e também
    //referenciar o println
}
