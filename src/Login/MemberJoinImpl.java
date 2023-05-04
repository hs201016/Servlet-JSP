package Login;

import Database.MemberDAO;
import Database.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MemberJoinImpl implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("MemberJoin");

        response.setContentType("text/html;charset=utf-8"); // out 객체에서 사용할 타입에 대한 설정

        PrintWriter out = response.getWriter(); // out 객체 생성하기

        request.setCharacterEncoding("utf-8"); // Post 방식으로 넘어오는 데어터의 인코딩 타입 설정

        String id = request.getParameter("id"); // 폼<Form> 에서 넘어온 id 값 저장

        MemberDAO manager = MemberDAO.getInstance();

        if (result != 0) { // 동일한 아이디가 있나 체크하기 저쪽에서 result로 넘겨줄거임
            out.close();
        } else { // 동일한 아이디가 없으면 dto객체에 값을 저장하여 dao로 전달해주기

            MemberDTO member = new MemberDTO(); // 여기 해결해야함



            member.setId(id); // 여기는 왜 parameter 안 쓰는지 체크하기
            member.setPassword(request.getParameter("password")); // form 형식으로 작성한것을 가져오려고
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            member.setStudentId(request.getParameter("studentId"));
        }

        // 포워딩 설정하기

        ActionForward forward = new ActionForward();
        forward.setRedirect(true); // 서블릿에서 HTTP 요청을 처리한 후, 다른 페이지로 리다이렉트할 때 사용하는 코드
        forward.setPath("./LoginForm.do"); // LoginForm 으로 경로설정하기
        return forward;
    }
}
