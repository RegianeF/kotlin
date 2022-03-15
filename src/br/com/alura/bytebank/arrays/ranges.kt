package br.com.alura.bytebank.arrays
//range representa uma serie ou sequencia
//a seguir como funciona uma range
fun main(){
    val serie: IntRange = 1.rangeTo(10) // representa uma serie de numeros inteiro de 1 ate 10
    for (s in serie){
        print("$s ")
    }
    // .. é igual a rangeTO
    println()
    val numerosPares = 0..100 step 2
    for (numeroPar in numerosPares){
        print("$numeroPar ")
    }
    // diferença entre for e range está como é lido para fazer sentido
    println()
    val numerosPares2 = 2.until(100) step 2
    for (numeroPar in numerosPares){
        print("$numeroPar ")
    }
    println()

    val numeroParesReverso = 100 downTo 2 step 2
    numeroParesReverso.forEach{
        print("$it ")
    }
    println()

    val intervalo = 1500.0..5000.0
    //se um determinado salario esta dentro desse intervalo
    val salario = 6000.0
    if (salario in intervalo){ //aqui vai ser um true ou false
        println("O salario esta dentro do intervalo")
    } else{
        println("O salario não está dentro do intervalo")
    }

    val alfabeto = "a".."z"
    val letra = "k"
    println(letra in alfabeto)


}