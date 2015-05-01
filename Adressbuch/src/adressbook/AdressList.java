package adressbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressList {
	String mSQL;
	public String suchtext;
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
			
			/*adr1.setId(rsA.getInt("id"));
			adr1.setName(rsA.getString("name"));
			adr1.setChristianname(rsA.getString("christianname"));
			adr1.setEmail(rsA.getString("email"));
			adr1.setAddressform(rsA.getString("addressform"));
			adr1.setPhone(rsA.getString("phone"));
			adr1.setMobile(rsA.getString("mobile"));
			adr1.setNumber(rsA.getInt("number"));
			adr1.setStreet(rsA.getString("street"));
			adr1.setCity(rsA.getString("city"));
			adr1.setPostcode(rsA.getString("postcode"));
			adr1.setCountry(rsA.getString("country"));
			adr1.setBirthday(rsA.getString("birthday"));*/
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
	
}
