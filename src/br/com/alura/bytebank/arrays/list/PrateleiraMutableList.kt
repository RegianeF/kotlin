package br.com.alura.bytebank.arrays.list

//uma classe para organizar melhor a lista de livros
class PrateleiraMutableList(
    val genero: String, //passando o construtor primario para classificar por genero
    val livros: MutableList<Livro> // e o construtor primario livros que são os livros,
    // que recebem uma lista de livros da classe Livros (a classe mãe)
) {
    //metodo para organizar por autor que retorna uma lista a partir da classe livro
    //que livros - construtor que recebe uma lista de livros da classe livro será organizado por autor (sortBy)
    // : MutableList<Livro> é o tipo de retorno que dentro dela retorna livros
    fun organizarPorAutor() : MutableList<Livro> {
        livros.sortBy { it.autor }
        return livros
    }
    fun organizarPorAnoPublicacao(): MutableList<Livro> {
        livros.sortBy{ it.anoPublicacao }
        return livros
    }
    //no caso foi utilizao sortBy que pode ser usado em mutablelist
    //a função sortBy altera a mesma lista produzindo aquele erro em usar prateleira que
    //altera a lista mas quando vai imprimir, imprime a ultima realocada

    fun organizarPorTitulo(): List<Livro> {
        return livros.sortedBy { it.titulo }/*.toMutableList()*/
    }
    //então na fun organizarPorTitulo é retornado : List uma lista só que é usado o sortedBy
    //que copia uma lista imutavel, ou seja, aquela copia não será mutavel, por mais que venho de uma lista mutavel
    //Se necessario usar um sortedBy para criar uma copia de lista e ela precisar depois ser mutavel é possivel converter
    //utilizando o toMutableList
}