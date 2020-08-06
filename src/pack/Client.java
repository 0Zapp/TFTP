package pack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {

		Socket socket = new Socket("localhost", 2020);

		System.out.println("Uspesno povezivanje na server");

		byte[] b = new byte[1000];

		InputStream is = socket.getInputStream();
		FileOutputStream os = null;

		while (os == null) {
			System.out.println("Unesite lokaciju za preuzimanje (format 'D:\\\\folderA\\\\folderB'):");

			Scanner tastatura = new Scanner(System.in);
			String msg = tastatura.nextLine();

			try {
				os = new FileOutputStream(msg + "\\primer.txt");
			} catch (FileNotFoundException e) {
				os = null;
				System.out.println("Lokacija nije validna.");
			}
		}

		is.read(b, 0, b.length);
		os.write(b, 0, b.length);
		System.out.println("Fajl uspesno sacuvan.");

		socket.close();

	}

	public static void main(String[] args) {

		try {

			new Client();

		} catch (Exception e) {
			System.out.println("Server nije pravilno konfigurisan.");
		}

	}

}
