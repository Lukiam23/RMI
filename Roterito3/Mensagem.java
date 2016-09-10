import java.io.Serializable;

public class Mensagem implements Serializable{
	private int id,nsala;
	private String msg,nome,destino;
	public Mensagem(int id,String msg, int nsala, String nome,String destino)
	{
		this.id = id;
		this.msg = msg;
		this.nsala = nsala;
		this.nome = nome;
		this.destino = destino;
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
	public String getDest()
	{
		return this.destino;
	}
}
