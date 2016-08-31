import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
	public int numero;
	ArrayList <Cliente> clientes = new ArrayList<Cliente>();
	public Sala(int numero)
	{
		this.numero = numero;
	}
	public void add(Cliente cliente)
	{
		clientes.add(cliente);
	}
	public String getInfo()
	{
		int c = 0;
		String str = "";
		while(c<clientes.size())
		{
			str = str+"O cliente: "+clientes.get(c).getNome()+"está na sala:"+numero;
		}
		return str;
	}

}
