import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface Methods  extends Remote
{
	Sala criarSala()throws RemoteException;

	void removerSala(int sala)throws RemoteException;

	String listarSalas()throws RemoteException;

	void adicionar(int nsala, Cliente cliente)throws RemoteException;

	void remover(int nsala, String nome)throws RemoteException;

	String listar(int nsala)throws RemoteException;

	void encaminhaMensagem (int nsala, String msg, Cliente nome)throws RemoteException;
	
	void encaminhaMensagem (int nsala, String msg, Cliente nome,String nomedestino)throws RemoteException;

	ArrayList<Mensagem> getMensagem(int idCliente) throws RemoteException;

}
