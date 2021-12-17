package app;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends Net {

	private String ip;
	private int port;

	public Client(String ip, int port, Consumer<Serializable> onReceiveCallback) {
		super(onReceiveCallback);
		this.ip = ip;
		this.port = port;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getIP() {
		// TODO Auto-generated method stub
		return ip;
	}

	@Override
	protected int getPort() {
		// TODO Auto-generated method stub
		return port;
	}

}