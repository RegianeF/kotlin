package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco
import java.lang.NumberFormatException

fun testaExpressao() {
    println("início main")
    val entrada: String = "1.0"


    //try é uma expressão - LEMBRAR
    val valorRecebido: Double? = try {
        //esse Double? com ponto de interrogação significa que
        //esse double pode ser nulo, por isso é Necessario o uso do ?
        //e lá embaixo o null pra referir a null.
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
        e.printStackTrace()
        null
    }

    //adiconar uma taxa no valor:
    //criar uma taxa indicar que é um double, mas pode ser nulo...
    //se valor recebido for diferente de nulo então faça
    val valorComTaxa : Double? = if (valorRecebido != null){
        valorRecebido + 0.1
    } else{
        null
        //se não devolva null
    }
    //o Kotlin não deixa trabalhar com valores nulos,
    // então por isso é necessario a verificação

    //também pode trabalhar com o when: Exemplo:
    /*val valorComTaxa: Double? = when {
        valorRecebido != null -> {
            valorRecebido + 0.1
        }
        else -> {
            null
        }
    }*/


    if (valorComTaxa != null){
        println("Valor recebido: $valorComTaxa")
    } else{
        println("Valor inválido")
    }

    //nesse caso foi feito uma verificação se o valor é valido e depois
    //se ele for válido retorna o valor com a escrita: Valor recebido
    //se não joga um erro - valor inválido

    /*try{
        val valor: Double = entrada.toDouble()
        println("Valor recebido: $valor")
    } catch (e: NumberFormatException){
        println("Problema na conversão")
        e.printStackTrace()
    }*/
    //nesse caso foi feito um valor que converte e assim podendo passar com exception algum erro


    /*try {
        10 / 0
    } catch (e: ArithmeticException) {
        println("ArithmeticException foi pegada")
    }*/

    funcao1()
    println("fim main")
}

fun funcao1() {
    println("início funcao1")
    funcao2()
    println("fim funcao1")
}


fun funcao2() {
    println("início funcao2")
    try {
        for (i in 1..5) {
            println(i)
            val endereco = Any()
            endereco as Endereco

        }
        //tem que cuidar onde coloca pq se der erro, capaz de fechar uma função..
        //nesse caso vai gerar um só erro, pq não ta dentro do bloco de for
        //assim ele não vai execultar o for e tentar lê o prx código
    } catch (e: ClassCastException) {
        e.printStackTrace()
        //ao digitar var.printStrackTrace ele passa o erro com a mensagem
        //e as linhas do código que está causando esse erro.
        //Se não passar o erro certo, não dá certo.
        println("ClassCastException foi pegada! ")
    }
    println("fim funcao2")
}

fun funcao3() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        try {
            endereco as Endereco
            //dentro de try coloca o que precisa ser feito
        } catch (e: ClassCastException) {
            //variavel/parametro que retorna o erro
            //aqui se der erro, roda o codigo, mas aparece esse erro
            //nesse caso vai retornar um erro toda vez que o for precisar ir, ou seja, até 5
            println("ClassCastException foi pegada")
        }
    }
}