package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCode {
    public static void main(String[] args) {  //db에 값 들어가는건 확인함

        Connection con = DBConn.makeConnection();

        PreparedStatement pstmt = null; // SQL 문을 미리 입력하고 변수를 입력하는 방식

        ResultSet rs = null; // 조회한 결과 값에 순차적으로 접근할수 있음

        DBConn.makeConnection();

        Scanner sc = new Scanner(System.in);

        int result = 0;
        String sql = "INSERT INTO member VALUES(?,?,?,?,?)";

        try {
            pstmt = con.prepareStatement(sql);
            String id1 = sc.next();
            pstmt.setString(1, id1);

            String pw1 = sc.next();
            pstmt.setString(2, pw1);

            String name1 = sc.next();
            pstmt.setString(3, name1);

            String studentId = sc.next();
            pstmt.setString(4, studentId);

            String email = sc.next();
            pstmt.setString(5, email);


            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("회원가입이 완료되었습니다.");
        } else if (result == 0) {
            System.out.println("회원가입에 실패하였습니다.");
        }
    }

    }

