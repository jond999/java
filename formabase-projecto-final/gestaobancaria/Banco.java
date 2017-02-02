package gestaobancaria;

import java.util.ArrayList;

//import java.util.Date;

/*
import transaccoes.Deposito;
import transaccoes.CapitalizacaoJuros;
import transaccoes.Levantamento;
import transaccoes.Transaccao;
import transaccoes.Transferencia;
*/

import contas.Conta;
import contas.Debito;
import contas.Prazo;

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
				if(cliente.getActivo())
				{
					System.out.println(cliente.getNome());
				}
			}
						
			return;
		}
		
		for(Cliente cliente : clientes)
		{
			if(cliente.getActivo() && cliente.getNome().equals(criterionome))
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
	 * @param password password do utilizador que esta a fazer login
	 * @return Cliente que acabou de fazer login ou null caso não coincidam as credênciais
	 */
	public static Cliente validarLogin(int userid, int password)
	{
		Cliente cliente = procurarCliente(userid); 
		
		if(cliente == null)
		{
			System.out.println("O login falhou! O cliente com o userid \"" + userid + "\" nao foi encontrado no sistema.");
			
			return null;
		}
		
		if(password != cliente.getPassword())
		{
			System.out.println("O login falhou! A password que usou nao corresponde com a password do userid \"" + userid + "\".");
			
			return null;
		}
		
		return cliente;
	}
	
	/**
	 * Cria um cliente com os dados recebidos e adiciona-o à lista de 
	 * clientes do banco
	 * @param nome nome do cliente a adicionar
	 * @param userid userid do cliente a adicionar
	 * @param password password do cliente a adicionar
	 */
	public static void criarCliente(String nome, int userid, int password)
	{
		Cliente novoCliente = new Cliente(nome, userid, password);
		
		clientes.add(novoCliente);
	}
	
	/**
	 * Procura em todos os clientes por uma conta com o nib recebido como parâmetro
	 * Devolve o objecto conta caso exista ou null caso não exista
	 * @param nib nib da conta a procurar
	 * @return Conta com o nib especificado
	 */
	 public static Conta obterConta(int nib)
	 {
		 for(Cliente cliente : clientes)
		 {
			 Conta contaProcurada = cliente.obterConta(nib);
			 
			 if(contaProcurada != null)
			 {
				 return contaProcurada;
			 }
		 }
		 
		 return null;
	 }
	 
	 /**
	  * Procura o cliente com o id recebido por parâmetro. Caso este exista adiciona
	  * o objecto conta recebido por parâmetro às contas desse cliente
	  * @param idcliente id do cliente a adicionar a Conta
	  * @param c Conta a adicionar
	  */
	 public static void adicionaConta(int idcliente, Conta c)
	 {
		 Cliente clienteProcurado = procurarCliente(idcliente);
		 
		 if(clienteProcurado != null)
		 {			 
			 if(c == null)
			 {
				 System.out.println("A operacao falhou! A conta nao foi criada.");
				 
				 return;
			 }
			 
			 if(clienteProcurado.obterConta(c.obterNib()) != null)
			 {
				 System.out.println("A operacao falhou! O cliente ja tem uma conta com esse nib.");
				 
				 return;
			 }			 
			 
			 clienteProcurado.adicionarConta(c);
		 }
		 
		 System.out.println("A operacao falhou! O cliente com o userid \"" + idcliente + "\" nao foi encontrado no sistema.");
	 }
	 
	 /**
	  * Cria uma conta para o cliente c com o tipo tipoconta
	  * ESTE METODO ASSUME QUE O TIPO DE CONTA E VALIDO (1 - DEBITO / 2 - PRAZO)
	  * @param c O cliente sobre o qual vai ser criada a conta
	  * @param tipoconta o tipo da conta a criar
	  * @return O nib da nova conta criada
	  */
	 public static int criarConta(Cliente c, int tipoconta)
	 {
		 Conta novaConta;
		 
		 switch(tipoconta)
		 {
		 	case 1: novaConta = new Debito(); 
		 			break;
		 			
		 	case 2: novaConta = new Prazo(); 
		 			break;
		 			
		 	default: 	String erro = "";
		 				erro += "A conta nao foi criada!\n";
		 				erro += "Para criar uma conta de \"Debito\" escolha 1.\n";
		 				erro += "Para criar uma conta a \"Prazo\" escolha 2.\n";
		 				
		 				System.out.println(erro);
		 				
		 				return -1;
		 }
		 	 
		 if(c.obterConta(novaConta.obterNib()) != null)
		 {
			 System.out.println("A operacao falhou! O cliente ja tem uma conta com esse nib.");
			 
			 return -1;
		 }			 

		 c.adicionarConta(novaConta);
		 
		 return novaConta.obterNib();
	 }
}
