package br.com.alura.bytebank.arrays.list

data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Long,
    val editora: String? = null //quando não houver uma editora o valor pode ser nulo
// esse : Comparable<Livro> vem do sorted que precisa receber um critério
) : Comparable<Livro> { //ao chamar esse Comparable é preciso implementar o compareTO
    override fun compareTo(other: Livro): Int {
        //this é livro compara de livro = other
        return this.anoPublicacao.compareTo(other.anoPublicacao)
    }
}

