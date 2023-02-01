import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5555);
			while (true) {
				Socket cl = ss.accept();
				System.out.println("Bem vindo cliente: "+cl.getInetAddress().getHostAddress());
				DataInputStream is = new DataInputStream(cl.getInputStream());
				ClientThread client = new ClientThread(cl, is);
				client.start();
			}

		} catch (IOException e) {
			try {
				if(ss != null)
					ss.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
