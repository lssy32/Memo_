package Application;

import java.time.LocalDate;

public class Memo {

    private String user_name;   //작성자 이름
    private String user_pw;     //작성자 패스워드
    private String memo;        //메모내용
    private LocalDate memo_date;     //메모날짜

    public Memo(String name, String pw, String write_memo, LocalDate write_date){
        this.user_name = name;
        this.user_pw = pw;
        this.memo = write_memo;
        this.memo_date = write_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public String getMemo() {
        return memo;
    }

    public LocalDate getMemo_date() {
        return memo_date;
    }
}
