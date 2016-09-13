import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin 
{
	public static void main(String args[])
	{
		try
		{
			Methods objeto = (Methods) Naming.lookup("//localhost/Chat");
			Cliente admin = new Cliente();
			admin.setNome("Administrador");
			int escolha =0;

			Thread checking = new Thread()//Essa Thread ficara verifiando se ha mensagens
					{
				public void run()
				{
					try
					{
						boolean fim = false;
						while(fim==false)
						{
							ArrayList<Mensagem> lista = objeto.getMensagem(admin);//Pega um objeto mensagem, a mensagem tem todas as informaçõe que eu necessito

							for(Mensagem mensagem:lista)
							{
								if(mensagem.getId()>admin.getID() && mensagem.getNsala()==admin.getNsala() && !mensagem.getNome().equals(admin.getNome()))//Aqui eu comparo o meu id com o id do objeto mensagem, caso o meu id for menor que eu  printo a mensagem e troco o id
								{
									System.out.println("\n"+mensagem.getNome()+": "+mensagem.getMsg());
									admin.setID(mensagem.getId());
								}								
							}
							Thread.sleep(10);
						}
					}


					catch(Exception e)
					{
						System.out.println("Erro na thread cheking: "+e);
						e.printStackTrace();
					}

				}
					};

					Thread sending = new Thread()
					{
						public void run()
						{
							String msg = "";

							try
							{
								while(!msg.equals("sair()"))

								{
									System.out.print(admin.getNome()+" : ");
									Scanner scan = new Scanner(System.in);
									msg = scan.nextLine();
									Thread.sleep(10);
								}
							}
							catch(Exception e)
							{
								System.out.println("Erro na thread sending: "+e);
								e.printStackTrace();
							}

						}
					};
					while(escolha!=6)
					{
						System.out.println("1.Criar sala\n2.Deletar sala\n3.Espiar sala\n4.Listar Salas\n5.Remover Cliente\n6.Sair");
						Scanner scan = new Scanner(System.in);
						escolha = scan.nextInt();
						switch(escolha)
						{
						case 1:
							Sala sala = objeto.criarSala();
							admin.nsala = sala.getId();
							objeto.adicionar(admin.nsala, admin);
							System.out.println("O número da sua sala e: "+sala.getId());
							break;
						case 2:
							System.out.print("Coloque o número da sala: ");
							Scanner scan2 = new Scanner(System.in);
							objeto.removerSala(scan2.nextInt());
							break;
						case 3:
							System.out.print("Digite a sala que quer verificar: ");
							Scanner scan3 = new Scanner(System.in);
							admin.setID(scan3.nextInt());
							checking.start();
							sending.start();
							break;
						case 4:
							System.out.println(objeto.listarSalas());
							break;
						case 5:
							System.out.println("Coloque o nome do cliente:");
							Scanner scan4 =new Scanner(System.in);
							String nome = scan4.nextLine();
							System.out.println("Coloque o número da sala:");
							Scanner scan5 =new Scanner(System.in);
							int nsala = scan5.nextInt();
							objeto.remover(nsala,nome);
							break;
						}
					}
		}
		catch(Exception e)
		{
			System.out.println("Erro no admin: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
