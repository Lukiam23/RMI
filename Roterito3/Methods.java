import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Methods  extends Remote
{
	Sala criarSala()throws RemoteException;

	void removerSala(int sala)throws RemoteException;

	String listarSalas()throws RemoteException;

	void adicionar(int nsala, Cliente cliente)throws RemoteException;

	void remover(int nsala, String nome)throws RemoteException;

	String listar(int nsala)throws RemoteException;

	void encaminhaMensagem (int nsala, String msg, Cliente nome)throws RemoteException;

	Mensagem getMensagem() throws RemoteException;

}
