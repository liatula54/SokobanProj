package Xmlcoder;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class XMLUtil {
	
	//default c'tor
	public XMLUtil(){}
	
	//write object to an XML File
	public static void encoder (Object obj, String file_name) throws FileNotFoundException
	{
			XMLEncoder e = new XMLEncoder(
					new BufferedOutputStream(
			        new FileOutputStream(file_name)));
			e.writeObject(obj);
			e.close();	
	}
	
	//reading an object from an XML file
	public static Object decoder (InputStream is)
	{
		BufferedInputStream in=new BufferedInputStream(is);
		XMLDecoder dx= new XMLDecoder(in);
		Object obj = dx.readObject();
		dx.close();
		
		return obj;	
	}
 

}
