package com.myredis.client;

import com.myredis.connection.Connection;
import com.myredis.protocol.Protocol;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @Description: 操作层 这是操作redis的 Api
*
* @version: v1.0.0
* @author: 持剑的龙套
* @date: 2019年2月21日 下午3:15:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年2月21日     持剑的龙套           v1.0.0               修改原因
 */
public class MyClient {

	Connection connection;
	
	public MyClient(){}
	
	public MyClient(String host,int port) {
		connection = new Connection(host, port);
	}
	/**
	 * 
	* @Description: 向redis 存储元素
	*
	* @version: v1.0.0
	* @date: 2019年2月21日 下午3:16:18
	 */
	public String set(String key,String value) {
		connection.sendMessage(Protocol.Command.SET, key.getBytes(),value.getBytes());
		return connection.getReply();
	}
	
	/**
	 * 
	* @Description: 获取redis中的元素
	*
	* @version: v1.0.0
	* @date: 2019年2月21日 下午3:15:36
	 */
	public String get(String key) {
		connection.sendMessage(Protocol.Command.GET, key.getBytes());
		return connection.getReply();
	}
}
