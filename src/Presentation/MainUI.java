package Presentation;

import Application.Memo;
import Data.MemoController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainUI {

    private Scanner sc = new Scanner(System.in);

    private MemoController mc = new MemoController();

    private List<Memo> m_list = mc.getMemo();

    public void MainUI() {

        boolean run = true;

        while (run) {

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
                case "1":
                    MemoWrite();
                    break;
                case "2":
                    MemoAllList();
                    break;
                case "3":
                    MemoModify();
                    break;
                case "4":
                    MemoRemove();
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

        System.out.print(">글 비밀번호를 입력해주세요(4자리 숫자) :");
        String pw = sc.nextLine();

        String REGEX = "[0-9]+";
        boolean run = true;

        if (pw.matches(REGEX) && pw.length() > 4) {
            System.out.println("숫자로 이루어진 4자리 이하의 비밀번호를 입력해주세요.");

            while (run) {
                System.out.print(">글 비밀번호를 입력해주세요(4자리 숫자) :");
                pw = sc.nextLine();

                if (pw.matches(REGEX) && pw.length() > 4) {
                    run = true;
                } else {
                    System.out.print(">남기실 메모를 입력해주세요 :");
                    String write_memo = sc.nextLine();

                    System.out.println("=============================");

                    System.out.print(">메모를 저장하시겠습니까?(y/n) : ");
                    String answer = sc.nextLine();

                    if (answer.equals("y")) {

                        LocalDateTime write_date = LocalDateTime.now();
                        String date = write_date.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분"));

                        Memo memo = new Memo(write_num, name, pw, write_memo, date);

                        mc.addMemo(memo);
                        write_num += 1;

                        System.out.println(">메모 저장이 완료되었습니다.");
                        System.out.println();
                        MainUI();
                    } else if (answer.equals("n")) {
                        System.out.println(">메인으로 돌아갑니다.");
                        MainUI();
                    } else {
                        System.out.println(">잘못된 입력입니다.");
                        MainUI();
                    }
                }
            }
        } else {
            System.out.print(">남기실 메모를 입력해주세요 :");
            String write_memo = sc.nextLine();

            System.out.println("=============================");

            System.out.print(">메모를 저장하시겠습니까?(y/n) : ");
            String answer = sc.nextLine();

            if (answer.equals("y")) {

                LocalDateTime write_date = LocalDateTime.now();
                String date = write_date.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분"));

                Memo memo = new Memo(write_num, name, pw, write_memo, date);

                mc.addMemo(memo);
                write_num += 1;

                System.out.println(">메모 저장이 완료되었습니다.");
                System.out.println();
                MainUI();
            } else if (answer.equals("n")) {
                System.out.println(">메인으로 돌아갑니다.");
                MainUI();
            } else {
                System.out.println(">잘못된 입력입니다.");
                MainUI();
            }
        }
    }


    public void MemoAllList() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("=======5조 MeMo AllList=======");

        if (!m_list.isEmpty()) {

            Collections.sort(m_list, Collections.reverseOrder());

            for (int i = 0; i < m_list.size(); i++) {
                System.out.println(
                        ">글번호 : " + m_list.get(i).getNum() +
                                ", 작성자 : " + m_list.get(i).getUser_name() +
                                ", 메모내용 : " + m_list.get(i).getMemo() +
                                ", 작성일 : " + m_list.get(i).getMemo_date()
                );
            }
        } else {
            System.out.println("입력된 메모가 없습니다.");
        }

        System.out.println("=============================");
        System.out.println();
    }

    public void MemoModify() {

        System.out.println();
        System.out.println("=============================");
        System.out.println("=========5조 MeMo 수정========");
        System.out.print("> 수정할 메모 번호를 입력하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();


        Collections.sort(m_list);
        Memo m = mc.selectMemoNum(num);

        if (m.equals(null)) {
            System.out.println("수정할 글이 존재하지 않습니다.");
        } else {
            System.out.print("> 수정할 메모의 pw를 입력하세요 : ");
            String pw = sc.nextLine();

            if (pw.equals(m.getUser_pw())) {
                System.out.print("> 메모를 입력하세요 : ");
                String write_memo = sc.nextLine();

                m.setMemo(write_memo);
                LocalDateTime write_date = LocalDateTime.now();
                String date = write_date.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분"));

                m.setMemo_date(date);

                mc.modifyMemo(num, m);

                System.out.println("> 수정이 완료되었습니다");
                System.out.println("=============================");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public void MemoRemove() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("=========5조 MeMo 삭제========");
        System.out.print("> 삭제할 메모 번호를 입력하세요 : ");
        int num = sc.nextInt();
        sc.nextLine();

        Memo m = mc.selectMemoNum(num);

        if (m.equals(null)) {
            System.out.println("삭제할 글이 존재하지 않습니다.");
        } else {
            System.out.print("> 삭제할 메모의 pw를 입력하세요 : ");
            String pw = sc.nextLine();

            if (pw.equals(m.getUser_pw())) {
                System.out.print("> 진짜 삭제하시겠습니까? (y/n) : ");
                String answer = sc.nextLine();

                if (answer.equals("y")) {
                    //삭제
                    mc.removeMemo(num);
                    MemoAllList();
                } else {
                    MainUI();

                }
            } else {
                System.out.println(">비밀번호가 일치하지 않습니다.");
            }
        }
    }
}