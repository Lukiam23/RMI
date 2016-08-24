import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GestorDeAlunos extends UnicastRemoteObject implements Methods 
{
	int i;
	public GestorDeAlunos() throws RemoteException {
		super();
	}
	ArrayList<Aluno> lista = new ArrayList<Aluno>();
	
	public void AdicionarAluno(String nome, int codigo, String n1, String n2, String n3, String freq)
	{
		Aluno aluno = new Aluno(nome,codigo,n1,n2,n3,freq);
		lista.add(aluno);
		for(i =0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i).getNome());
		}
	}
	public String RemoverAluno(int codigo) 
	{
		i = 0;
		String resultado = "Este aluno não está cadastrado";
		while(i<lista.size())
		{
			if(lista.get(i).getCod()==codigo)
			{
				lista.remove(i);
				resultado = "Aluno removido";
			}
			i++;
		}
		return resultado;
	}
	public Aluno ConsultarAluno(int codigo) 
	{
		Aluno aluno = null;
		for(i=0; i<lista.size(); i++)
		{
			if(lista.get(i).getCod()==codigo)
			{
				System.out.println("Found");
				aluno = lista.get(i);
			}
		}
		System.out.println("OK");
		return aluno;
	}
	public String Info()
	{
		String str = null;
		for(i =0; i<lista.size(); i++)
		{
			Aluno aluno = lista.get(i);
			str = str+aluno.show(aluno);
			
		}
		return str;
	}
	public static void main(String args[])
	{
		try 
		{
			GestorDeAlunos obj = new GestorDeAlunos();
			
			Naming.rebind("//localhost/AlunoServer", obj);
			System.out.println("Gestor de Alunos rodando: \n");
		} catch (Exception e) 
		{
			System.out.println("Erro encontrado: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
