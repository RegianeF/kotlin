package br.com.alura.bytebank.teste


fun cursinhoAlura() {

//Sobre Strings,
  //  Lembrar que objetos Strings não podem mudar o valor
    //apenas receber outro valor em var, ou seja, uma hora joao, outra hora Maria
    val x1= 10
    var y1 = x1
    y1++
    println(x1)
    //variavel nao pode ser modificada, ou seja, X sempre será 10
    println(y1)
    //nesse caso como incremento o valor a um o y = 11 (10+1)



val p1 = Pessoa2("Alex")
    val p2 = p1
    p2.nome = "Fran"

    println(p1.nome)
    println(p2.nome)

//Esse valor é para tipo number

    val x  = 15
    //nesse caso o number é um int
    val y = 14.9
    //nesse caso o number é um double

    println(x.toDouble())
    //converter para double
    println(y.toInt())
    //Data Class
    val alex = Pessoa(
        nome = "Alex",
        idade = 25
    )

    /*val (nome, idade) = alex
    //esse tipo de estrutura vem de data class - componetN()Functions
    //não permite pq a classe é só classe*/

    /*   val alex2 = Pessoa(
           nome = "Alex",
           idade = 25
       )

       println(alex == alex2)
       //nesse caso é pra dar falso pq a comparação é feita a partir da referencia (
       //ou seja alex é diferente de alex2 (2) mas..
       */
    alex.fala()
    val documento = Documento(
        rg = "123456-9",
        cpf = "123.456.789.12"
    )
    /*val documento3 = documento.copy()
    println(documento == documento3)
    //dara true pq é o mesmo paramentros já que é uma cópia*/

    val documento3 = documento.copy(rg = "888888")
    println(documento==documento3)
    //além de fazer a cópia, foi passado novas propriedades, então se comparar será diferente - false

    val (rg, cpf) = documento
    println("Rg: $rg e Cpf: $cpf")

    println(alex)

    println(documento)
    println(documento3)
    //dará o mesmo valor na impressão, já que é uma cópia

    //nesse caso ele aceita pq vem de documento que é uma data class
    //o que é isso? é pegar apenas um paramentro sem precisar passar todos aqueles valores


    /*val documento2 = Documento(
        rg = "123456-9",
        cpf = "123.456.789.12"
    )
    println(documento==documento2)
    //nesse caso será verdadeiro, pois as proprieties serão iguais, por mais que o nome altere
    //então está fazendo comparação de propriedades e não referencias
    */

}

class Pessoa(var nome: String, var idade: Int) {
    fun fala(){
        println("emite som")
    }
}

data class Documento(val rg: String, val cpf: String)
//ao criarmos qualquer tipo de classe a ideia é passar dados;
//Ao adicionar data na class, ele apresenta todas as informações das proprieties - rg- cpf (construtor primario)
//então nesse caso println(documento) só ta impresso documento, não doc.cpf ou doc.rg
//quando adiconado data class ele imprime automaticamente aos dados da classe
//data class sempre precisa de proprieties (val ou var) e não só argumentos - paramentro
//Quando for compara uma data class tem que Lembrar que será pelas propriedades(DO CONSTRUTOR PRIMÁRIO)e não pelo nome
//então pode ter outro nome, mas se as propriedades forem iguais será TRUE

class Pessoa2(var nome: String)


