import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;


public class ReadingImgFromDb {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shruthidb","shruthi","abc@2");
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("select * from employee1 where eno=111");
		FileOutputStream fos= new FileOutputStream("D:/myrose.jpg");
		if(rs.next()) {
			fos.write(rs.getBytes(2));
			
		}
		System.out.println("reading the image ");
		fos.close();
		connection.close();
	}

}
