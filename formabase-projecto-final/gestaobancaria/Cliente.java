
package gestaobancaria;

public class Cliente
{
	private String nome;
	private int userid;
	private int password;
	private boolean activo;
	
	public Cliente(String nome, int userid, int password)
	{
		this.nome = nome;
		this.userid = userid;
		this.password = password;
	}
	
	public String obterInformacoes()
	{
		String info = "";
		
		info += "Nome: " + this.nome + "\n";
		info += "UserID: " + this.userid + "\n";
		info += "Password: " + this.password + "\n";
		info += "Estado: " + this.activo;
		
		return info;
	}
}
