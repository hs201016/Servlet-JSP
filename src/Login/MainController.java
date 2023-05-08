package Login;

import Database.DBConn;
import Database.MemberDAO;
import Database.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet("*.do") // 모든 .do에 대한 서블릿
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L; // 객체의 직렬화

    private void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String requestURI = request.getRequestURI(); // URI 는 URl과 URN으로 나뉨
        String contextPath = request.getContextPath(); // 주소 길이
        String command = requestURI.substring(contextPath.length()); // 엑기스들을 뽑기 위함


        Action action = null; // 요청을 처리하는 메소드
        ActionForward forward = null; // 다음 페이지의 경로를 처리하는 메소드

        // 회원가입 폼
        if (command.equals("/MemberJoinForm.do")) { // do~~ 라는건 알겠는데 좀 더 자세히
            forward = new ActionForward(); // 초기화
            forward.setRedirect(true); //완료한 후 새로운페이지로 이동시키기 위해 False 시 페이지 내에서 수행한다??
            forward.setPath("./Member/MemberJoinForm.jsp"); // 서버 -> 클라이언트로 요청을 전달할떄
            // 해당경로에 있는 jsp 페이지를 받아 브라우저에 출력

        }

        // 이건 회원가입 Impl
        else if (command.equals("/MemberJoin.do")) {
            try {  // 서블릿의 exception 때문에 try 사용
                action = new MemberJoin(); // 실질적인 요청!!
                forward = action.execute(request, response); // Forward는 경로!!
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 페이지 이동
        if (forward != null) { // 경로가 비어져 있지 않도록
            if (forward.isRedirect()) {

                try {
                    response.sendRedirect(forward.getPath()); // 사용자 url 에 뜨는 것
                } catch (IOException e) { // 입출력 예외에 관한 예외처리
                    throw new RuntimeException(e);
                }
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward.getPath()); // 서버내 사용자가 몰라도 됨
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get");
        request.getRequestDispatcher("/Member/MemberJoinForm.jsp").forward(request, response); // form 보여주기 위해서 사용
        doProcess(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("Post");
            doProcess(request, response);


        }
    }


