
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ShifumiServer {
	public  static void start(){
		try {
			ServerSocket s = new ServerSocket(3024);
			Socket c =s.accept();
			System.out.println("Serveur: Connexion établie");
			jouer(c);

			c.close();
			s.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void jouer(Socket adversaire){
		OutputStream os;
		try {
			os = adversaire.getOutputStream();
			try {
				//envoit au client
				System.out.println("Serveur : Pierre, Feuille ou Ciseaux ?");
				Scanner sc = new Scanner(System.in);
				String jeuServeur=sc.nextLine();

				System.out.println("Serveur : a joué " +jeuServeur+" !");
				os.write(jeuServeur.getBytes());

				//reÃ§oit du client
				InputStream is = adversaire.getInputStream();
				byte b2[]=new byte[50];
				is.read(b2, 0, 50);
				String jeuClient=new String(b2);
				System.out.println("Serveur : le client a répondu : "+jeuClient);

				sc.close();

				switch (jeuServeur.trim())
				{
				case "Pierre":
					switch (jeuClient.trim())
					{
					case "Pierre":
						System.out.println("Serveur : It's a draw !");
						break;   
					case "Feuille":
						System.out.println("Serveur : You lose ! ");
						break;   

					case "Ciseaux":
						System.out.println("Serveur : You win ! ");
						break;   

					default:
						System.out.println("Serveur : Hmm... Il y a une erreur ! Ã¨.Ã©");;             
					};
					break;
				
				case "Feuille":
					switch (jeuClient.trim())
					{
					case "Pierre":
						System.out.println("Serveur : You win !");
						break;   
					case "Feuille":
						System.out.println("Serveur : It's a draw ! ");
						break;   

					case "Ciseaux":
						System.out.println("Serveur : You lose ! ");
						break;   

					default:
						System.out.println("Serveur : Hmm... Il y a une erreur ! è.é");;             
					};
					break;
				case "Ciseaux":
					switch (jeuClient.trim())
					{
					case "Pierre":
						System.out.println("Serveur : You lose !");
						break;   
					case "Feuille":
						System.out.println("Serveur : You win ! ");
						break;   

					case "Ciseaux":
						System.out.println("Serveur : It's a draw ! ");
					default:
						System.out.println("Serveur : Hmm... Il y a une erreur ! è.é");   
						break;   

					};
					break;
				default:
					System.out.println("Serveur : Hmm... Il y a une erreur ! è.é");             
				}


			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}







	}
}
