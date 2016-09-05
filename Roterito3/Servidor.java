import java.util.ArrayList;
import java.util.Hashtable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Servidor extends UnicastRemoteObject implements Methods{

	public static int contador;
	public static int contadorBuffer =0;
	public Hashtable<Cliente,String> buffer;
	public Servidor() throws RemoteException {
		super();
		contador=0;
	}
	ArrayList <Sala> salas = new ArrayList<Sala>();
	public Sala criarSala() throws RemoteException 
	{
		Sala sala = new Sala(contador);	
		salas.add(sala);
		contador++;
		
		return sala;
	}
	public void removerSala(int sala)
	{
		salas.remove(sala);
	}
	public String listarSalas() 
	{
		int n = salas.size();
		String str = "Há "+n+"salas livres.";
		return str;
	}
	public void adicionar(int nsala, Cliente cliente)
	{
		Sala obj = salas.get(nsala);
		obj.add(cliente);
		
	}
	public void remover(int nsala,String nome)
	{
		Sala obj = salas.get(nsala);
		obj.remove(nome);
	}

	@Override
	public String listar(int nsala)
	{
		int i = 0;
		String str = "Os seguintes clientes estão na sala "+nsala;
		while(i<salas.size())
		{
			str = str + salas.get(i).toString();
		}
		return str;
	}

	public void encaminhaMensagem(int nsala, String msg,String nome)
	{
		int i = 0;
		while(i<salas.get(nsala).sizeSala())
		{
			Cliente obj = salas.get(nsala).getCliente(i);
			buffer.put(obj, msg);
		}
	}
	public String getMensagem()
	{
		if(contadorBuffer!=buffer.size())
		{
			contadorBuffer=buffer.size();
			return  buffer.get(buffer.size());			
		}
		else
		{
			return null;
		}
	}
	public static void main(String args[]) 
	{
		try 
		{
			Servidor obj = new Servidor();
			
			Naming.rebind("//localhost/Chat", obj);
			System.out.println("Servidor rodando...");
		} catch (Exception e) 
		{
			System.out.println("Erro no servidor: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
