package br.com.alura.bytebank.teste

import br.com.alura.bytebank.exception.SaldoInsuficienteException

fun testaPilha(){
    fun funcao1() {
        println("início funcao1")
        try {
            funcao2()
        } catch (e: SaldoInsuficienteException){
            e.printStackTrace()
            println("SaldoInsuficienteException foi pegada")
        }
        println("fim funcao1")
    }

    fun funcao2() {
        println("início funcao2")
        for (i in 1..5) {
            println(i)
            throw SaldoInsuficienteException()
            //nesse caso vai ser lançado uma instancia de alguma classe que é uma exceção
        }
        println("fim funcao2")

    }

}