package br.com.alura.bytebank.arrays.list

fun main() {
    //passando para uma função main a classe Prateleira com tais
    val prateleira = PrateleiraMutableList(genero = "Literatura", livros = listaDeLivros)

    //o obbjeto prateleira, ao adicionar o ponto chamamos a função que ta dentro da classe prateleira
    //.organizarporautor e ponto.imprimecommarcadores
    println("Primeira lista por Autor: ")
    prateleira.organizarPorAutor().imprimeComMarcadores()
    println("\nSegunda lista por Ano de publicação: ")
    prateleira.organizarPorAnoPublicacao().imprimeComMarcadores()
    //nesse caso não esta dando erro na forma que é organizado a lista pq está sendo impresso tudo junto sem val

    val organizarPorAutor = prateleira.organizarPorAutor()
    //println(organizarPorAutor) //se imprimir assim, a impressão será com aquela lista que é na horizontal e nao na vertical

    //dessa maneira chamando a função imprimeComMarcadores pega e faz conforme foi ordenado na função, ou seja, irá imprimir na vertical

    val organizarPorAnoPublicao = prateleira.organizarPorAnoPublicacao()

    val organizarPorTitulo = prateleira.organizarPorTitulo()

    //função imprimir aqui em baixo chamando as duas juntas, uma depois da outra
    //o que acontece é que ao chamar a impressão depois, ele imprimi a mesma lista
    //pq como é uma lista mutavel, não estamos criando uma cópia e sim organizando a mesma lista, quando chamamos
    //então quando for chamada a organização por autor, ela foi organizada por autor
    //mas quando foi chamada por ano de publicação, aquela lista que estava organizada por autor
    //passou a ser organizada por ano de publicação, por isso nesse caso está repetindo a mesma lista
    //pq a lista não é fixa e como foi chamada depois, ela vai mostrar do ultimo jeito que foi pedido para organizar
    //este problema aconteceu pq a função sortby é quem altera a propria lista
    println(" O gênero é : ${prateleira.genero}")
    organizarPorAnoPublicao.imprimeComMarcadores()
    organizarPorAutor.imprimeComMarcadores()
    //nesses dois casos está dando erro pq é impresso depois e também é uma mutabel lista com sortBY

    organizarPorTitulo.imprimeComMarcadores()
    //já aqui ta dando certo pq é um lista imutavel, criada a partir de uma cópia sortedBY
    //por mais que o que primeiramente recebeu foi uma lista mutavel, só que o que está devolvendo é imutavel
}