package br.com.alura.bytebank.exception

class FalhaAutenticacaoException(
    mensagem : String = "Falha na autenticação" // tem que passar como paramentro a mensagem
): Exception(mensagem) //tem que dizer que extende de Exception e envia a mensagem
