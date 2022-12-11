package EJBtest;

import java.sql.*;
public class AccessTest {
    AccessTest() {
        Connection conn;
        ResultSet rs=null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Download/H2test","sa", "sa");
            Statement stmt=conn.createStatement();
            String sql="select * from Student";
            rs=stmt.executeQuery(sql);
            while (rs.next())
                System.out.println(rs.getInt(1)+" - Name is "+rs.getString(2)+" "+rs.getString(3));
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String a[]) {
        new AccessTest();
    }
}
