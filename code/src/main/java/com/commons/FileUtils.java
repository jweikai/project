package com.commons;

import java.io.File;

public class FileUtils {
	private static String imgRegex = "^jpe?g|png|gif|bmp$";
	public static String getExt(File file) {
		String name = file.getName();
		return name.substring(name.lastIndexOf('.') + 1).toLowerCase();
	}
	public static boolean isImage(String imgExt) {
		return imgExt.matches(imgRegex);
	}
	public static boolean isImage(File file) {
		return isImage(getExt(file));
	}
}
