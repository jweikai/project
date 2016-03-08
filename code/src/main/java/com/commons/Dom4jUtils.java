package com.commons;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4jUtils {
	private static Document document;	
	static {		
		try {
			document = new SAXReader().read(Dom4jUtils.class.getClassLoader().getResourceAsStream("data.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) {
		
	}
}
