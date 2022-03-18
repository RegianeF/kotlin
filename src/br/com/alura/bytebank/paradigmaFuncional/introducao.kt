package br.com.alura.bytebank.paradigmaFuncional

import br.com.alura.bytebank.modelo.Endereco

fun introducao(){
    Endereco().let { "" }
    "".let { ::testeRecebeString} //dessa maneira uma funçaõ dentro da outra, como chamar

    teste(1,{}) // apenas se a expressão lambda for unica ou por ultimo é necessario colocar ela dentro ()
}
fun testeRecebeString(valor: String){

} //função criada para demostrar como usar com ::

fun teste(teste: Int, bloco: () -> Unit){
    //quando uma função recebe outra tem um nome para isso
    //higher order function

} //uma função com outra função dentro

/*inline fun lambda(s: String): String {
    return s
 //inline pega uma função de alta prioridade, e ao inves de "chamar" a função com vários objetos -
 //isso tudo por de baixo dos panos, pega e cópia essa função e executa quando precisar, sem "comer" muita memória
 //então ao adiciona o inline, tende a ficar mais rápido, porém não pode ser usado para grandes códigos e sim,
 //apenas para pequenos códigos, afim de otimizar.
}*/
