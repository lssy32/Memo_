package Presentation;

import Application.MemoList;

import java.util.Scanner;

public class MainUI implements UI {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void memoUI() {

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
                case "1": new MemoAddUI().memoUI();
                    break;
                case "2": //new MemoAllListUI().memoUI();
                    System.out.println();
                    break;
                case "3":
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

}