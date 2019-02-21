package com.myredis.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {

	private static final String STRING_VAL= "$";
	private static final String ARRAY_VAL= "*";
	private static final String BLANK_VAL = "\r\n";
	
	/**
	 * 
	* @Description: resp协议组装
	*
	* @version: v1.0.0
	* @date: 2019年2月21日 下午3:45:36
	 */
	public static void sendMessage(OutputStream outputStream,Command command,byte[]...bytes) {
		StringBuffer suBuffer = new StringBuffer();
		suBuffer.append(ARRAY_VAL).append(bytes.length+1).append(BLANK_VAL);
		suBuffer.append(STRING_VAL).append(command.name().length()).append(BLANK_VAL);
		suBuffer.append(command.name()).append(BLANK_VAL);
		
		for (byte[] bs : bytes) {
			suBuffer.append(STRING_VAL).append(bs.length).append(BLANK_VAL);
			suBuffer.append(new String(bs)).append(BLANK_VAL);
		}
		try {
			outputStream.write(suBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static enum Command{
		SET,GET;
	}
}
