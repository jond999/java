
package contas;

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
	
	private void aplicaTaxaDeJuro(double valor)
	{
		Date datahoje = new Date();
		
		int criacao = (int) super.datacriacao.getTime() / 1000;
		int validade = (int) this.validade.getTime() / 1000;
		int hoje =  (int) datahoje.getTime() / 1000;
		
		double tempo_decorrido = (1.0) * (hoje / (validade - criacao));
		
		this.jurosAcumulados += tempo_decorrido * this.taxaJuro * valor;
	}
	
	@Override
	public boolean levantar(double valor)
	{
		if(super.saldo >= valor)
		{
			super.saldo -= valor;
			
			this.aplicaTaxaDeJuro(valor);
			
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
			
			this.aplicaTaxaDeJuro(valor);
		}
		
		return false;
	}
	
	@Override
	public String mostrar()
	{
		this.mostrarSaldo();
		
		String info = "";
		
		info += "NIB: " + super.nib + "\n";
		info += "Tipo: " + this.obterTipo();
		
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
		System.out.println("Juros acumulados: " + this.jurosAcumulados + " €");
	}
	
	@Override
	public String obterTipo()
	{
		return "Prazo";
	}
}
