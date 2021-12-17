package app;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class Net {
	private ConnectionThread connThread = new ConnectionThread();
	private Consumer<Serializable> onReceiveCallback;

	public Net(Consumer<Serializable> onReceiveCallback) {
		this.onReceiveCallback = onReceiveCallback;
		connThread.setDaemon(true);
	}

	public void startConnection() throws Exception {
		connThread.start();
	}

	public void send(Serializable data) throws Exception {
		connThread.out.writeObject(data);
	}

	public void close() throws Exception {
		connThread.socket.close();
	}

	protected abstract String getIP();

	protected abstract int getPort();

	private class ConnectionThread extends Thread {
		private Socket socket;
		private ObjectOutputStream out;

		@Override
		public void run() {
			while (true) {
				try (Socket socket = new Socket(getIP(), getPort());
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
					this.socket = socket;
					this.out = out;
					socket.setTcpNoDelay(true);
					while (true) {
						Serializable data = (Serializable) in.readObject();
						onReceiveCallback.accept(data);
					}
				} catch (Exception e) {
					onReceiveCallback.accept("Connection closed");
				}
			}
		}
	}
}
