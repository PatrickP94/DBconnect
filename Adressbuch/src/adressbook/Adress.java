package adressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Adress {
	String mSQL;
	public boolean fehler=false;
	public void setFehler(boolean fehler) {
		this.fehler = fehler;
	}

	public int id;
	public String name;
	public String christianname;
	public String email;
	public String addressform;
	public String phone;
	public String mobile;
	public String street;
	public int number;
	public String city;
	public String postcode;
	public String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChristianname() {
		return christianname;
	}
	public void setChristianname(String christianname) {
		this.christianname = christianname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressform() {
		return addressform;
	}
	public void setAddressform(String addressform) {
		this.addressform = addressform;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	

	public Adress(){
		
	}
	
	public void read(int id) throws SQLException {
		
		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		mSQL="select * from address where id="+id;
		ResultSet rsA;
		rsA = verbindung.lesen(mSQL);
		while (rsA.next()) { 
			System.out.println(rsA.getString("addressform")+" "+rsA.getString("christianname")+" "+rsA.getString("name")+" aus "+rsA.getString("city"));
			
			this.setId(rsA.getInt("id"));
			this.setName(rsA.getString("name"));
			this.setChristianname(rsA.getString("christianname"));
			this.setEmail(rsA.getString("email"));
			this.setAddressform(rsA.getString("addressform"));
			this.setPhone(rsA.getString("phone"));
			this.setMobile(rsA.getString("mobile"));
			this.setNumber(rsA.getInt("number"));
			this.setStreet(rsA.getString("street"));
			this.setCity(rsA.getString("city"));
			this.setPostcode(rsA.getString("postcode"));
			this.setCountry(rsA.getString("country"));
			this.setBirthday(rsA.getString("birthday"));
			}
		
		rsA.close();
		//verbindung.schliesseDB();
		System.out.print (this.getChristianname()+" "+this.getName()+" "+this.getBirthday()+" ");
		
		
	}
	
	public void save() throws SQLException{
		int pruefid=this.getId();
		int i=0;
		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		mSQL="select * from address where id="+pruefid;
		ResultSet rsA;
		rsA = verbindung.lesen(mSQL);
		while (rsA.next()){
			i++;
		}
		if (i==0 ||pruefid==0){
			String birthday = this.getBirthday();
			birthday=birthday.replaceAll("-", "");
			this.setBirthday(birthday);
			System.out.println("Hier: "+this.getBirthday());
			mSQL="insert into address(Name, Christianname, Email, Addressform, Phone, "
					+ "Mobile, Street, Number, City, Postcode, Country, Birthday) values ('"+this.getName()+"','"
					+this.getChristianname()+"','"+this.getEmail()+"','"+
			this.getAddressform()+"','"+
			this.getPhone()+"','"+
			this.getMobile()+"','"+
			this.getStreet()+"',"+
			this.getNumber()+",'"+
			this.getCity()+"',"+
			this.getPostcode()+",'"+
			this.getCountry()+"',"+
			this.getBirthday()+")";
			System.out.println(mSQL);
			try {
				verbindung.schreibe(mSQL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fehler=true;
			}
			System.out.println("fertig");
		}
		else{
			String birthday = this.getBirthday();
			birthday=birthday.replaceAll("-", "");
			this.setBirthday(birthday);
			System.out.println("Hier: "+this.getBirthday());
			mSQL="update address set id="+this.getId()+",name='"+this.getName()+"',christianname='"
					+this.getChristianname()+"',email='"+this.getEmail()+"',addressform='"+
			this.getAddressform()+"',phone='"+
			this.getPhone()+"',mobile='"+
			this.getMobile()+"',street='"+
			this.getStreet()+"',number="+
			this.getNumber()+",city='"+
			this.getCity()+"',postcode="+
			this.getPostcode()+",country='"+
			this.getCountry()+"',birthday="+
			this.getBirthday()+
			" Where id="+this.getId();
			System.out.println(mSQL);
			try {
				verbindung.schreibe(mSQL);
			} catch (Exception e) {
				fehler=true;
				e.printStackTrace();
			}
			System.out.println("fertig");
		}
		
		
		
	}
	
}
