package com.myredis.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.myredis.protocol.Protocol;

public class Connection {

	
	private String host;
	private int port;
	private OutputStream outputStream;
	private InputStream inputStream;
	private Socket socket;
	
	public Connection(String host,int port) {
		this.port = port;
		this.host = host;
	}

	public void connect() {
		try {
			socket = new Socket(host, port);
			outputStream = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Description: 返回对象本身 （io复用）
	*
	* @version: v1.0.0
	* @date: 2019年2月21日 下午3:48:31
	 */
	public Connection sendMessage(Protocol.Command command,byte[]...bytes) {
		connect();
		Protocol.sendMessage(outputStream, command, bytes);
		return this;
	}
	
	
	public  String getReply() {
		byte[] by = new byte[2048];
		try {
			inputStream = socket.getInputStream();
			inputStream.read(by);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(by);
	}
	
}
