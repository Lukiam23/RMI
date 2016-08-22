import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
	void sayHello(String text) throws RemoteException;
}