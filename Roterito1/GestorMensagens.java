import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GestorMensagens extends UnicastRemoteObject implements Hello 
{

	public GestorMensagens() throws RemoteException 
	{
		super();
	}

	public void sayHello(String  texto) 
	{
		System.out.println(texto);
	}
	public void enviarMensagem(String nome, String msg)
	{
		System.out.println(nome+" diz: "+msg);
	}
	public static void main(String args[]) 
	{
		try 
		{
			GestorMensagens obj = new GestorMensagens();
			
			Naming.rebind("//localhost/HelloServer", obj);
			System.out.println("HelloServer bound in registry");
		} catch (Exception e) 
		{
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}
}