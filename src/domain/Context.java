package domain;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Context {
	private ArrayList<Purpose> purposes;
	private ArrayList<Scope> scopes;
	private ArrayList<Pattern> patterns;

	public Context() {
		purposes = new ArrayList<Purpose>();
		scopes = new ArrayList<Scope>();
		patterns = new ArrayList<Pattern>();
	}
	
	public void addPurpose(Purpose p) {
		purposes.add(p);
	}
	
	public String[] getPurposesString() {
		String[] array = new String[purposes.size()];
		int counter = 0;
		for(Purpose p : purposes) {
			array[counter] = p.getName();
			counter++;
		}
		return array;
	}
	
	public ArrayList<Purpose> getPurposes() {
		return purposes;
	}
	
	public Purpose searchPurpose(String s) {
		Purpose p = null;
		for(Purpose pu : purposes) {
			if(pu.getName().equals(s)) {
				p = pu;
			}
		}
		return p;
	}
	
	public void addScope(Scope s) {
		scopes.add(s);
	}
	
	public String[] getScopesString() {
		String[] array = new String[scopes.size()];
		int counter = 0;
		for(Scope s : scopes) {
			array[counter] = s.getName();
			counter++;
		}
		return array;
	}
	
	public ArrayList<Scope> getScopes() {
		return scopes;
	}
	
	public Scope searchScope(String s) {
		Scope sc = null;
		for(Scope scp : scopes) {
			if(scp.getName().equals(s)) {
				sc = scp;
			}
		}
		return sc;
	}
	
	public void addPattern(Pattern p) {
		patterns.add(p);
	}
	
	public String[] getPatternsString() {
		String[] array = new String[patterns.size()];
		int counter = 0;
		for(Pattern p : patterns) {
			array[counter] = p.getName();
			counter++;
		}
		return array;
	}
	
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}
	
	public void parseToPattern(String path,String file,String ext) {
		if(ext.equals(".txt")) {			
			try {
				FileReader fr = new FileReader(path); 
				BufferedReader br = new BufferedReader(fr); 
				ArrayList<String> strings = new ArrayList<String>();
				String s; 
				while((s = br.readLine()) != null) { 
					strings.add(s);
				} 
				fr.close(); 
				Purpose pur = searchPurpose(strings.get(6));
				Scope scp = searchScope(strings.get(7));
				Pattern p = new Pattern(strings.get(0),strings.get(1),strings.get(2),strings.get(3),strings.get(4),strings.get(5),pur,scp);
				patterns.add(p);
				writeObject(p);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ext.equals(".xml")) {
			
		}
		else {
			
		}
	}
	
	private void writeObject(Pattern p) {
		try{
		 
		FileOutputStream fos = new FileOutputStream("objecten/"+p.getName()+".obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);   
		oos.writeObject(p);
		oos.close();
 
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
	}
}
