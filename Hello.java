import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
	void sayHello(String text) throws RemoteException;
	String enviarMensagem(String nome, String msg) throws RemoteException;
}