package br.com.alura.bytebank.paradigmaFuncional

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno


fun testaHOF() {

    /*fun somaReceiver(a: Int,b: Int,resultado: Int.(String) -> Unit){}
    nesse caso como int.(String), esta sendo passado por paramentro, pode sim ter um apelido em receiver
    porque de fato é um paramentro, mas mesmo assim é possível ter o acesso as propriedades do this*/

    somaReceiver(1, 15, resultado = {
        println(this)
    }) //foi passado atraves de uma label

    //esse que não tem receiver pode implementar um apelido por causa do it, ja com o receiver não se pode aplicar apelido
    soma(1, 5, resultado = { println(it) })  //foi passado atraves de uma label
    val autenticavel = object : Autenticavel { //aqui confere se a senha é igual a partir do autenticavel
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }

    SistemaInterno().entra(autenticavel, 1234, autenticado = { //é possivel colocar uma label p/ajudar na manutenção
        println("Realizar um pagamento") //nesse caso é possivel realizar um print se a validação ocorre
    })
    println()

    val sistema = SistemaInterno()
        sistema.entra(autenticavel, 1234, autenticado = { //é possivel colocar uma label p/ajudar na manutenção
        println("Realizar um pagamento") //nesse caso é possivel realizar um print se a validação ocorre
    }) //aqui é feito por aqui mesmo o print
    sistema.entraReceiver(autenticavel, senha = 1234, autenticado = {
        pagamento()
    }) //esse aqui busca la de sistema interno

}


fun soma(a: Int, b: Int, resultado: (Int) -> Unit) { //a,b é uma variavel normal/resultado uma expressão do tipo função
    println("Soma sendo efetuada")
    resultado(a + b)
}
//tem que lembrar de executar pq é considerado uma lazy evaluation

fun somaReceiver(a: Int,b: Int,resultado: Int.() -> Unit){
    //nesse caso é implementado como se fosse uma extesion Int.() e tá pronto para usar
    val total = a + b
    total.resultado() //implementado como se fosse um membro
    println("Resultado")
}