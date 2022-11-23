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
        list.add("name1");

        list2.add("name2");

        list3.add("name3");


        map.put("1",list);
        map.put("2",list2);
        map.put("3",list3);

        for(String i :map.keySet()) {
            System.out.println(i + " : " + map.get(i));
        }

    }




    //첫 화면 UI
    @Override
    public void memoUI() {

        Scanner sc = new Scanner(System.in);
        MemoModifyUI re = new MemoModifyUI();
        System.out.println("===================(1) 메모 목록 조회 =====================");
        System.out.println("=================(2) 수정 할 글번호 입력 ===================");
        System.out.println("============== 메뉴의 숫자를 입력하세요. ==================");
        String str1 = sc.next();

        for(int i=0; i<5;i++){
            if(str1.equals("1")){
                System.out.println("메뉴목록을 조회합니다.");
                re.example();
            }
            if(str1.equals("2")){
                System.out.println("수정할 글 번호를 입력하세요.");
            }
        }



        switch (str1){
            case "1":
                System.out.println("메뉴목록을 조회합니다.");
                re.example();
                break;
            case "2":
                System.out.println("수정 할 글번호를 입력합니다.");
                break;
            case "3":
                System.out.println("수정할 글 번호를 입력합니다.");
                break;

        }







    }


    public static void main(String[] args){

        MemoModifyUI re = new MemoModifyUI();
        re.memoUI();

    }


    //글 번호 입력



}
