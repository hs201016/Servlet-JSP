package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사실 왜 Interface 로 했는지 잘 모르곘음

public interface Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}


