
package contas;

public class Debito extends Conta
{	
	@Override
	public boolean levantar(double valor)
	{
		if(super.saldo >= valor)
		{
			super.saldo -= valor;
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean transferir(double valor, Conta contadestino)
	{
		if(super.saldo >= valor)
		{
			super.saldo -= valor;
			contadestino.saldo += valor;
		}
		
		return false;
	}
	
	@Override
	public String mostrar()
	{
		this.mostrarSaldo();
		
		String info = "";
		
		info += "NIB: " + super.nib + "\n";
		info += this.obterTipo();
		
		return info;
	}
	
	@Override
	public String mostrarInformacoes()
	{ 		
		String info = "";

		info += this.mostrar() + "\n";
		info += "Data de criacao: " + super.getDataFormatada() + "\n";
		
		if(super.activa)
		{
			info += "Estado: activa";
		}
		else
		{
			info += "Estado: inactiva";
		}
		
		return info;
	}

	@Override
	public void mostrarSaldo()
	{
		System.out.println("Saldo: " + super.saldo + " €");
	}
	
	@Override
	public String obterTipo()
	{
		return "Tipo: Debito";
	}
}
