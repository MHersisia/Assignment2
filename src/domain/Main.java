package domain;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import userinterface.MainFrame;

public class Main {

	public static void main(String[] args) {
		Context c = new Context();
		
		Purpose p1 = new Purpose("Creational"); c.addPurpose(p1);
		Purpose p2 = new Purpose("Structural"); c.addPurpose(p2);
		Purpose p3 = new Purpose("Behavioral"); c.addPurpose(p3);
		
		Scope s1 = new Scope("Class"); c.addScope(s1);
		Scope s2 = new Scope("Object"); c.addScope(s2);
		
	
		File folder = new File("objecten");
		File[] listOfFiles = folder.listFiles();
		

	    for (int i = 0; i < listOfFiles.length; i++) {
	    	String ext = listOfFiles[i].getName().substring(listOfFiles[i].getName().lastIndexOf('.'));
	      if (listOfFiles[i].isFile() && ext.equals("obj")) {
	        try(
	  	  	      InputStream file = new FileInputStream("objecten/"+listOfFiles[i].getName());
	  	  	      InputStream buffer = new BufferedInputStream(file);
	  	  	      ObjectInput input = new ObjectInputStream (buffer);
	  	  	    ){
	        		Pattern p = (Pattern)input.readObject();
	        		c.addPattern(p);
	  	  	    }
	  	  	    catch(Exception ex){
	  	  	    	ex.printStackTrace();
	  	  	    }
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
		
		new MainFrame(c);		
	}

}
