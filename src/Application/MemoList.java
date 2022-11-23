package Application;

import java.util.HashMap;
import java.util.List;

public class MemoList {

    private HashMap<Integer, Memo> memoList = new HashMap<>();

    public MemoList(){
        super();
    }

    public void setMemoList(int write_num, Memo memo){
        memoList.put(write_num, memo);
    }

    public HashMap<Integer, Memo> getAllMemoList(){
        return memoList;
    }
}
