
package transaccoes;

import java.util.Date;

import contas.Conta;

public class CapitalizacaoJuros extends Transaccao
{
	public CapitalizacaoJuros(Date hora, Conta conta, double valor)
	{
		super(hora, conta, valor);
	}
	
	@Override
	public String mostrar()
	{
		return this.obterTipo() + " - " + super.getHoraFormatada() + " - " + super.getConta().obterNib() + " - " + super.getValor();
	}
	
	@Override
	public String obterTipo()
	{
		return "Capitalizacao de Juros";
	}
}
