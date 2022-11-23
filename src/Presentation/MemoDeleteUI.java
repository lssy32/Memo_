package Presentation;

import Application.Memo;
import Application.MemoList;
import Data.MemoDelete;

import java.util.Scanner;

public class MemoDeleteUI implements UI{
    @Override
    public void memoUI() {

        Scanner sc = new Scanner(System.in);
        System.out.println("============입력(1번) 메모 목록 조회========");
        System.out.println("============입력(2번) 글번호 입력===========");
        System.out.println("============입력(3번) 메뉴화면==============");
        String num = sc.nextLine();

        MemoList memoList = new MemoList(); // Controller 합쳐지면 불러올 수 있겠죠?
        switch (num) {
            // 메모 목록 조회
            case "1":
                // 메모 목록을 보여준다.
                System.out.println(memoList);
                break;

            // 글번호 입력
            case "2":
                System.out.println("============글번호를 입력해주세요============");

                String idx = sc.nextLine();

                // 메모리스트 중에 해당되는 인덱스가 있는지 확인한다. 수정필요.
                if (memoList.containsKey(idx)) {
                    System.out.println("============비밀번호를 입력해주세요==========");

                    // 비밀번호를 입력
                    String pwd = sc.nextLine();

                    // 메모리스트 중에서 비밀번호를 가져와 비교
                    if (memoList.values()[idx][1].equals(pwd)) {
                        memoList.remove(index);        // 맞다면 해당 인덱스 삭제
                        System.out.println("삭제가 완료되었습니다.");
                    }
                    // 비밀번호가 맞지 않는 경우
                    else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                } else {
                    System.out.println("해당하는 글 번호가 없습니다.");
                }
                break;

            // 메뉴화면으로 돌아가기
            case "3":
                new MainUI().memoUI();
                break;
        }
    }
}