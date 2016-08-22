import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetorMensagens extends UnicastRemoteObject implements Hello 
{

	public GetorMensagens() throws RemoteException 
	{
		super();
	}

	public void sayHello(String  texto) 
	{
		System.out.println(texto);
	}
	public String enviarMensagem(String nome, String msg)
	{
		return nome+" diz: "+msg;
	}
	public static void main(String args[]) 
	{
		try 
		{
			GetorMensagens obj = new GetorMensagens();
			
			Naming.rebind("//localhost/HelloServer", obj);
			System.out.println("HelloServer bound in registry");
		} catch (Exception e) 
		{
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}
}