import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;
public class Cliente implements Serializable
{
	//Os comentarios nao estao acentuados, pois o github buga tudo depois, sorry
	public String nome;//Nome do cliente
	public Integer nsala;//numero da sala
	public static int id=0;//Servira para identificar as mensagens, sera como o id de mensagens
	public Cliente()
	{
		super();
	}
	public String getNome()
	{
		return this.nome;
	}
	public void setNome(String nome)
	{
		this.nome =nome;
	}
	public String toString()
	{
		return "\nNome: "+this.nome;
	}
	public Integer getNsala()
	{
		return this.nsala;
	}
	public void setNsala(Integer nsala)
	{
		this.nsala = nsala;
	}
	public int getID()
	{
		return this.id;
	}
	public void setID(int id)
	{
		this.id = id;
	}

	public static void main (String args[]) 
	{
		try 
		{
			Methods obj = (Methods) Naming.lookup("//localhost/Chat");
			//Pega o nome do Cliente
			System.out.print("Coloque o nome: ");
			Scanner catchname = new Scanner(System.in);
			String nome = catchname.nextLine();
			boolean fim = false;


			//Cria o Cliente
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			//Agora começa a noia
			Thread checkingPrivado = new Thread()
			{
				public void run()
				{
					try
					{

					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			};
			Thread checking = new Thread()//Essa Thread ficara verifiando se ha mensagens
					{
				public void run()
				{
					try
					{
						obj.encaminhaMensagem(cliente.getID(), "Entrei na sala", cliente);
						boolean fim = false;
						while(fim==false)
						{
							ArrayList<Mensagem> lista = obj.getMensagem(cliente.getID());//Pega um objeto mensagem, a mensagem tem todas as informaçõe que eu necessito

							for(Mensagem mensagem:lista)
							{

								if(mensagem.getId()>cliente.getID() && mensagem.getNsala()==cliente.nsala)//Aqui eu comparo o meu id com o id do objeto mensagem, caso o meu id for menor que eu  printo a mensagem e troco o id
								{
									if(!mensagem.getNome().equals(cliente.getNome()) && !mensagem.getMsg().equals("sair()") && !mensagem.getMsg().equals("listar()") && mensagem.getDest().equals("all"))//Isso fará que a mensagem que eu digitar não volte para mim
									{

										System.out.println("\n"+mensagem.getNome()+": "+mensagem.getMsg());
										cliente.setID(mensagem.getId());
									}
									else if(mensagem.getDest().equals(cliente.getNome()))
									{
										System.out.println("\n"+mensagem.getNome()+": "+mensagem.getMsg());
										cliente.setID(mensagem.getId());
									}

									else if(mensagem.getNome().equals(cliente.getNome()) && mensagem.getMsg().equals("sair()") )
									{
										obj.remover(cliente.getNsala(), mensagem.getNome());
										System.out.println("Você saiu da sala");
										fim=true;
									}
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
							while(!msg.equals("sair()"))
							{
								try
								{
									System.out.print(cliente.getNome()+" : ");
									Scanner scan = new Scanner(System.in);
									msg = scan.nextLine();
									obj.encaminhaMensagem(cliente.nsala, msg, cliente);
									Thread.sleep(10);
									if(msg.equals("listar()"))
									{
										System.out.println(obj.listar(cliente.getNsala()));
									}
									else if(msg.equals("jt()"))
									{
										System.out.println("Coloque o destinatário: ");
										Scanner dest = new Scanner(System.in);
										String destinatario = dest.nextLine();
										while(!msg.equals("retornar()"))
										{
											System.out.println(cliente.getNome()+" : ");
											Scanner msgp = new Scanner(System.in);
											msg= msgp.nextLine();

											obj.encaminhaMensagem(cliente.getNsala(), msg, cliente, destinatario);
										}
									}
								}
								catch(Exception e)
								{
									System.out.println("Erro na thread cheking: "+e);
									e.printStackTrace();
								}
							}

						}


					};
					int choice = 0;
					while(true)
					{
						System.out.println("Escolha:\n1.Você gostaria de criar uma sala.\n2.Entrar em uma já existente.");
						Scanner catchchoice = new Scanner(System.in);
						choice = catchchoice.nextInt();	
						if(choice==1)
						{
							Sala sala = obj.criarSala();
							cliente.nsala = sala.getId();
							obj.adicionar(cliente.nsala, cliente);
							System.out.println("O número da sua sala e: "+sala.getId());
							break;
						}
						else if(choice==2)
						{
							System.out.println("Digite o número da sala: ");
							Scanner catchchoice2 = new Scanner(System.in);
							cliente.setNsala(catchchoice2.nextInt());
							obj.adicionar(cliente.getNsala(), cliente);
							break;
						}
						else
						{
							System.out.println("Não há essa escolha");
						}
					}
					checking.start();
					sending.start();

		} catch (Exception e) {

			System.out.println("Erro no Cliente: " + e.getMessage());

			e.printStackTrace();
		}
	}
}
