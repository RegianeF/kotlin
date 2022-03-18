package br.com.alura.bytebank.paradigmaFuncional

import br.com.alura.bytebank.teste.teste

fun main() {
    testaTipoFuncaoReferencia1()
}

fun testaTipoFuncaoAnonima1() {
    val minhaFuncaoAnonima: () -> Unit = fun() { //= fun() {} essa funcao aqui é uma funcao anonima
        println("Executa como anônima")
    }
    println(minhaFuncaoAnonima()) //o uso de () para executar o retorno será unit,
    // como o uso () será o que tiver na expressão
}

fun testaTipoFuncaoLambda1() {
    val minhaFuncaoLambda: () -> Unit = {
        println("Minha função Lambda")
    }
    println(minhaFuncaoLambda) //então para executar a função lambda colocar o ()junto com a função
    //se não tiver e mandar executar, apenas vai devolver o retorno: () -> kotlim.unit

    //o uso de funções lambdas e funções anônimas e mais complicado quando precisa reutilizar o código para alguma coisa
    //pois ambas ficam muito vinculada as variaveis
}

fun testaTipoFuncaoClasse1() {
    val minhaFuncaoClasse: () -> Unit = Teste1() //foi realizado uma implementação, a partir do tipo teste
    //assim funcionando
    println(minhaFuncaoClasse()) //a partir de () executando
}

fun testaTipoFuncaoReferencia1() {
    //entre () significa que pode passar um parametro nessa função
    //-> significa que recebe um retorno e depois escrever o tipo
    val minhaFuncao = ::teste
    // :: os dois pontos sao usados para pegar a referência de teste e não executar
    //println(minhaFuncao)
    //ao imprimir a minhaFunção na vdd é uma referencia de teste e o retorno foi unit
    //ou seja, nesse momento nao apareceu a mensagem executa teste
    println(minhaFuncao) //colocando () dentro do print a função teste será executada
    //uma função fica dentro de uma variavel, ou seja, uma variavel que pode executar uma função,
    // essa função ja existe que é fun teste

    //ta tudo cagado depois dessas altereações
}

//nesse caso teste foi elaborado para que ser usado a sua referência e não sua execução
//essa fun teste é uma assinatura que seja equivalente a minhaFuncao
fun teste1() { // essa função foi criada para que a val minhaFuncao pode ser inicializada como função
    println("Executa teste")
}
//é possivel fazer a implementação a partir de uma classe, é algo semelhante a uma interface
//assim sobreescrevendo um invoke - invocar

class Teste1 : () -> Unit {
    override fun invoke() {
        println("Executa invoke do teste")
    }

}