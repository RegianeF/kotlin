package br.com.alura.bytebank.exception

class SaldoInsuficienteException(
    mensagem: String = "O saldo é insuficiente"
) : Exception(mensagem)
//Esse é como escreve uma classe Exception, sempre dever ir a palavra Exception no final.
//Nesse caso retorna a mensagem (o saldo.. )