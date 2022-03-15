package br.com.alura.bytebank.arrays.list

fun main() {
    listaLivrosComNulos.imprimeComMarcadores()
    //nesse caso está chamando aquela lista que contem os "Livros"null
    //e lá em impremeComMarcadores a função está organizada para não aparecer aquele valores null,
    //apenas os argumentos(livros) que tenham informações válidas

    println()

    //listasemnull
    listaDeLivros
        .groupBy { it.editora} //group by espera um elemento que diz qual o elemente que será usado p agrupar a lista
        .forEach { (editora, livros) ->   //é necessario colocar em () o que a função forEach esta recebendo
            println("$editora: ${livros.joinToString { it.titulo }}")
        }
}