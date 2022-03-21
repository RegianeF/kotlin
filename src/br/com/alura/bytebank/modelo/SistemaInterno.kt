package br.com.alura.bytebank.modelo

class SistemaInterno {

    fun entra(admin: Autenticavel, senha: Int, autenticado: () -> Unit = {}){
        //autenticado é uma expressão lambda, que pode não retornar nada
        if(admin.autentica(senha)){
            println("Bem vindo ao Bytebank")
            autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun entraReceiver(admin: Autenticavel, senha: Int, autenticado: SistemaInterno.() -> Unit = {}){
        //SistemaInterno.() ela seja chamada pelo sistema interno
        //assim quando chamar o autenticado terá acesso ao sistema interno
        //autenticado é uma expressão lambda, que pode não retornar nada
        if(admin.autentica(senha)){
            println("Bem vindo ao Bytebank")
            autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun pagamento(){
        println("Realizando pagamento")
    }

}