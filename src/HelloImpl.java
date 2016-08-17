import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello 
{

	public HelloImpl() throws RemoteException 
	{
		super();
	}

	public String sayHello() 
	{
		return "Hello World!";
	}
	public static void main(String args[]) 
	{

		try 
		{

			HelloImpl obj = new HelloImpl();
			
			Naming.rebind("//localhost/HelloServer", obj);
			System.out.println("HelloServer bound in registry");
		} catch (Exception e) 
		{
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}
}