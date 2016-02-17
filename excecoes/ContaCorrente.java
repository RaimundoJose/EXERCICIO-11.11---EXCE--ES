package br.edu.ifpi.modelo;

public class ContaCorrente extends Conta{
	protected double limite;
	
	
	
	
	public ContaCorrente() {
		super();
		
	}



	public ContaCorrente(int numero, double saldo) {
		super(numero, saldo);
		
	}



	public ContaCorrente(double limite) {
		
		this.limite = limite;
	}



	//Q3
	@Override
	public double atualizaConta(double taxa){
		this.saldo+=this.saldo*taxa*2;
		return super.atualizaConta(taxa);
		
	}

	
}
