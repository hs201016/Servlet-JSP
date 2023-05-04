package Database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    // 싱글톤 사용
    private static MemberDAO instance = new MemberDAO();

    private MemberDAO() { // 이건 왜?
    }
    public static MemberDAO getInstance() { // 싱글톤 객체 생성
        return instance;
    }


    private HttpServletRequest request;

    HttpSession session = request.getSession();
    Connection con = null;

    PreparedStatement pstmt = null; // SQL 문을 미리 입력하고 변수를 입력하는 방식

    ResultSet rs = null; // 조회한 결과 값에 순차적으로 접근할수 있음

    public void JdbcConnection() {
        con = DBConn.makeConnection();
    }

    public int IdCheck(String id) {
        int result = 0;
        try {
            String sql = "SELECT * FROM user WHERE id = ?"; //user 아니면 ServletDB
            HttpSession session = request.getSession(); // 세션 연결 코드 추후 수정
            PreparedStatement statement = con.prepareStatement(sql); // sql 문 불러오기
            statement.setInt(1,1); // 첫번 째 물음표에 1을 바운딩한다.
            rs = statement.executeQuery(); //statement를 이용하여 결과를 rs 변수에 할당하는 구문

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void MemberJoin(MemberDTO member) {


    }

}
