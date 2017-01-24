
package transaccoes;

import java.util.Date;

import contas.Conta;

public class Transferencia extends Transaccao
{
	private Conta destino;
	
	public Transferencia(Date hora, Conta origem, double valor, Conta destino)
	{
		super(hora, origem, valor);
		
		this.destino = destino;
	}
	
	public Conta getContaDestino()
	{
		return this.destino;
	}
	
	public void setContaDestino(Conta destino)
	{
		this.destino = destino;
	}
	
	@Override
	public String mostrar()
	{
		return this.obterTipo() + " - " + super.getHoraFormatada() + " - " + super.getConta().obterNib() + " - " + super.getValor();
	}
	
	@Override
	public String obterTipo()
	{
		return "Transferencia";
	}
}
