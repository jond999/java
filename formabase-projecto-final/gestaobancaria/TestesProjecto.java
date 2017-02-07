
package gestaobancaria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import transaccoes.CapitalizacaoJuros;
import transaccoes.Deposito;
import transaccoes.Levantamento;
import transaccoes.Transaccao;
import transaccoes.Transferencia;

import contas.Conta;
import contas.Debito;
import contas.Prazo;

public class TestesProjecto
{	
	public static void testarClientes()
	{
		Cliente joao = new Cliente("joao", 111, 222);
		Cliente pedro = new Cliente("pedro", 123, 456);
		
		System.out.println(joao.obterInformacoes() + "\n");
		System.out.println(pedro.obterInformacoes());
	}
		
	public static void testarContas()
	{
		Conta deb = new Debito();
		Conta pr = new Prazo();
			
		System.out.println("Saldo da conta de Debito: " + deb.obterSaldo() + " €\n");
		
		deb.depositar(500);
		deb.levantar(150);		
		
		System.out.println("Informações da conta de Debito:\n");
		System.out.println(deb.mostrarInformacoes());
		
		System.out.println();

		System.out.println("Nib da conta: " + deb.obterNib());

		deb.transferir(100, pr);
		deb.levantar(1200);
		
		System.out.println();
		
		System.out.println("Saldo da conta de Debito: " + deb.obterSaldo() + " €");
		System.out.println("Saldo da conta a Prazo: " + pr.obterSaldo() + " €\n");
		
		pr.depositar(900);
		pr.levantar(400);		
		
		System.out.println("Saldo da conta a Prazo: " + pr.obterSaldo() + " €\n");
		
		System.out.println("Informacoes da conta a Prazo:\n");
		System.out.println(pr.mostrarInformacoes());
		
		System.out.println();
		
		System.out.println("Nib da conta: " + pr.obterNib());
		
		System.out.println();
		
		System.out.println("Saldo da conta a Prazo: " + pr.obterSaldo() + " €");
	}

	public static void testarContasComClientes()
	{
		Cliente joao = new Cliente("joao",111,222);
				
		Conta deb = new Debito();
		Conta pr = new Prazo();
		
		joao.adicionarConta(deb);
		joao.adicionarConta(pr);
		
		ArrayList<Conta> contasjoao = joao.obterContas();
		
		//percorrer todas as contas do joao e mostrarInformacoes
		for(int i = 0; i < contasjoao.size(); i++)
		{
			Conta contacorrente = contasjoao.get(i);
			
			System.out.println(contacorrente.mostrarInformacoes());
		}
		
		Conta contadebitojoao = joao.obterConta(deb.obterNib());
		Conta contaprazojoao = joao.obterConta(pr.obterNib());
		
		if (contadebitojoao!= null)
		{
			System.out.println();
			System.out.println("Conta de Debito do joao encontrada!");
		}
		
		if (contaprazojoao!= null)
		{
			System.out.println();
			System.out.println("Conta a Prazo do joao encontrada!");
		}		
	}

	public static void testarTransaccoes()
	{
		Conta deb = new Debito();
		Conta deb2 = new Debito();
		
		Transaccao dep = new Deposito(new Date(), deb, 500);
		Transaccao lev = new Levantamento(new Date(), deb, 100);		
		Transaccao cap = new CapitalizacaoJuros(new Date(), deb, 25);
		Transaccao transf = new Transferencia(new Date(), deb, 25, deb2);
		
		System.out.println(dep.mostrar());
		System.out.println(lev.mostrar());
		System.out.println(cap.mostrar());
		System.out.println(transf.mostrar());
		
		System.out.println();
		
		System.out.println(dep.obterTipo());
		System.out.println(lev.obterTipo());
		System.out.println(cap.obterTipo());
		System.out.println(transf.obterTipo());
	}
	
