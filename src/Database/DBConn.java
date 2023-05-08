package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn { // try catch 로 수정하기
    public static Connection makeConnection() {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/ServletDB";
        String userName = "root";
        String password = "369369a@";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // catch문 사용하려고 씀
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("DB연결 성공!");

        } catch (ClassNotFoundException e) { // try안에 오류가 발생할수 있는 코드가 있어야함
            System.out.println("DB 드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();

        }

        return con;
    }
}