package Database;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection conn = DBConn.makeConnection();



        if (conn == null) {
            System.out.println("Fail");
        } else {
            System.out.println("Success");
        }



    }
}
