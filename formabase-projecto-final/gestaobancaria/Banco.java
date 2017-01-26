package gestaobancaria;

import java.util.ArrayList;
import java.util.Date;
/*
import transaccoes.Deposito;
import transaccoes.CapitalizacaoJuros;
import transaccoes.Levantamento;
import transaccoes.Transaccao;
import transaccoes.Transferencia;

import contas.Conta;
import contas.Prazo;
import contas.Debito;*/

public class Banco
{
	private static ArrayList<Cliente> clientes;
	private static int numerocliente; //utilizado para as numeracoes dos clientes
	private static int numeroconta;	//utilizado para as numeracoes das contas
	
	public static void iniciar()
	{
		clientes = new ArrayList<Cliente>();
		numeroconta = 2451;
		numerocliente = 1543;
	}

	public static int gerarNumConta()
	{
		return numeroconta++;
	}
	
	public static int gerarNumCliente()
	{
		return numerocliente++;
	}
		
	//METODOS CLIENTES
	
	/**
	 * Desactiva o cliente com o id passado como parametro. Para isto deve usar
	 * o metodo procurar cliente do banco para encontrar o cliente com esse id. Caso exista
	 * define o estado como inactivo através do metodo desactivar do cliente
	 * @param idcliente id do cliente a desactivar
	 * @return booleano a indicar se foi ou nao possivel de desactivar o cliente
	 */
	public static boolean desactivarCliente(int idcliente)
	{
		Cliente alvo = procurarCliente(idcliente);
		
		if(alvo == null)
		{
			System.out.println("O cliente com o id " + idcliente + " nao foi encontrado!");
			
			return false;
		}
		
		if(alvo.getActivo())
		{
			alvo.setActivo(false);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Lista os clientes do banco que tem o nome igual ao recebido como parametro.
	 * Caso seja passada uma string vazia entao sao listados todos os clientes
	 * @param criterionome nome do cliente a listar
	 */
	public static void listarClientes(String criterionome)
	{
		if(criterionome.equals(""))
		{
			for(Cliente cliente : clientes)
			{
				System.out.println(cliente.getNome());
			}
			
			return;
		}
		
		for(Cliente cliente : clientes)
		{
			if(cliente.getNome().equals(criterionome))
			{
				System.out.println(cliente.getNome());
			}
		}		
	}
	
	/**
	 * Procura o cliente com o id recebido como parametro e devolve-o caso exista.
	 * Caso não exista devolve null. Este metodo e utilizado noutros metodos do banco.
	 * @param userid id do cliente a procurar
	 * @return devolve o cliente com o id procurado ou null
	 */
	public static Cliente procurarCliente(int userid)
	{
		for(Cliente cliente : clientes)
		{
			if(cliente.getUserid() == userid)
			{
				return cliente;
			}
		}
		
		return null;
	}
	
	/**
	 * Utiliza o userid para encontrar o respectivo cliente e se existir confirma
	 * que a password e a correcta para esse utilizador. Caso isso se verifique 
	 * devolve o cliente que fez login
	 * @param userid id do utilizador que esta a fazer login
	 * @param password passwor dod utilizador que esta a fazer login
	 * @return Cliente que acabou de fazer login ou null caso não coincidam as credênciais
	 *//*
	public static Cliente validarLogin(int userid, int password)
	{
	
	}*/
	
	/**
	 * Cria um cliente com os dados recebidos e adiciona-o à lista de 
	 * clientes do banco
	 * @param nome nome do cliente a adicionar
	 * @param userid userid do cliente a adicionar
	 * @param password password do cliente a adicionar
	 *//*
	public static void criarCliente(String nome, int userid, int password){
		//implementar o codigo deste metodo
	}*/
}
