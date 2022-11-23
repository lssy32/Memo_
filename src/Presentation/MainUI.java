package Presentation;

import Application.Memo;
import Data.MemoController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainUI{

    private Scanner sc = new Scanner(System.in);

    private MemoController mc = new MemoController();

    public void MainUI() {

        boolean run = true;

        while(run) {

            System.out.println("=============================");
            System.out.println("===========5조 MeMo==========");
            System.out.println("=========1. 메모입력==========");
            System.out.println("=========2. 목록보기==========");
            System.out.println("=========3. 메모수정==========");
            System.out.println("=========4. 메모삭제==========");
            System.out.println("========5. 시스템종료==========");
            System.out.println("=============================");

            System.out.print(">>>원하는 메뉴를 선택해주세요 : ");
            String num = sc.nextLine();

            switch (num) {
                case "1": MemoWrite();
                    break;
                case "2":
                    MemoAllList();
                    break;
                case "3":
                    MemoModify();
                    break;
                case "4":
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다 다시입력해주세요.");
                    System.out.println();
                    run = true;
            }
        }
    }

    int write_num = 1;    //글 번호 초기화

    public void MemoWrite() {

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
            LocalDateTime write_date = LocalDateTime.now();
            String date = write_date.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분"));

            //입력받은 data값 Memo틀에 맞놓기
            Memo memo = new Memo(write_num, name, pw, write_memo, date);

            //글번호 생성
            mc.addMemo(memo);
            write_num += 1;

            System.out.println(">메모 저장이 완료되었습니다.");
            System.out.println();
            MainUI();
        } else {
            MainUI();
        }
    }
    public void MemoAllList() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("=======5조 MeMo AllList=======");

        List<Memo> m_list = mc.getMemo();

        for(int i=0; i<m_list.size(); i++){
            System.out.println(
                    ">글번호 : " + m_list.get(i).getNum() +
                    ", 작성자 : " + m_list.get(i).getUser_name() +
                    ", 메모내용 : " + m_list.get(i).getMemo() +
                    ", 작성일 : " + m_list.get(i).getMemo_date()
            );
        }

        System.out.println("=============================");
    }
    public void MemoModify(){


    }

    public void MemoDelete(){
        
    }
}