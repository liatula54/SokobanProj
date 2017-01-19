package Serialization;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {
	
	//default c'tor
	public SerializationUtil(){}
	
	// deserialize to Object from given file
		public static Object deserialize(InputStream is) throws IOException, ClassNotFoundException{
			ObjectInputStream ois = new ObjectInputStream(is);
			Object obj = ois.readObject();
			ois.close();
			return obj;
		}

		// serialize the given object and save it to file
		public static void serialize(Object obj, String fileName) throws FileNotFoundException, IOException{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);

			fos.close();
		}

	
}
