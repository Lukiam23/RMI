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
	public Cliente getCliente(int n)
	{
		Cliente cliente = clientes.get(n);
		return cliente;
	}
	public void remove(String nome)
	{
		for(int i = 0; i<clientes.size();i++)
		{
			if(clientes.get(i).getNome()==nome)
			{
				clientes.remove(i);
			}
		}
		
	}
	public int sizeSala()
	{
		return clientes.size();
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
	public int getId()
	{
		return this.numero;
	}
}
