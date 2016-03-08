package com.commons;

import java.util.UUID;

public class UUIDUtil {
	public static String getRanID() {
		return UUID.randomUUID().toString();
	}
}
