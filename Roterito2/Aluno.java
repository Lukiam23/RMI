import java.rmi.Naming;
import java.util.*;

public class Aluno {
	public String nome,n1, n2, n3, freq;
	public static int codigo;
	public Aluno(String nome,int codigo,String n1,String n2,String n3,String freq)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3; 
		this.freq = freq;

	}
	public String getNome()
	{
		return nome;
	}
	public int getCod()
	{
		return codigo;
	}
	public String getN1()
	{
		return n1;
	}
	public String getN2()
	{
		return n2;
	}
	public String getN3()
	{
		return n3;
	}
	public String getFreq()
	{
		return freq;
	}
	public String show(Aluno aluno)
	{
		String result = "\nNome:  "+aluno.getNome()+" C�digo: "+aluno.getCod()+" nota 1: "+aluno.getN1()+" nota 2: "+aluno.getN2()+" nota 3: "+aluno.getN3()+" Frequ�ncia: "+aluno.getFreq();
		return result;
	}
	public static void main(String args[])
	{
		while(true)
		{
			try
			{
				Methods obj = (Methods) Naming.lookup("//localhost/AlunoServer");
				System.out.println("Digite a sua escolha:\n1.Cadastrar Aluno\n2.Remover aluno\n3.Consutar Aluno\n4.Ver informa��es de todos os alunos\n");
				Scanner escolha = new Scanner(System.in);
				int  esc = escolha.nextInt();
				if(esc==1)
				{
						
						System.out.println("Coloque o seu nome: ");
						Scanner scanNome = new Scanner(System.in);
						String nome = scanNome.nextLine();
						System.out.println("Coloque o seu c�digo: ");
						Scanner scanCod = new Scanner(System.in);
						int cod = scanCod.nextInt();
						System.out.println("Coloque a n1: ");
						Scanner scanN1 = new Scanner(System.in);
						String n1 = scanN1.nextLine();
						System.out.println("Coloque a n2: ");
						Scanner scanN2 = new Scanner(System.in);
						String n2 = scanN2.nextLine();
						System.out.println("Coloque a n3: ");
						Scanner scanN3 = new Scanner(System.in);
						String n3 = scanN3.nextLine();
						System.out.println("Coloque a frequ�ncia: ");
						Scanner scanFreq = new Scanner(System.in);
						String freq = scanFreq.nextLine();
						obj.AdicionarAluno(nome, cod, n1, n2, n3, freq);
						
				}
				if(esc==2)
				{
					System.out.println("Coloque o c�digo do  aluno a ser removido:");
					Scanner scanner = new Scanner(System.in);
					codigo = scanner.nextInt();
					System.out.println(obj.RemoverAluno(codigo));
				}
				if(esc==3)
				{
					System.out.println("Coloque o c�digo do aluno a ser consultado: ");
					Scanner esc3 = new Scanner(System.in);
					codigo = esc3.nextInt();
					System.out.println("Voc� digitou: "+codigo);
					if(obj.ConsultarAluno(codigo)==null)
					{
						System.out.println("C�digo n�o cadastrado");
					}
					else
					{
						System.out.println(obj.ConsultarAluno(codigo).show(obj.ConsultarAluno(codigo)));
					}
					
				}
				if(esc==4)
				{
					System.out.println(obj.Info());
				}
				if(esc==5)
				{
					break;
				}
				else
				{
					System.out.println("Opera��o inv�lida");
				}
			}
			catch(Exception e) {
				System.out.println("Erro de execu��o: " + e.getMessage());
				e.printStackTrace();
			}
			
			
		}
	}
	
}
