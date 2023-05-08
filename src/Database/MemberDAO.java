package Database;

import Login.MemberJoin;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {


    // 싱글톤 사용
    private static MemberDAO instance = new MemberDAO();


    public static MemberDAO getInstance() { // 싱글톤 객체 생성
        return instance;
    }


    Connection con = null;

    PreparedStatement pstmt = null; // SQL 문을 미리 입력하고 변수를 입력하는 방식

    ResultSet rs = null; // 조회한 결과 값에 순차적으로 접근할수 있음



    public int IdCheck(String id) {


        int result = 0;
        try {
            String sql = "SELECT COUNT(*) FROM member WHERE id = ?"; //member에 id가 있는 지 확인
            pstmt = con.prepareStatement(sql); // sql 문 불러오기
            pstmt.setString(1, id);// 첫번 째 물음표에 id를 바운딩한다.
            rs = pstmt.executeQuery(); // pstmt를 이용하여 결과를 rs 변수에 할당하는 구문

            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("idCheck 에러 : " + e);
        } finally { // 메모리 누수를 막기 위해 닫아줘야함 안그러면 계속해서 쌓이게 됨
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    public void MemberJoin(MemberDTO member) {
        System.out.println("값 집어넣기 트라이 밑에 드라이버 다시 로딩  ");


        String sql = "INSERT INTO member VALUES(?,?,?,?,?)";

        try {
            pstmt = con.prepareStatement(sql); // execute에서 dto를 멤버로 바꿔서 set 했으니까 멤버로 get해야함!
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getStudentId());
            pstmt.executeUpdate(); // executeUpdate 메서드 사용

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally

        {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
