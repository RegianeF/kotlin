package br.com.alura.bytebank.collection

fun testaSet() {
    val assistiramCursoAndroid: Set<String> = setOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin = setOf("Alex", "Paulo", "Maria")
    //val assistiramAmbos = assistiramCursoAndroid + assistiramCursoKotlin
    //ao usar o mais e o set- cursoAndroid na frente, o que acontece é que o valor devolvido fica implicito para set
    //sendo assim não é possivel acessar um [] espaço especifico pq é set
    //set é faz a mesma funçao do distintc só diretamente
    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana") //como é mutableset é possivel adc elementos
    println("por val, com addAll $assistiramAmbos")

    println("com plus+ ${assistiramCursoKotlin + assistiramCursoAndroid}")
    println("com union: ${assistiramCursoAndroid.union(assistiramCursoKotlin)}")
    println("uso de intersect: ${assistiramCursoAndroid intersect assistiramCursoKotlin}") //isso aqui tem o mesmo formato que o union

    val assistiramList = assistiramAmbos.toMutableList() //a var assistiramList passou o "ambos" para uma lista mutable
    assistiramList.add("Alex")
    println(assistiramList) //com lista
    println(assistiramList.toSet()) //essa lista para set

    //println(assistiramAmbos.distinct())
    //distintc é usado para distinguir valores e  retornar apenas os que nao sao iguais

    val num = listOf(5.0, 5.01, 500.0, 55.0)
    val num2 = listOf(5.0, 5.00, 500.0, 55.0, 5.003, 5000.0)
    val ambosnumeros = mutableListOf<Double>()
    ambosnumeros.addAll(num)
    ambosnumeros.addAll(num2)
    println(ambosnumeros.distinct())
}