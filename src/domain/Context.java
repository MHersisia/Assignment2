package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	
	public void removePattern(Pattern p) {
		patterns.remove(p);
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
	
	public boolean parseToPattern(String path,String file,String ext) {
		boolean b = true;
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
				if(strings.get(0).isEmpty() || strings.get(1).isEmpty() || strings.get(2).isEmpty() || strings.get(3).isEmpty() || strings.get(4).isEmpty() || strings.get(5).isEmpty() || pur==null || scp==null) {
					throw new Exception();
				}
				Pattern p = new Pattern(strings.get(0),strings.get(1),strings.get(2),strings.get(3),strings.get(4),strings.get(5),pur,scp);
				patterns.add(p);
				writeObject(p);
			}
			catch(Exception e) {
				b = false;
			}
			
		}
		else if(ext.equals(".xml")) {
			try {
				File fXmlFile = new File(path);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);			 
			
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("pattern");
				for (int temp = 0; temp < nList.getLength(); temp++) {					 
					Node nNode = nList.item(temp); 			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {			 
						Element eElement = (Element) nNode;						
						Purpose pur = searchPurpose(eElement.getElementsByTagName("purpose").item(0).getTextContent());
						Scope scp = searchScope(eElement.getElementsByTagName("scope").item(0).getTextContent());
						if(pur==null || scp==null) {
							throw new Exception();
						}
						Pattern p = new Pattern(eElement.getElementsByTagName("name").item(0).getTextContent(),eElement.getElementsByTagName("context").item(0).getTextContent(),eElement.getElementsByTagName("problem").item(0).getTextContent(),eElement.getElementsByTagName("solution").item(0).getTextContent(),eElement.getElementsByTagName("diagram").item(0).getTextContent(),eElement.getElementsByTagName("consequences").item(0).getTextContent(),pur,scp);
						patterns.add(p);
						writeObject(p);
					}
				}
			}
			catch(Exception e) {
				b = false;
			}
		}
		return b;
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
