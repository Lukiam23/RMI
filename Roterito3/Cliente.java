import java.io.Serializable;
import java.rmi.Naming;
import java.util.*;
public class Cliente implements Serializable
{
	public String nome;
	
	public Cliente(String nome)
	{
		super();
		this.nome = nome;
	}
	public String getNome()
	{
		return this.nome;
	}

}
