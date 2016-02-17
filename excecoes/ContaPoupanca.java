package br.edu.ifpi.modelo;

public class ContaPoupanca extends Conta{
	protected double juros;
	
	
	
	public ContaPoupanca() {
		super();
		
	}



	public ContaPoupanca(int numero, double saldo) {
		super(numero, saldo);
		// TODO Auto-generated constructor stub
	}



	public ContaPoupanca(double juros) {
		super();
		this.juros = juros;
	}



	//Q3
	@Override
	public double atualizaConta(double taxa){
		this.saldo+=this.saldo*taxa*3;
		return super.atualizaConta(taxa);
		
	}


}
