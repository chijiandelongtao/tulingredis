package com.tulingredis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	
	public static void main(String[] args) {
		Jedis jedi = new Jedis("127.0.0.1",6380);
		jedi.set("aaa", "sass");
		//String value = jedi.get("test");
		//System.out.println(value);
		jedi.close();
	}
}
