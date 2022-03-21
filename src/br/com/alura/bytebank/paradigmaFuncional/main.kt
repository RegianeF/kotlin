package br.com.alura.bytebank.paradigmaFuncional

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import java.text.DecimalFormat

fun main() {

    testaHOF()
    testaWith()

}

fun testaRun() {
    //a ideia é ver o rendimento mensal de uma conta poupança: Usando run
    val taxaAnual = 0.05 //para fazer a taxa mensal é preciso dividir pela taxa anual?
    val taxaMensal = taxaAnual / 12

    //formatar valores em decimais, como por exemplo a taxa mensal tinha dado tal valor
    //0.004166666666666667, da maneira que se aplicado o DecimalFormat() é possivel
    //dizer quantas casas depois da virgula precisa que seja mostrado
    val decimalFormat = DecimalFormat().apply {
        minimumFractionDigits = 4
        maximumFractionDigits = 4
    }
    //para imprimir tem que ser dessa maneira: chamando a variavel()
    // e passando o valor para ser aplicado o arredondamento
    println("Taxa mensal de juros: ${decimalFormat.format(taxaMensal)}")


    /*Cliente(nome = "Henrique", cpf = "300.300.400.50", senha = 2222)
        //Aqui foi passado o cliente, pois é preciso para trabalhar com Conta Poupança
        //e foi chamado para trazer um novo cliente na poupança que receber através
        //de um Run, que deposita e imprimi tal valor
        .let { clienteNovo: Cliente ->
            ContaPoupanca(clienteNovo, 7000)
        }.run {
            deposita(1000.0) //valor do deposito que vira um saldo
            saldo * taxaMensal //então o saldo * taxa mensal é o valor de juros mensal
        }.let { rendimentoMensal ->
            println("Valor do redimento mensal: $rendimentoMensal")
        }*/
    //de forma encadiada, porem não sendo possiveç reaproveitar por isso fazer assim:

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Henrique", cpf = "300.300.400.50", senha = 2222), 7000)

    contaPoupanca.run {
        deposita(1000.0) //valor do deposito que vira um saldo
        saldo * taxaMensal //então o saldo * taxa mensal é o valor de juros mensal
    }.let { rendimentoMensal ->
        println("Valor do redimento do 1° mês: $rendimentoMensal")
    }

    val rendimentoAnual = run { //variavel a partir do run a seguir
        var saldo = contaPoupanca.saldo // criado uma variavel saldo a partir de contaPoupanca.saldo e faça
        repeat(12) {
            //faca um repeat 12 vezes
            saldo += saldo * taxaMensal
            //onde saldo é ele mesmo vezes a taxa mensal - juros compostos
            //e retorne saldo
        }
        saldo
    }

    println("Valor do rendimento anual: $rendimentoAnual") //sem aarredondamento do valor
    println("Valor do rendimento anual: ${decimalFormat.format(rendimentoAnual)}")
}

fun testaWith() {
    //with nao precisa ter uma extension, então é é instanciar o elemento que é necessario, no caso endereco
    //lembrar que com with não usa virgula
    with(Endereco()) {
        logradouro = "Rua sete de setembro"
        numero = 60
        bairro = "Centro"
        cidade = "Blumenau"
        estado = "SC"
        cep = "89500-300"
        complemento = "Prédio"

        println(this)

        //foi criado uma função dentro do Endereco() para receber possiveis alterações
        enderecoCompleto()
        //através do let foi mandado imprimir
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
        //nessa caso a gente consegue trabalhar com todas as caracteristicas do objeto,
        //de forma que possa ser alterado e devolvido.
    }
}



