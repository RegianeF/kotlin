package br.com.alura.bytebank.arrays.list

fun main() {
    val livro1 = Livro(
        titulo = "Grande Sertão: Veredes",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )
    val livro3 = Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "EditoraB"
    )
    //lista de objeto, uma lista sempre vai ser uma lista de objetos e não tipos primitivos
    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    //a função add sabe que espera um Livro, pois <Livro> foi passada como "tipo"
    livros.add( //adiciona um livro na variavel livros
        Livro( //Livro maiusculo pq vem de Class
            titulo = "Sagarana",
            autor = "João Guimarães Rosa",
            anoPublicacao = 1946
        )
    )

    println(livros)
    livros.imprimeComMarcadores() //chama a função que foi feita para imprimir

    livros.remove(livro1)
    //remove um determinado valor da lista
    livros.imprimeComMarcadores()

    //ORDENAR
    //para usar sorted é necessário na classe que representa a lista usar o sutype Comparable,
    //ou seja, é preciso ir lá na classe livro implementar Comparable
    val ordenadoAnoPublicacao: List<Livro> = livros.sorted()  //traz a lista ordenada a partir de algum critério
    ordenadoAnoPublicacao.imprimeComMarcadores()

    //sortedBy ordena a partir de algum critério pre estabelecido no caso é titulo
    val ordenadoTitulo = livros.sortedBy { it.titulo }
    ordenadoTitulo.imprimeComMarcadores()

    livros.sortedBy { it.autor }.imprimeComMarcadores()
    //então todas as três formas acima dão o mesmo resultado só que de maneira escirta diferente

    //FILTRAR

    listaDeLivros //dentro do arquivo livros - existe a lista de livros
        .filter { it.autor == "João Guimarães Rosa" } //estamos pedindo pra filtrar o que tem escrito it.autor nome do autor
        .imprimeComMarcadores() //imprimindo

    val titulos : List<String> = listaDeLivros
        //pq string? (List<String>) pq ali embaixo usamos map que retorna uma lista outra lista com string
        .filter { it.autor.startsWith("J") } //nesse caso vai filtrar pelo autor que comece com o prefixo "J"
        .sortedBy { it.anoPublicacao } //além de filtrar pelo nome do autor, ordenamos pelo ano de publicação
        .map { it.titulo }
    println(titulos)
}
