package com.commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.converter.base.EscapeConverter;


public class AutoService {
	private static String filePath = "E:/project/maven/code/src/com/model/po/";
	private static String tarFilePath = "E:/project/maven/code/src/com/service/";
	private static File tempFile = new File("E:/test/");
	private static File service;
	private static File serviceImpl;
	public static void main(String[] args) {
		File file = new File(filePath);
		for (File f : tempFile.listFiles()) {
			if ( f.getName().endsWith("Impl.java") ) {
				serviceImpl = f;
			}else if ( f.getName().endsWith("java") ) service = f;
		}		
		travel(file);
	}
	public static void travel(File f) {				
		for (String cpath : f.list()) {
			File file = new File(filePath + cpath);			
			if ( file.isFile() ) {
				String name = file.getName().substring(0, file.getName().indexOf('.'));				
				writeFile(service, name, "Service", ".java");
				writeFile(serviceImpl, name, "ServiceImpl", ".java");
			}else if ( file.isDirectory() ) {
				travel(file);
			}
		}
	}
	private static void writeFile(File src, String name, String add, String ext) {		
		File file = new File(tarFilePath + (src.getName().endsWith("Impl.java") ? "/impl" : ""), name + add + ext);
		try {
			BufferedReader in = new BufferedReader(new FileReader(src));
			String line = null;
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			while ( (line = in.readLine()) != null ) {
				line = line.replaceAll("\\$\\{name\\}", name);
				out.write(line);
				out.newLine();
			}
			out.close();
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

