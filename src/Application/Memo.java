package Application;

import java.time.LocalDateTime;

public class Memo implements Comparable<Memo>{

    private int num;
    private String user_name;
    private String user_pw;
    private String memo;
    private String memo_date;

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

    public void setMemo_date(String memo_date) {
        this.memo_date = memo_date;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public int compareTo(Memo memo) {
        if (memo.num < num) {
            return 1;
        } else if (memo.num > num) {
            return -1;
        }
        return 0;
    }
}
