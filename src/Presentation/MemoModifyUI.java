package Presentation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MemoModifyUI implements UI{

    List<String> list = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list3 = new ArrayList<String>();

    HashMap<String,Object> map = new HashMap<String,Object>();

    //임의의 해쉬맵 작성

    public void example(){
        list.add("name");
        list.add("password");
        list.add("text");

        list2.add("name");
        list2.add("password");
        list2.add("text");

        list3.add("name");
        list3.add("password");
        list3.add("text");


        map.put("1",list);
        map.put("2",list2);
        map.put("3",list3);

    }

    public void showExample(){
        for(String i :map.keySet()) {
            System.out.println(i + " : " + map.get(i));
        }
    }





    //첫 화면 UI
    @Override
    public void memoUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===================(1) 메모 목록 조회 =====================");
        System.out.println("=================(2) 수정 할 글번호 입력 ===================");
        System.out.println("==============(3) 수정 할 글 비밀번호 입력 ==================");
        System.out.println("============== 메뉴의 숫자를 입력하세요. ==================");
        String str1 = sc.next();

        switch (str1){
            case "1":
                System.out.println("메뉴목록을 조회합니다.");
                showExample();

        }




    }

    //글 번호 입력



}
