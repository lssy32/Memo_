package Application;

import java.util.ArrayList;
import java.util.List;

public class MemoList {

    private List<Memo> memoList = new ArrayList<Memo>();

    public void addMemoList(Memo memo){
        memoList.add(memo);
    }
    public List<Memo> getMemoList() {
        return memoList;
    }

}
