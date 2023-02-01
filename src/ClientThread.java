import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {
	
	public Socket serv;
	public DataInputStream is;
	public Scanner sc;
	
	@Override
	public void run() {
		while(true) {
			try {
				String msg = is.readUTF();
				System.out.println(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public ClientThread(Socket serv, DataInputStream is) {
		this.serv = serv;
		this.is = is;
		this.sc = new Scanner(System.in);
	}
	
}
