package Database;

public class MemberDTO {
    // DTO는 Data Transfer Object의 약어로, 데이터 전송 객체를 의미합니다.
    String id;
    String password;
    String name;
    String email;
    String StudentId;

    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return StudentId;
    }


    public void setStudentId(String studentId) {
        StudentId = studentId;
    }





}
