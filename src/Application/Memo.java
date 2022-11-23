package Application;

import java.time.LocalDateTime;

public class Memo {

    private int num;      //글번호
    private String user_name;   //작성자 이름
    private String user_pw;     //작성자 패스워드
    private String memo;        //메모내용
    private String memo_date;     //메모날짜

    public Memo(int write_num, String name, String pw, String write_memo, String write_date) {
        this.num = write_num;
        this.user_name = name;
        this.user_pw = pw;
        this.memo = write_memo;
        this.memo_date = write_date;
    }

    public int getNum() {
        return num;
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

    public String getMemo_date() {

        return memo_date;
    }
}
