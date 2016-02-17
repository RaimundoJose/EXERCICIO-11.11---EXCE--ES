package br.edu.ifpi.modelo;


public class ValorInvalidoException extends RuntimeException {
	
	
public ValorInvalidoException(double valor) {
	
	super("Valor invalido"+ valor);
	// TODO Auto-generated constructor stub
}

}
