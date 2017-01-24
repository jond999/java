
package transaccoes;

import java.text.SimpleDateFormat;
import java.util.Date;

import contas.Conta;

public abstract class Transaccao
{
	private Conta conta;
	private Date hora;
	private double valor;
	
	public Transaccao(Date hora, Conta conta, double valor)
	{
		this.hora = hora;
		this.conta = conta;
		this.valor = valor;
	}
	
	public Conta getConta()
	{
		return this.conta;
	}
	
	public void setConta(Conta conta)
	{
		this.conta = conta;
	}
	
	public Date getHora()
	{
		return this.hora;
	}
	
	public void setHora(Date hora)
	{
		this.hora = hora;
	}
	
	public double getValor()
	{
		return this.valor;
	}
	
	public void setValor(double valor)
	{
		this.valor = valor;
	}	
	
	public abstract String mostrar();
	public abstract String obterTipo();
	
	public String getHoraFormatada()
	{
		SimpleDateFormat horaFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		return horaFormat.format(this.hora);			
	}
}
