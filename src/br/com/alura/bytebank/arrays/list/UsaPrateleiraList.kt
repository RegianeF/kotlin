package br.com.alura.bytebank.arrays.list

fun main() {

    val prateleira = PrateleiraComList(genero = "Literatura", livros = listaDeLivros)
    //nesse caso foi defenido que livros será uma lista fixa - imutavel
    //por isso que ao passar listaDeLivros que mutavel ela ser torna imutalve

    println("Primeira lista por Autor: ")
    prateleira.organizarPorAutor().imprimeComMarcadores()
    println("\nSegunda lista por Ano de publicação: ")
    prateleira.organizarPorAnoPublicacao().imprimeComMarcadores()

    val organizarPorAutor = prateleira.organizarPorAutor()
    val organizarPorAnoPublicao = prateleira.organizarPorAnoPublicacao()

    //como a lista imutavel nao altera, através do sortedby ela cria uma copia da lista com aquela chamada
    //no caso se foi por autor irá criar uma cópia cque inicia a ordenação por autor
    // através disso "não" importa a ordem que for chamada que vai enviar o arquivo certo, já que é um copia fixa

    println()
    organizarPorAnoPublicao.imprimeComMarcadores()
    organizarPorAutor.imprimeComMarcadores()
}