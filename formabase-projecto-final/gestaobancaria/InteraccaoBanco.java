package gestaobancaria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import contas.Conta;

public abstract class InteraccaoBanco 
{
	static Scanner input;
	
	// À medida que os menus avançam o cliente a ser usado é guardado nesta variavel
	protected static Cliente cli; 
	
	//À medida que os menus avançam a conta a ser usada é guardada nesta variavel
	protected static Conta con; 
	
	/**
	 * Este metodo está em repetição a mostrar o menu de operações disponiveis numa conta.
	 * Para cada uma das opções existentes e através de um switch solicita a informação
	 * necessaria ao utilizador e invoca os metodos correspondentes.
	 */
	protected static void processaMenuConta()
	{
		input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Menu Operacoes Conta\n");
			
			System.out.println("1 -> Levantar");
			System.out.println("2 -> Depositar");
			System.out.println("3 -> Transferir");
			System.out.println("4 -> Obter extracto");
			System.out.println("5 -> Obter saldo");
			System.out.println("6 -> Obter informacoes");
			System.out.println("7 -> Sair do Menu");
			
			System.out.println();
			
			
			System.out.println(con.obterNib());
			System.out.println(cli.obterConta(44807973));
			
			int operacao = input.nextInt();
			
			System.out.println();
						
			switch(operacao)
			{
				case 1: System.out.print("Quanto dinheiro pretende levantar? ");
						
						int quantiaLevantamento = input.nextInt();
						
						System.out.println();
						
						while(quantiaLevantamento <= 0)
						{
							System.out.print("Quanto dinheiro pretende levantar? ");
							
							quantiaLevantamento = input.nextInt();
							
							System.out.println();
						}						
																		
						if(con.levantar(quantiaLevantamento))
						{
							System.out.println("Dinheiro levantado com sucesso.");
						}
						else
						{
							System.out.println("Nao possui saldo suficiente para esta operacao.");
						}
											
						break;
						
				case 2: System.out.print("Quanto dinheiro quer depositar? ");
				
						double quantiaDeposito = input.nextInt();
						
						System.out.println();
						
						while(quantiaDeposito <= 0)
						{
							System.out.print("Quanto dinheiro quer depositar? ");
							
							quantiaDeposito = input.nextInt();
							
							System.out.println();
						}						
																		
						con.depositar(quantiaDeposito);
						
						System.out.println("Deposito efetuado com sucesso.");
				
						break;
				
				case 3: System.out.print("Qual o nib da conta para a qual pretende fazer a transferencia? ");
				
						int nibConta = input.nextInt();
					
						System.out.println();

						while(nibConta <= 0)
						{
							System.out.print("Qual o nib da conta para a qual pretende fazer a transferencia? ");
							
							quantiaDeposito = input.nextInt();
							
							System.out.println();
						}						
						
						if(Banco.obterConta(nibConta).equals(null))
						{
							System.out.println("A conta destino que especificou nao existe.");
							
							break;
						}
						else
						{
							System.out.print("Qual o valor a transferir? ");
							
							double quantiaTransferencia = input.nextInt();
							
							System.out.println();
							
							while(nibConta <= 0)
							{
								System.out.print("Qual o valor a transferir? ");
								
								quantiaDeposito = input.nextInt();
								
								System.out.println();
							}								
							
							if(con.transferir(quantiaTransferencia, Banco.obterConta(nibConta)))
							{
								System.out.println("Transferencia efectuada com sucesso.");
							}
							else
							{
								System.out.println("Nao possui o saldo suficiente para esta operacao.");
							}
						}
						
						break;
				
				case 4: System.out.println("Escolheu 'Obter extracto'!");
						break;
				
				case 5: System.out.println("Escolheu 'Obter saldo'!");
						break;
				
				case 6: System.out.println("Escolheu 'Obter informacoes'!");
						break;
				
				case 7:	//input.close();
						return;
				
				default: System.out.println("Erro");
			}
						
			System.out.println();
		}	
	}
	
	/**
	 * Este metodo está em repetição a mostrar o menu de contas disponiveis do cliente.
	 * De notar que APENAS AS CONTAS ACTIVAS são mostradas.
	 * Após ser seleccionada uma conta é invocado o metodo processaMenuConta referente à conta escolhida
	 * @param contascliente Cliente sobre o qual se quer visualizar as contas
	 * @throws IOException 
	 */
	protected static void processaMenuContas(ArrayList<Conta> contascliente) throws IOException
	{		
		int i;
		int operacao = 0;
		
		input = new Scanner(System.in);
				
		while(true)
		{
			i = 0;
			
			System.out.println("Menu Contas\n");
			
			for(Conta conta : contascliente)
			{
				i++;
				
				String tipoConta = conta.obterTipo();
				
				if(tipoConta.equals("Debito"))
				{
					System.out.println(i + " -> " + tipoConta + " - " + conta.obterNib());
				}
				else if(tipoConta.equals("Prazo"))
				{
					System.out.println(i + " -> " + tipoConta + "  - " + conta.obterNib());
				}			
			}
			
			System.out.println((i + 1) + " -> Sair do Menu\n");
				
			operacao = input.nextInt();
			
			System.out.println();
			
			if(operacao == (i + 1))
			{
				input.close();
				
				break;
			}
			else
			{
				con = contascliente.get(operacao - 1);
				
				processaMenuConta();
			}
		}
	}	
}
