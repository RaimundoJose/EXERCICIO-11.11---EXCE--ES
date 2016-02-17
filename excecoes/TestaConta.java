package br.edu.ifpi.principal;

import br.edu.ifpi.modelo.Conta;
import br.edu.ifpi.modelo.ContaCorrente;
import br.edu.ifpi.modelo.ContaPoupanca;
import br.edu.ifpi.modelo.ValorInvalidoException;

//Q4
public class TestaConta {
	
	
	
	public static void main(String[] args) {
		Conta c = new Conta();
		
		
		ContaCorrente cc = new ContaCorrente();
		
		ContaPoupanca cp = new ContaPoupanca();
		try{
		cp.deposita(-100);//Gera exceção lançada no metodo deposita - IllegalArgumentException;
		}catch(ValorInvalidoException e){
			e.printStackTrace();
			e.getMessage();
		}
		c.setSaldo(1000.0);
        c.setNumero(1);	
       //c.atualizaConta(10);
        
        cc.setNumero(2);
        cc.setSaldo(2000.0);
        
        cp.setNumero(3);
        cp.setSaldo(3000.0);
        
		System.out.println("mostra tudo  R$"+c.atualizaConta(10));
		System.out.println("mostra tudo  R$"+cc.atualizaConta(5));
		System.out.println("mostra tudo  R$"+cp.atualizaConta(1));
		
		System.out.println("O saldo da Conta é  R$"+c.getSaldo());
		System.out.println("O saldo da Conta Corrente é  R$"+cc.getSaldo());
		System.out.println("O saldo da conta é  R$"+cp.getSaldo());
		
	}
	

}
