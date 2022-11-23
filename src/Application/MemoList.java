package Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoList {

    private List<Memo> memoList = new ArrayList<Memo>();

    public void addMemoList(Memo memo){
        memoList.add(memo);
    }
    public List<Memo> getMemoList() {

        return memoList;
    }

    public Memo getMemoNum(int num){

        for(int i=0; i<memoList.size(); i++){
            if(num == memoList.get(i).getNum()){
                return memoList.get(i);
            }
        }
        return null;
    }

    public void setMemoList(int num, Memo memo){
        memoList.set(num-1, memo);
    }

    public void removeMemoList(int num){

        for(int i=0; i<memoList.size(); i++){
            if(memoList.get(i).getNum()==num){
                Memo memo = memoList.get(i);
                memoList.remove(memo);
                return;
            }
        }
    }
}
