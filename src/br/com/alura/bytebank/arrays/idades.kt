package br.com.alura.bytebank.arrays

fun main() {
    val idades: IntArray = intArrayOf(10, 18, 18, 33, 40, 67)
    val maiorIdade = idades.max()
    println("Maior idade é : $maiorIdade")

    val menorIdade = idades.min()
    println("Menor idade é: $menorIdade")

    val mediaIdades = idades.average()
    println("A média de idade é: $mediaIdades")

    //quando vier uma lista de fora.
    //se todos os elementos forem maior que 18, então devolva true ou false
    val todosMaiores = idades.all { it > 18 }
    println("Todos os alunos são maiores? $todosMaiores")

    val qualquerMaior = idades.any { it >= 18 } //any é qualquer que for essa condição retorna true
    println("Existe algum aluno maior de 18 anos? $qualquerMaior")

    val listaMaiores = idades.filter { it >= 18 } //filtra e retorna uma lista de
    println("Lista com maiores de 18: $listaMaiores")

    val encontrar = idades.find { it == 19 } //vai encontrar alguem com 18 e retornar
    println("Existe alguem com 18 anos: $encontrar") //se não houver, devolve automaticamente null

    val buscar = idades.find { it >= 18 } //vai encontrar alguem com 18 e retornar //lembrando que ele só encontra um elemento
    println("Existe alguem com 18 anos: $buscar") //se não houver, devolve automaticamente null

}
