import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientProgram {

	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.print("Digite um nome de usuario: ");
			String userName = sc.nextLine();
			Socket conn = new Socket(InetAddress.getLocalHost(), 5555);
			System.out.println("Conectado ao server");
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			
			while(true) {
				String msg = sc.nextLine();
				os.writeUTF(userName+" : "+msg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			sc.close();
		}
	}

}
