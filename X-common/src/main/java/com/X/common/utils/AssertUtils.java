package com.X.common.utils;

import org.springframework.util.Assert;


public class  AssertUtils{


	public static void notNull(Object obj, String message, Object... args) {
		isTrue(obj != null, "isNull", message, args);
	}


	public  static  void hasLength(Object... args){
		for (int i = 0;i<args.length;i+=2)
            Assert.hasLength((String)args[i], "IllegalArgumentException: "+args[i+1] + " is empty");
		}

	private static void isTrue(boolean value, String tag, String message, Object... args) {
		if (!value) {
			throw new IllegalArgumentException(String.format(tag + ":" + message, args));
		}
	}

}

