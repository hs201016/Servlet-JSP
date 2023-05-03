package Login;

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

        return forward;
    }
}
