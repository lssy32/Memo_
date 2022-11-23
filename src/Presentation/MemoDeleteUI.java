package Presentation;

import Application.MemoList;

import java.util.Scanner;

public class MemoDeleteUI implements UI{
    private Scanner sc = new Scanner(System.in);
    @Override
    public void memoUI() {
        System.out.println("============메모 목록 조회================="); // 메모리스트를 먼저 보여줍니다.

        MemoLIst memoLIst = new MemoList(); // 메모리스트가 나오도록 합니다.
        System.out.println(memoLIst);

        System.out.println("============입력(1번) 글번호 입력===========");
        System.out.println("============입력(2번) 뒤로가기==============");
        String num = sc.nextLine();

        switch (num) {
            case "1": // 삭제할 글번호를 입력합니다.
                String write_num = sc.nextLine();
                // 글번호를 입력
                if (memoLIst.containsKey(write_num)) {
                    System.out.println("============비밀번호 입력==================");
                    String pw = sc.nextLine();
                    // 비밀번호가 일치하면 해시맵에서 해당 키를 제거
                    if (getKey(memoLIst, write_num) = pw) {
                        memoLIst.remove(write_num);
                    }
                    // 비밀번호가 일치하지 않는 경우
                    else {
                        System.out.println("============비밀번호가 일치하지 않습니다.=====");
                    }
                }
                // 글번호가 일치하지 않는 경우
                else {
                    System.out.println("============글번호가 일치하지 않습니다.=======");
                }
                break;

            case "2":
                new MainUI().memoUI(); // 처음 메뉴로 돌아갑니다.
                break;
        }
    }
}