package contas;

import java.text.SimpleDateFormat;

public class Debito extends Conta
{	
	public boolean levantar(double valor)
	{
		if(super.saldo >= valor)
		{
			super.saldo -= valor;
			
			return true;
		}
		
		return false;
	}
	
	public boolean transferir(double valor, Conta contadestino)
	{
		if(super.saldo >= valor)
		{
			super.saldo -= valor;
			contadestino.saldo += valor;
		}
		
		return false;
	}
	
	public String mostrar()
	{
		String info = "";
		
		info += "NIB: " + super.nib + "\n";
		info += this.obterTipo();
		
		return info;
	}
	
	public String mostrarInformacoes()
	{ 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		
		String info = "";

		info += "Saldo: " + super.saldo + "\n";
		info += "NIB: " + super.nib + "\n";
		info += "Data de criacao: " + dateFormat.format(super.datacriacao) + "\n";
		info += "Estado: " + super.activa;
		
		return info;
	}

	public void mostrarSaldo()
	{
		System.out.println("Saldo: " + super.saldo + "€");
	}
	
	public String obterTipo()
	{
		return "Tipo: Debito";
	}
}
