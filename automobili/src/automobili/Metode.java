package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Metode {
	
	
	private Connection konektujSe(String baza) throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/"+baza;
		final String user="root";
		final String password="root";
		
		
		return DriverManager.getConnection(url, user, password);
		
		
		
	}
	
	public void ubaciMarku(String nazivMarke,String zemlja) {
		
		Connection konekcija=null;
		PreparedStatement pst=null;
		
		try {
			konekcija=konektujSe("automobili");
			String query ="insert into marke values(null,?,?)";
			pst=konekcija.prepareStatement(query);
			pst.setString(1, nazivMarke);
			pst.setString(2, zemlja);
			pst.execute();
			System.out.println("Uspesan unos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Neuspesan unos");
		}finally {
			
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
