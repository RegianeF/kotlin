package br.com.alura.bytebank.arrays

fun main() {
    val salarios: DoubleArray = doubleArrayOf(1500.50, 2300.0, 5000.0, 8000.0, 10000.0)
    // cada tipo tem que ter o seu array

    val aumento = 1.1
    for (indice in salarios.indices) { //indices roxo significa o indice do array salário
        salarios[indice] = salarios[indice] * aumento
    }
    println(salarios.contentToString()) //é necessario usar  o contentToString pq se não não passa o valor pra gente ver

    //tradução: val salarios para cada salario indexed - recebe dois parametros como função {}
    salarios.forEachIndexed { i, salario -> //indice e o salario que ta no array
        salarios[i] = salario * aumento //para o salario no indece tal, faça o salario * o valor de aumento
    }

    println(salarios.contentToString())
}