	public static void testarTransaccoesComContas()
	{	
		Conta deb = new Debito();
		Conta deb2 = new Debito();
		
		Transaccao dep = new Deposito(new Date(), deb, 500);
		Transaccao lev = new Levantamento(new Date(), deb, 100);		
		Transaccao cap = new CapitalizacaoJuros(new Date(), deb, 25);
		Transaccao transf = new Transferencia(new Date(), deb, 25, deb2);
		
		deb.adicionarTransaccao(dep);
		deb.adicionarTransaccao(lev);
		deb.adicionarTransaccao(cap);
		deb.adicionarTransaccao(transf);
		
		ArrayList<Transaccao> transaccoes = deb.obterTransaccoes();
		
		System.out.println("A conta tem " + transaccoes.size() + " transaccoes.\n");
		
		deb.mostrarExtracto();
	}
	
	public static void testarBancoClientes()
	{
		Banco.iniciar();
		
		Banco.criarCliente("joao", 123, 456);
		Banco.criarCliente("pedro", 232, 454);
		
		System.out.println("Listar clientes sem criterio:");
		Banco.listarClientes("");
		
		System.out.println();
		
		System.out.println("Listar clientes com o criterio 'pedro':");
		Banco.listarClientes("pedro");
		
		System.out.println();
		
		Cliente cli = Banco.procurarCliente(123);
		System.out.println("Mostrar o cliente com id 123:\n" + cli.obterInformacoes()); 

		System.out.println();
		
		Banco.desactivarCliente(123);
		
		System.out.println("Listar clientes após desactivação:");
		Banco.listarClientes("");
		
		System.out.println();
	}
	
	public static void testarBancoContas()
	{
		Banco.iniciar();
		
		Banco.criarCliente("joao", 123, 456);
		
		Cliente joao = Banco.procurarCliente(123);
			
		Banco.criarConta(joao, 1); // Debito
		Banco.criarConta(joao, 2); // Credito
			
		ArrayList<Conta> contasjoao = joao.obterContas();
		
		for(Conta c : contasjoao)
		{
			System.out.println(c.mostrarInformacoes() + "\n");
		}
	}	
	
	public static void testarInteraccaoBanco() throws IOException
	{
		/* PARTE 1
		Cliente c = new Cliente("joao", 123, 456);
		
		Conta deb = new Debito();
		Conta pr = new Prazo();
		Conta deb2 = new Debito();
		Conta pr2 = new Prazo();
		Conta deb3 = new Debito();
		Conta pr3 = new Prazo();		
				
		c.adicionarConta(deb);
		c.adicionarConta(pr);
		c.adicionarConta(deb2);
		c.adicionarConta(pr2);
		c.adicionarConta(deb3);
		c.adicionarConta(pr3);		
		
		InteraccaoBanco.cli = c; 
		
		InteraccaoBanco.processaMenuContas(InteraccaoBanco.cli.obterContas());
		*/
		
		/* PARTE 2
		Banco.iniciar();
		
		Cliente c = Banco.procurarCliente(111);
		
		InteraccaoBanco.cli = c; 
		
		InteraccaoBanco.processaMenuContas(InteraccaoBanco.cli.obterContas());
		*/	
		
		/* PARTE 3 */
		Banco.iniciar();
		/* */			
	}
	
	public static void main(String[] args) throws IOException
	{
/*		
		testarClientes();
		
		System.out.println("---------------------------------------------------------------------------");
		
		testarContas();
		
		System.out.println("---------------------------------------------------------------------------");
		
		testarContasComClientes();
		
		System.out.println("---------------------------------------------------------------------------");
		
		testarTransaccoes();
		
		System.out.println("---------------------------------------------------------------------------");
																															
		testarTransaccoesComContas();		
		
		System.out.println("---------------------------------------------------------------------------");
		
		testarBancoClientes();
		
		System.out.println("---------------------------------------------------------------------------");
	
		testarBancoContas();
		
		System.out.println("---------------------------------------------------------------------------");
*/
		
		testarInteraccaoBanco();	
	}
}
