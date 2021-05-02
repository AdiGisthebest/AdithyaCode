import java.sql.*;
class SqlConnection {
  public static void main(String[] args) {
    Connection con  = null;
    try {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String myUrl = "jdbc:mysql://34.94.102.168/KidApp";
        con = DriverManager.getConnection(myUrl,"root","AdithyaGiri");
        String query = "SELECT * FROM Persons";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()) {
          System.out.println(rs.getString("ParentEmailId"));
          System.out.println(rs.getString("RegisterStatus"));
        }
      }catch (Exception e) {
        e.printStackTrace();
      }finally {
        con.close();
    }
  } catch(Exception e){
      e.printStackTrace();
    }
  }
}
