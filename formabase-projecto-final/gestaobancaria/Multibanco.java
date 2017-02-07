
package gestaobancaria;

import java.util.Scanner;

public class Multibanco extends InteraccaoBanco
{	
	public void login()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("userid: ");
		int userid = input.nextInt(); 
		
		System.out.print("password: ");
		int password = input.nextInt();
		
		System.out.println();	
		
		Cliente c = Banco.validarLogin(userid, password);
		
		boolean dadosCorretos = (c != null);
		boolean clienteAtivo;
	
		clienteAtivo = dadosCorretos ? c.getActivo() : false;
				
		while(!dadosCorretos || !clienteAtivo)
		{
			if(!dadosCorretos)
			{
				System.out.println("Dados de login invalidos.");	
			}
			else if(!clienteAtivo)
			{
				System.out.println("Nao pode operar sobre um cliente inactivo.");	
			}			
			
			System.out.println();
			
			System.out.print("userid: ");
			userid = input.nextInt(); 
			
			System.out.print("password: ");
			password = input.nextInt();
			
			System.out.println();	
			
			c = Banco.validarLogin(userid, password);		
			
			dadosCorretos = (c != null);	
		
			clienteAtivo = dadosCorretos ? c.getActivo() : false;
		}
					
		System.out.println("Bem-vindo!");
		
		System.out.println();
		
		super.processaMenuContas(c.obterContas());
	}
}
