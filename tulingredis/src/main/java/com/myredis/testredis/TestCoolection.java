package com.myredis.testredis;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.myredis.client.MyClient;

public class TestCoolection {

	public static void main(String[] args) {
		/*ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(6380);
			Socket accept = serverSocket.accept();
			InputStream inputStream = accept.getInputStream();
			byte[] by = new byte[1024];
			inputStream.read(by);
			System.out.println(new String(by));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//MyClient my = new MyClient();
		MyClient myClient = new MyClient("127.0.0.1",6379);
		System.out.println(myClient.set("3132", "54455"));
		System.out.println(myClient.get("3132"));
	}
}
