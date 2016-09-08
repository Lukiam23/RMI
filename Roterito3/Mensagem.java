import java.io.Serializable;

public class Mensagem implements Serializable{
	private int id,nsala;
	private String msg,nome;
	public Mensagem(int id,String msg, int nsala, String nome)
	{
		this.id = id;
		this.msg = msg;
		this.nsala = nsala;
		this.nome = nome;
	}
	
	public int getId()
	{
		return id;
	}
	public String getMsg()
	{
		return msg;
	}
	public int getNsala()
	{
		return nsala;
	}
	public String getNome()
	{
		return this.nome;
	}
}
