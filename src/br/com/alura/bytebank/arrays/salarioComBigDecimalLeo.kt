package br.com.alura.bytebank.arrays

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    //instancea a funcao salariocomaumento2 e passa os valores por paramentro
    val salariosComAumento = SalarioComAumento2("1500.55".toBigDecimal(),"2000.00".toBigDecimal() )
    println(salariosComAumento.joinToString()) //imprimi scomo se fosse um valor
}

fun SalarioComAumento2(vararg salarios: BigDecimal) : Array<BigDecimal> {
    val aumento = "1.1".toBigDecimal()
    val salarioComAumento = salarios.map { salario ->
        (salario * aumento).setScale(2, RoundingMode.UP)
    }.toTypedArray()
    return salarioComAumento
}
