package br.com.alura.bytebank.paradigmaFuncional

fun main() {
    //entre () significa que pode passar um parametro nessa função
    //-> significa que recebe um retorno e depois escrever o tipo
    val minhaFuncao: () -> Unit = ::teste
    // :: os dois pontos sao usados para pegar a referência de teste e não executar
    //println(minhaFuncao)
    //ao imprimir a minhaFunção na vdd é uma referencia de teste e o retorno foi unit
    //ou seja, nesse momento nao apareceu a mensagem executa teste
    println(minhaFuncao()) //colocando () dentro do print a função teste será executada
    //uma função fica dentro de uma variavel, ou seja, uma variavel que pode executar uma função,
    // essa função ja existe que é fun teste
    val minhaFuncaoClass: () -> Unit = Teste() //foi realizado uma implementação, a partir do tipo teste
    //assim funcionando
    println(minhaFuncaoClass()) //a partir de () executando
}

//nesse caso teste foi elaborado para que ser usado a sua referência e não sua execução
//essa fun teste é uma assinatura que seja equivalente a minhaFuncao
fun teste() { // essa função foi criada para que a val minhaFuncao pode ser inicializada como função
    println("Executa teste")
}
//é possivel fazer a implementação a partir de uma classe, é algo semelhante a uma interface
//assim sobreescrevendo um invoke - invocar

class Teste : () -> Unit{
    override fun invoke() {
        println("Executa invoke do teste")
    }

}
