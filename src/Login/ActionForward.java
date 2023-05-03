package Login;

public class ActionForward {
    private boolean redirect; // HTTP 요청에서 리다이렉션 여부를 나타내는 데 사용됨.
    private String path; // 경로를 지정하기 위해 만듬

    public boolean  isRedirect() { // 리다이렉션의 체크?
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
