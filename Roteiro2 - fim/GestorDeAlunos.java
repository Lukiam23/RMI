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
		Aluno aluno = null;
		String str = "";
		while(i<lista.size())
		{
			if(lista.get(i).getCod()==codigo)
			{
				lista.remove(i);
				str="Aluno encontrado e removido.";
			}
			i++;
		}
		return str;		
	}
	public Aluno ConsultarAluno(int codigo) 
	{
		Aluno aluno = null;
		i=0;
		while(i<lista.size())
		{
			System.out.println("O código do aluno é: "+lista.get(i).getCod());
			System.out.println("O código dado é: "+codigo);
			if(lista.get(i).getCod()==codigo)
			{
				System.out.println("O aluno foi encontrado");
				aluno = lista.get(i);
			}
			i++;
		}
		return aluno;
	}
	public String Info()
	{
		String str = "";
		if(lista.size()==0)
		{
			str="Não há alunos";
		}
		for(i =0; i<lista.size(); i++)
		{
			Aluno aluno = lista.get(i);
			str = str+aluno.toString();
			
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
