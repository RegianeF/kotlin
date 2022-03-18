package br.com.alura.bytebank.paradigmaFuncional

//nesse caso ao inves do retorno for unit e sem paramentros
//é usado paramentros e esperado retorno
fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int = SomaClass() //Não precisa passar paramentro aqui, pois só esta executando
    println("A partir da classe ${minhaFuncaoClasse(30, 50)}")
    //mas aqui quando chama e executa precisa passar paramentro
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::somaFun //então os dois pontos servem como uma referencia para chamar
    //a somaFun ali em baixo e executar
    println(minhaFuncao(5, 10))
}

fun somaFun(a: Int, b: Int): Int {
    return a + b
} // essa função existe por si só para ser usada como exemplo na funçãotipoReferencia

fun testaTipoFuncaoAnonima() {

    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        return a + b
        //na função anonima é preciso dizer RETURN e dai aplicar o retorno
    }
    println(minhaFuncaoAnonima(1, 1))

    val calculadoraBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        //não pode esquecer que alem do retorno do tipo de função, precisa retornar o tipo de retorno da = fun
        if (salario > 1000.0) {
            return salario + 50
        }
        return salario + 100
    }
    println("Calculadora Anônima: ${calculadoraBonificacaoAnonima(6000.0)}")
}


fun testaTipoFuncaoLambda() {
    //Recebe por parametros 2 int e devolve como retorno um int para LAMBDA
    //lembrar de usar = {"expressão"} que essa é a sintaxe do lambda
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b -> //então para passar um parametro
        //é só usar o paramentro, paramentro e -> e assim aplicar a expressão necessaria
        a + b  //na função Lambda o retorno é a ultima expressão sempre
    }
    println("A soma a partir da função Lambda é: ${minhaFuncaoLambda(100, 100)}")

    val minhaFuncaoLambdaSimplificada = { a: Int, b: Int ->
        a + b
    }
    println("A soma a partir de lambda Simplificada: ${minhaFuncaoLambdaSimplificada(6, 6)}")
    //amabas as funções são a mesma coisa, apenas essa segunda o tipo de retorno não esta especificado
    //tornando ela mais simplificada, porem é necessario lembrar de usar o tipo, ao adicionar o parametro
    //como a: Int,...
}

fun lambaComVariosRetornos() {
    //deixar de usar it e começar a renomear, para ficar um codigo mais correto (it = salario)
    //para dizer que vai ter varios retornos, usar depois do = o nome do retorno@
    val calculadoraBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50
        }
        return@lambda salario + 100
    }
    println(calculadoraBonificacao(1000.0))
    //usar função lambda com vários retornos
    //lembrar de chamar, pois se não, não será compreendida dentro da expressão
    //para isso utilizar o @ explo: variosretornos@ e na expressão chamar assim:
    //return@variosretornos
}

class SomaClass : (Int, Int) -> Int {
    //assim sobreescrevendo um invoke - invocar
    override fun invoke(a: Int, b: Int): Int = a + b
    //nesse caso ao inves de usar chave foi implementado como expressão =
}