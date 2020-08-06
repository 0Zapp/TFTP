package pack;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket socket;
	private FileInputStream is;

	public ServerThread(Socket socket, FileInputStream is) {

		this.socket = socket;
		this.is = is;

	}

	@Override
	public void run() {

		try {

			byte b[] = new byte[1000];
			is.read(b, 0, b.length);

			OutputStream os = socket.getOutputStream();
			os.write(b, 0, b.length);

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}