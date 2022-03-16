package br.com.alura.bytebank.arrays.list

//uma classe para organizar melhor a lista de livros
class PrateleiraComList(
    val genero: String, //passando o construtor primario para classificar por genero
    val livros: List<Livro> // e o construtor primario livros que são os livros,
    // que recebem uma lista de livros da classe Livros (a classe mãe)
    //List é imutavel, não adciona e nem remove, ou seja, ela não pode alterar a ordem dela mesma
) {
   //como uma list não pode ser reorganizada é necessario usar algo que faça a copia
    //como a sortedBy
    //então ao inves de devolve uma lista mutavel,
   //devolve uma lista fixa que é uma "cópia" através da sortedBY
    fun organizarPorAutor() : List<Livro> {
        return livros.sortedBy { it.autor }
    }
    fun organizarPorAnoPublicacao():List<Livro> {
      return livros.sortedBy { it.anoPublicacao }
    }
}