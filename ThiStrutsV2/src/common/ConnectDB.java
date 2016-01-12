package common;


import java.sql.*;
public class ConnectDB {
    public Connection con = null;
    public void Connect(){
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
            con=DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=QuanLyLapTop;","sa","12345678");
            System.out.println("Connected Database!!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e1){
            System.out.println(e1.getMessage());
        }
        }
    public void Disconnect() throws SQLException{
        if(con!=null){
            con.close();
            System.out.println("Connection has been closed");
        }
        
    }
}
