package br.com.alura.bytebank.arrays

fun composicaoArray(){

    /*val idades = IntArray(5)
    idades[0] = 25
    idades[1] = 19
    idades[2] = 33
    idades[3] = 20
    idades[4] = 55

    //para percorrer um array pode se usar o for
    //
    var maiorIdade = 0 //necessario saber o valor inicial
    for (idade in idades){ //para cada idade em idades faça
        if(idade > maiorIdade){
            maiorIdade = idade //se aquele valor for maior que maioridade então atribiu em maior idade - idade maior
        }
    }
    println(maiorIdade)
    //esse processo é a construção de um array basico*/

    val idades : IntArray = intArrayOf(25,19,33,20,55)

    //para percorrer um array pode se usar o for
    var maiorIdade = Int.MIN_VALUE //necessario saber o valor inicial min_value é o menor número possível
    for (idade in idades){ //para cada idade em idades faça
        if(idade > maiorIdade){
            maiorIdade = idade //se aquele valor for maior que maioridade então atribiu em maior idade - idade maior
        }
    }
    println(maiorIdade)
    //esse processo é a construção de um array basico

    var menorIdade = Int.MAX_VALUE
    idades.forEach {
        //um paramentro chamado idade
        if (it < menorIdade){
            menorIdade = it
            //o paramentrro idade significa cada array []
            //PARA cada paramentro idade < se for menor que menor idade que começa com zero
            // então menorIdade recebe idade
        }
    }

    println(menorIdade)



}