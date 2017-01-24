// TODO: inicializar jurosAcumulados e aplicar taxa de juro


package contas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prazo extends Conta
{	
	private double taxaJuro;
	private Date validade;
	private double jurosAcumulados;
	
	public Prazo()
	{
		super();
		
		this.taxaJuro = 0.05;
		
		Calendar cal = Calendar.getInstance();
		super.datacriacao = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		this.validade = cal.getTime();
		
		this.jurosAcumulados = 0;
	}
	
	public double getTaxaJuro()
	{
		return this.taxaJuro;
	}
	
	public void setTaxaJuro(double taxaJuro)
	{
		this.taxaJuro = taxaJuro;
	}
	
	public Date getValidade()
	{
		return this.validade;
	}
	
	public void setValidade(Date validade)
	{
		this.validade = validade;
	}
	
	public double getJurosAcumulados()
	{
		return this.jurosAcumulados;
	}
	
	public void setJurosAcumulados(double jurosAcumulados)
	{
		this.jurosAcumulados = jurosAcumulados;
	}	
	
	public boolean levantar(double valor)
	{
		if(this.saldo >= valor)
		{
			this.saldo -= valor;
			
			return true;
		}
		
		return false;
	}
	
	public boolean transferir(double valor, Conta contadestino)
	{
		if(this.saldo >= valor)
		{
			this.saldo -= valor;
			contadestino.saldo += valor;
		}
		
		return false;
	}
	
	public String mostrar()
	{
		String info = "";
		
		info += "NIB: " + this.nib + "\n";
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
		System.out.println("Saldo: " + this.saldo + "€");
	}
	
	public String obterTipo()
	{
		return "Tipo: Prazo";
	}
}
