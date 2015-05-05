package adressbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressList {
	String mSQL;
	private String suchtext;
	private String[] spalten = {"name","christianname","email","phone","mobile","street","city","country","birthday"};
	public ArrayList<Adress> liste = new ArrayList<Adress>();
	
	public AdressList(){
		
	}

	public void setSuchtext(String suchtext) {
		this.suchtext = suchtext;
	}
	
	
	public List<Adress> getListe() throws SQLException {
		List<Adress> liste = new ArrayList<Adress>();
		
		mSQL="Select * From address";
		if (suchtext!=null){
			mSQL=mSQL+where();
		}
		System.out.println(mSQL);
		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		ResultSet rsA;
		rsA = verbindung.lesen(mSQL);
		while (rsA.next()) { 
			System.out.println(rsA.getString("addressform")+" "+rsA.getString("christianname")+" "+rsA.getString("name")+" aus "+rsA.getString("city"));
			Adress adress=new Adress();
			int id = rsA.getInt("id");
			adress.read(id);
			liste.add(adress);
			System.out.println(liste.get(0).christianname);
			}
		
		return liste;
	}


	public String where(){
		String where=" where ";
		
		for(int i=0; i<spalten.length;i++ ){
			String column=spalten[i];
			where=where+column+" like "+"'"+this.suchtext+"'";
		
		if(i<spalten.length-1){
			where=where+" Or ";
			}
		
		
		}
		System.out.println(where);
		return where;
	}
	
	public void delete(int id){
		mSQL="Delete from address where id="+id;
		System.out.println(mSQL);
		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		ResultSet rsA;
		verbindung.schreibe(mSQL);
	}
	
}
