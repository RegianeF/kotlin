package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import java.lang.NumberFormatException

abstract class Conta(
    var titular: Cliente,
    val numero: Int
) : Autenticavel {
    //também é possível passar uma delagação de forma mais simples
    //mas precisa ser apenas VAL =
    // Autenticavel by titular
    //dessa forma o autenticavel pega o titular - cliente e já delega a responsabilidade de implementação
    var saldo = 0.0
        protected set

    companion object {
        var total = 0
            private set
    }

    init {
        //println("Criando conta")
        total++
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
        //nesse caso ao passar autenticavel, buscamos o titular, o autentica e passamos a senha
        //delagando responsabilidade de implementação para outra classe que já faz uma implementação
        //reutilização de codigo
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(
                mensagem = "O saldo é insuficiente, saldo atual: $saldo, valor a ser subtraído $valor"
            )
        }
        if (!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }
        //nesse caso se a autenticação nao funciona = retorne uma mensagem

       // throw NumberFormatException()

        saldo -= valor
        destino.deposita(valor)
    }
}

class ContaCorrente(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        val valorComTaxa = valor + 0.0
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}

class ContaPoupanca(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }
}