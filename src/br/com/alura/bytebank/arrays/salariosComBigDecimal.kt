package br.com.alura.bytebank.arrays

import java.math.BigDecimal
import java.math.RoundingMode

//para todos os funcionarios é necessario ver se tiveram um aumento maior que 500,00 reais
//se for abaixo é preciso adicionar 500,00 reais
fun main() {
    val salarios = bigDecimalArrayOf("1500.55", "2000.00", "5000.00", "10000.00")
    println("Salários iniciais: ${salarios.contentToString()}")

    val aumento = "1.1".toBigDecimal() //variavel que informa o aumento e passa pra bigdecimal

    val salarioComAumento: Array<BigDecimal> = salarios //Aqui é o tipo que esse array recebe
        .map { salario -> calculaAumentoRelativo(salario, aumento) } //salario tbm pode ser considerado it
        .toTypedArray()    //como map é uma lista e não array - é preciso  mudar para array
    println("Salário com aumento: ${salarioComAumento.joinToString()}")

    val gastoInicial =
        salarioComAumento.somatoria() //somatoria é a função la embaixo com o acumulador que somou os salarios
    println("Gasto inicial $gastoInicial")

    val meses = "6".toBigDecimal()
    //gastos total na verdade é a somatóia de 7 meses pq é um mes * 6 meses
    val gastoTotal =
        salarioComAumento.fold(gastoInicial) { acumulador, salario -> //acumulador inicia com gasto inicial (valor de inicialização)
            acumulador + (salario * meses).setScale(2, RoundingMode.UP)
            //21000 + | o que ta dentro de () é | : (2000 * 6) + (2500 * 6 ) + (5500 * 6) + (11000 * 6)
        }
    println("Gasto total em 6 meses + 1: $gastoTotal")

    /*val salariosOrdenados = salarioComAumento.sorted()
    val ultimos3Salarios: Array<BigDecimal> = salariosOrdenados.takeLast(3).toTypedArray()
    val media = ultimos3Salarios.media()
    println(media)
    nesse caso é a mesma coisa que a chamada media1 pq mostra apenas o valor da média dos 3 maiores salarios
*/
    val mediaMaioresSalarios = salarioComAumento
        .sorted()
            //sorted significa criar uma lista ordenada do menor para o maior
        .takeLast(3)
        .toTypedArray()
        .media() //nesse caso média é a função media que ta na outra pag
    println("valor da média dos 3 maiores salários do mês: $mediaMaioresSalarios")

    val mediaMenoresSalario = salarioComAumento
        .sorted()
        .take(3)
            //usa apenas take pra pegar os 3 primeiros ao inves do last
        .toTypedArray()
        .media()
    println("valor da média dos 3 menores salários do mês: $mediaMenoresSalario")

}

fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal) =
    //como é só uma expressão ele deixa aplica o retorno com =, se fosse mais não poderia
    if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
        //setScale arruma a escala(), pro tipo de arredondamento a ser escolhido = setScale sempre precisa passar o tipo de arredondamento
    }


