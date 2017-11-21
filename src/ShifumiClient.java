
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ShifumiClient {
	public  static void start(){
		try {
			
			//connect au serveur
			InetSocketAddress serverAddress =
					new InetSocketAddress("localhost", 3024);
			Socket c = new Socket();	
			c.connect(serverAddress);
			System.out.println("Client: Connexion établie");
			System.out.println("");
			
			//reÃ§oit le jeu du serveur
			InputStream is = c.getInputStream();
			byte b[]=new byte[50];
			is.read(b, 0, 50);
			String jeuServeur=new String(b);
			
			//envoit au serveur
			System.out.println("Client : Pierre, Feuille ou Ciseaux ?");
			Scanner scs = new Scanner(System.in);
			String jeuClient=scs.nextLine();
			
			System.out.println("Client : a joué " +jeuClient+" !");
			///////////A verifier
			OutputStream os= c.getOutputStream();
			os.write(jeuClient.getBytes());
			
			c.close();
			switch (jeuClient.trim())
			{
			case "Pierre":
				switch (jeuServeur.trim())
				{
				case "Pierre":
					System.out.println("Client : It's a draw !");
					break;   
				case "Feuille":
					System.out.println("Client : You lose ! ");
					break;   

				case "Ciseaux":
					System.out.println("Client : You win ! ");
					break;   

				default:
					System.out.println("Client : Hmm... Il y a une erreur ! è.é");;             
				};
				break;
			
			case "Feuille":
				switch (jeuServeur.trim())
				{
				case "Pierre":
					System.out.println("Client : You win !");
					break;   
				case "Feuille":
					System.out.println("Client : It's a draw ! ");
					break;   

				case "Ciseaux":
					System.out.println("Client : You lose ! ");
					break;   

				default:
					System.out.println("Client : Hmm... Il y a une erreur ! è.é");;             
				};
				break;
			case "Ciseaux":
				switch (jeuServeur.trim())
				{
				case "Pierre":
					System.out.println("Client : You lose !");
					break;   
				case "Feuille":
					System.out.println("Client : You win ! ");
					break;   

				case "Ciseaux":
					System.out.println("Client : It's a draw ! ");
					break;   

				default:
					System.out.println("Client : Hmm... Il y a une erreur ! è.é");            
				};
				break;
			default:
				System.out.println("Client : Hmm... Il y a une erreur ! è.é");             
			}
			System.out.println("Client : le Serveur a répondu : "+jeuServeur);
			scs.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
