package adressbook;

import java.sql.SQLException;

public class AdressListTest {

	public static void main(String[] args) throws SQLException {

		AdressList adresslist = new AdressList();
		
		//adresslist.setSuchtext("Prei�");
		adresslist.getListe();
		adresslist.delete(999);
	}

}
