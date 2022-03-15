package br.com.alura.bytebank.arrays.list

val listaDeLivros = mutableListOf( //provavelmente esse = representa que é uma expressão só
    Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    ),
    Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    ),
    Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    ),
    Livro(
        titulo = "Saragana",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1946
    ),
    Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    ),
    Livro(
        titulo = "Vidas Secas",
        autor = "Graciliano Ramos",
        anoPublicacao = 1938,
        editora = "Editora A"
    ),
    Livro(
        titulo = "O cortiço",
        autor = "Aluísio Azevedo",
        anoPublicacao = 1890,
        editora = "Editora B"
    )
)

val listaLivrosComNulos : MutableList<Livro?> = mutableListOf(
    //essa variavel é do tipo mutableList que recebe Livro, que pode ser nulo
    null,
    Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    ),
    null,
    Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    ),
    Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    ),
    null,
    Livro(
        titulo = "Saragana",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1946
    ),
    Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    ),
    Livro(
        titulo = "Vidas Secas",
        autor = "Graciliano Ramos",
        anoPublicacao = 1938,
        editora = "Editora A"
    ),
    Livro(
        titulo = "O cortiço",
        autor = "Aluísio Azevedo",
        anoPublicacao = 1890,
        editora = "Editora B"
    )
)