
package gestaobancaria;

import java.util.ArrayList;

import contas.Conta;

public class Cliente
{
	private String nome;
	private int userid;
	private int password;
	private boolean activo;
	
	private ArrayList<Conta> listaDeContas;
	
	public Cliente(String nome, int userid, int password)
	{
		this.nome = nome;
		this.userid = userid;
		this.password = password;
		this.activo = true;
		
		this.listaDeContas = new ArrayList<Conta>();
	}
	
	public String obterInformacoes()
	{
		String info = "";
		
		info += "Nome: " + this.nome + "\n";
		info += "UserID: " + this.userid + "\n";
		info += "Password: " + this.password + "\n";
		
		if(this.activo)
		{
			info += "Estado: activo";
		}
		else
		{
			info += "Estado: inactivo";
		}
		
		return info;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public int getUserid()
	{
		return this.userid;
	}
	
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	
	public int getPassword()
	{
		return this.password;
	}
	
	public void setPassword(int password)
	{
		this.password = password;
	}
	
	public boolean getActivo()
	{
		return this.activo;
	}
	
	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}
	
	public void adicionarConta(Conta conta)
	{
		if(conta != null)
		{
			this.listaDeContas.add(conta);
			
			return;
		}
		
		System.out.println("A conta nao foi adicionada! A conta nao se encontra criada.");
	}
	
	public ArrayList<Conta> obterContas()
	{
		return this.listaDeContas;
	}
	
	public Conta obterConta(int nib)
	{
		for(Conta conta : this.listaDeContas)
		{
		    if(conta.obterNib() == nib)
		    {
		    	return conta;
		    }
		}
		
		return null;
	}
		
	public void setListaDeContas(ArrayList<Conta> listaDeContas)
	{
		this.listaDeContas = listaDeContas;
	}	
}
