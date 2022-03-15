package br.com.alura.bytebank.arrays.list

//criar uma função de livro com o nome imprimeComMarcadores - Lembrar de usar o .imprime..
//esta = this, lista de livros
fun List<Livro?>.imprimeComMarcadores() { //nessa caso livro pode ser null (arquivo ListaDeLivrosComNulos)
    val textoFormatado = this
        .filterNotNull() //Quando os filtros não forem nulos, (aqueles que não são, vão receber o código a seguir
        .joinToString(separator = "\n") {
            "Título: ${it.titulo} de ${it.autor} do ano ${it.anoPublicacao} publicado pela editora ${it.editora}"
            //se não fosse inserido aquele filtro ali em cima pra filtrar o que não é nulo precisaria:
            //precisa passar a safe call(?) os argumentos (tutulo, autor) ex:  "Título: ${it?.titulo} d e ${it?.autor} do ano ${it?.anoPublicacao}
            //afim de falar que  só chama o titulo se não for nulo, se for null devolve nulo e não acontece um exception
            //mas se tiver o filtro não precisa pq o Kotlin sabe que o que passar ali não é null, ou seja, o safe call é redundante
        }
    println("#### LISTA DE LIVROS #### \n$textoFormatado ")
}