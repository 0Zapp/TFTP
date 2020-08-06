package pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

	public ServerMain() throws Exception {

		ServerSocket serverSocket = new ServerSocket(2020);
		System.out.println("Otvoren port broj 2020");

		Scanner tastatura = new Scanner(System.in);
		FileInputStream is = null;

		while (is == null) {
			System.out.println("Unesite fajl za slanje (format 'D:\\\\folderA\\\\primer.txt):'");
			String msg = tastatura.nextLine();

			try {
				is = new FileInputStream(msg);
			} catch (FileNotFoundException e) {
				is = null;
				System.out.println("Fajl nije validan.");
			}
		}

		System.out.println("Fajl uspesno ucitan");
		while (true) {

			Socket socket = serverSocket.accept();

			ServerThread serverThread = new ServerThread(socket, is);

			Thread thread = new Thread(serverThread);
			thread.start();

		}

	}

	public static void main(String[] args) {

		try {
			new ServerMain();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
