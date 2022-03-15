package br.com.alura.bytebank.teste

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca

fun testaComportamentosConta() {

    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)

    val contaAlex = ContaCorrente(titular = alex, numero = 1000)
    contaAlex.deposita(200.0)

    val fran = Cliente(nome = "Fran", cpf = "", senha = 2)

    val contaFran = ContaPoupanca(numero = 1001, titular = fran)
    contaFran.deposita(300.0)

    println("Titular: ${contaFran.titular.nome} | Número da Conta: ${contaFran.numero}")
    println("Depósito: ${contaFran.saldo}")

    println("Titular: ${contaAlex.titular.nome} | Número da Conta: ${contaAlex.numero}")
    println("Depósito: ${contaAlex.saldo}")

    println()
    println("Depositando na conta do Alex: ")
    contaAlex.deposita(500.0)
    println("Saldo ${contaAlex.saldo}")

    println("Depositando na conta da Fran: ")
    contaFran.deposita(500.0)
    println("Saldo ${contaFran.saldo}")

    println("sacando na conta do Alex")
    contaAlex.saca(300.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(50.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")

    try {
        contaFran.transfere(destino = contaAlex, valor = 100.0, senha = 9)
        //lembrando que nesse caso se houver dinheiro, e senha não for correto
        //ira apresentar uma mensagem falha na autenticação pq a senha é errada
        println("Transferência sucedida")
        //nesse caso ele esta tentando fazer uma transf para o destino com valor
        //se essa transf ocorre tudo bem - printa transferencia sucedida
        //mas se não acontecer alem de printa falha na transferência
        //gera o erro = SaldoInsuficienteException
        //lembrar de coloca o printStackTrace()
    } catch (e: SaldoInsuficienteException) {
        println("Falha na transferência")
        println("Saldo insuficiente")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException){
        println("Falha na tranferência")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e : Exception){
        //usar exception é uma forma de pegar todos os erros
        println("Erro desconhecido")
        e.printStackTrace()
    } //sempre deixar esse catch de erro desconhecido por ultimo
    //existe dois catch pq pode ter mais que uma verificação

    println(contaAlex.saldo)
    println(contaFran.saldo)
}