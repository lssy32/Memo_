package Presentation;

import Application.Memo;
import Data.MemoAdd;

import java.time.LocalDate;
import java.util.Scanner;

public class MemoAddUI implements UI {

    private Scanner sc = new Scanner(System.in);

    int write_num = 1;    //글 번호 초기화

    @Override
    public void memoUI() {

        System.out.println();
        System.out.println("=============================");
        System.out.println("===========5조 MeMo==========");
        System.out.print(">작성자 이름을 입력해주세요 :");
        String name = sc.nextLine();

        System.out.print(">글 비밀번호를 입력해주세요 :");
        String pw = sc.nextLine();

        System.out.print(">남기실 메모를 입력해주세요 :");
        String write_memo = sc.nextLine();

        System.out.println("=============================");

        System.out.print(">메모를 저장하시겠습니까?(y/n) : ");
        String answer = sc.nextLine();

        if (answer.equals("y")) {

            //글 작성 날짜 생성
            LocalDate write_date = LocalDate.now();

            //입력받은 data값 Memo틀에 맞놓기
            Memo memo = new Memo(name, pw, write_memo, write_date);

            //글번호 생성
            MemoAdd memoAdd = new MemoAdd(write_num, memo);
            write_num += 1;

            System.out.println(">메모 저장이 완료되었습니다.");
            System.out.println();
            new MainUI().memoUI();
        } else {
            new MainUI().memoUI();
        }
    }

}
