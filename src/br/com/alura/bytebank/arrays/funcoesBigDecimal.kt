package br.com.alura.bytebank.arrays

import java.math.BigDecimal

//o professor chamou isso tudo (cada fun) de extension function

//vararg -paramentro variavel de String / sem valor pré definido que será passado, podendo passar quantos valores for necessario
fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> { //retorna um array de big decimal
    // tamanho de valores, ou seja, um tamanho dinamico -- i é o proprio indice do array
    return Array<BigDecimal>(valores.size) { i ->
        valores[i].toBigDecimal() //atraves do indice é acessado cada valor dentro do array e convertido pra bigdecimal
    }
}

//essa função tem a ideia de somar qual é o valor em um mês de salário dos funcionários
fun Array<BigDecimal>.somatoria(): BigDecimal { //extensão de bidecimal nome somatoria
    return this.reduce { acumulador, valor -> //retorne essa função: Acumulador é o primeiro aquele que acumula, recebe valor, e valor é  o paramentro do array
        acumulador + valor
    }
    //reduce é uma função que contem um acumulador e valor é o valor que o array vai passa e assim o acumulador pode somar os valores
}

fun Array<BigDecimal>.media() : BigDecimal {
    return if (this.isEmpty()) { //validar se o array não é vazio, se ESSE é vazio, retorne 0
        BigDecimal.ZERO
    } else { //se não faça a média
        this.somatoria() / this.size.toBigDecimal()
    }
}
