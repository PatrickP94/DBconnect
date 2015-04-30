package adressbook;

import java.sql.SQLException;

public class AdressTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Adress adress1 = new Adress();
		
		adress1.read(2);
		
	}

}
