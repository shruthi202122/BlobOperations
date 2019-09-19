import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoringImgIntoDb {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shruthidb","shruthi","abc@2");
		PreparedStatement preparedstatement=connection.prepareStatement("insert into employee1 values(?,?)");
		preparedstatement.setInt(1,111);
		FileInputStream fis=new FileInputStream("D:/rose.jpg");
		preparedstatement.setBlob(2,fis);
		preparedstatement.executeUpdate();
		System.out.println("Record inserted");
		fis.close();
		connection.close();
	}

}
