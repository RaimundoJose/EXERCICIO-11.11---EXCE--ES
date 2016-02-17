package br.edu.ifpi.modelo;

//Q1
public class Conta extends Exception{
	protected int numero;
	protected double saldo;
	
	

	public Conta() {
		
	}
	
	

	public Conta(int numero, double saldo) {
		
		this.numero = numero;
		this.saldo = saldo;
	}



	

	public void setNumero(int numero) {
		this.numero = numero;
		
	}
		

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Q3
	
  public double deposita(double valor){
	  if(valor<0){
	  throw new ValorInvalidoException(valor);
		  
	  }else
		  this.saldo+=valor-0.10;
			return this.saldo;
	  }
		
		

	
	void saca(double valor){
		this.saldo-=valor;
	}
	
	//Q2


public double atualizaConta(double taxa) {
	this.saldo+=this.saldo*taxa;
	return saldo;
}





	/*

3) Crie duas subclasses da classe Conta: ContaCorrente e ContaPoupanca. Ambas ter�o o m�todo atualiza
reescrito: A ContaCorrente deve atualizar-se com o dobro da taxa e a ContaPoupanca deve atualizar-se com
o triplo da taxa.
Al�m disso, a ContaCorrente deve reescrever o m�todo deposita, afim de retirar uma taxa banc�ria de dez
centavos de cada dep�sito.
 Crie as classes ContaCorrente e ContaPoupanca. Ambas s�o filhas da classe Conta:
class ContaCorrente extends Conta {
}
class ContaPoupanca extends Conta {
}
 Reescreva o m�todo atualiza na classe ContaCorrente, seguindo o enunciado:
class ContaCorrente extends Conta {
void atualiza(double taxa) {
this.saldo += this.saldo * taxa * 2;
}
}
Repare que, para acessar o atributo saldo herdado da classe Conta, voc� vai precisar trocar o modificador
de visibilidade de saldo para protected.
 Reescreva o m�todo atualiza na classe ContaPoupanca, seguindo o enunciado:
class ContaPoupanca extends Conta {
void atualiza(double taxa) {
this.saldo += this.saldo * taxa * 3;
}
}
 Na classe ContaCorrente, reescreva o m�todo deposita para descontar a taxa banc�ria de dez
centavos:
class ContaCorrente extends Conta {
void atualiza(double taxa) {
this.saldo += this.saldo * taxa * 2;
}
void deposita(double valor) {
this.saldo += valor - 0.10;
}
}
Cap�tulo 7 - Orienta��o a Objetos � heran�a, reescrita e polimorfismo - Exerc�cios: Heran�a e Polimorfismo - P�gina 79
Material do Treinamento Java e Orienta��o a Objetos
Observa��o: existem outras solu��es para modificar o saldo da sua classe m�e: voc� pode utilizar os
m�todos retira e deposita, se preferir continuar com o private (recomendado!), ou ent�o criar um m�todo
setSaldo, mas protected, para n�o deixar outras pessoas alterarem o saldo sem passar por um m�todo
(nem mesmo sua filha conseguiria burlar isso). Hoje em dia, muitas pessoas dizem que o protected quebra
encapsulamento, assim como alguns casos de heran�a onde a m�e e filha t�m um acoplamento muito forte.
4) Crie uma classe com m�todo main e instancie essas classes, atualize-as e veja o resultado. Algo como:
class TestaContas {
public static void main(String[] args) {
Conta c = new Conta();
ContaCorrente cc = new ContaCorrente();
ContaPoupanca cp = new ContaPoupanca();
c.deposita(1000);
cc.deposita(1000);
cp.deposita(1000);
c.atualiza(0.01);
cc.atualiza(0.01);
cp.atualiza(0.01);
System.out.println(c.getSaldo());
System.out.println(cc.getSaldo());
System.out.println(cp.getSaldo());
}
}
Ap�s imprimir o saldo (getSaldo()) de cada uma das contas, o que acontece?
5) O que voc� acha de rodar o c�digo anterior da seguinte maneira:
Conta c = new Conta();
Conta cc = new ContaCorrente();
Conta cp = new ContaPoupanca();
Compila? Roda? O que muda? Qual � a utilidade disso? Realmente, essa n�o � a maneira mais �til do
polimorfismo - veremos o seu real poder no pr�ximo exerc�cio. Por�m existe uma utilidade de declararmos
Cap�tulo 7 - Orienta��o a Objetos � heran�a, reescrita e polimorfismo - Exerc�cios: Heran�a e Polimorfismo - P�gina 80
Material do Treinamento Java e Orienta��o a Objetos
uma vari�vel de um tipo menos espec�fico do que o objeto realmente �.
� extremamente importante perceber que n�o importa como nos referimos a um objeto, o m�todo que
ser� invocado � sempre o mesmo! A JVM vai descobrir em tempo de execu��o qual deve ser invocado,
dependendo de que tipo � aquele objeto e n�o de acordo com como nos referimos a ele.
6) (opcional) Vamos criar uma classe que seja respons�vel por fazer a atualiza��o de todas as contas
banc�rias e gerar um relat�rio com o saldo anterior e saldo novo de cada uma das contas.
class AtualizadorDeContas {
private double saldoTotal = 0;
private double selic;
AtualizadorDeContas(double selic) {
this.selic = selic;
}
void roda(Conta c) {
// aqui voce imprime o saldo anterior, atualiza a conta,
// e depois imprime o saldo final
// lembrando de somar o saldo final ao atributo saldoTotal
}
// outros m�todos, colocar o getter para saldoTotal!
}
7) (opcional) No m�todo main, vamos criar algumas contas e rod�-las:
class TestaAtualizadorDeContas {
public static void main(String[] args) {
Conta c = new Conta();
Conta cc = new ContaCorrente();
Conta cp = new ContaPoupanca();
c.deposita(1000);
cc.deposita(1000);
cp.deposita(1000);
AtualizadorDeContas adc = new AtualizadorDeContas(0.01);
adc.roda(c);
adc.roda(cc);
adc.roda(cp);
System.out.println("Saldo Total: " + adc.getSaldoTotal());
}
}
8) (Opcional) Use a palavra chave super nos m�todos atualiza reescritos, para n�o ter de refazer o trabalho.
9) (Opcional) Se voc� precisasse criar uma classe ContaInvestimento, e seu m�todo atualiza fosse complicad�ssimo,
voc� precisaria alterar as classes Banco e AtualizadorDeContas?
10) (Opcional, Trabalhoso) Crie uma classe Banco que possui um array de Conta. Repare que num array de
Cap�tulo 7 - Orienta��o a Objetos � heran�a, reescrita e polimorfismo - Exerc�cios: Heran�a e Polimorfismo - P�gina 81
Material do Treinamento Java e Orienta��o a Objetos
Conta voc� pode colocar tanto ContaCorrente quanto ContaPoupanca. Crie um m�todo void adiciona(Conta
c), um m�todo Conta pegaConta(int x) e outro int pegaTotalDeContas(), muito similar a rela��o anterior
de Empresa-Funcionario.
Fa�a com que seu m�todo main crie diversas contas, insira-as no Banco e depois, com um for, percorra
todas as contas do Banco para pass�-las como argumento para o AtualizadorDeContas.*/

	

	
	
	

}
