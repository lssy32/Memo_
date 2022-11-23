package Data;

import Application.Memo;
import Application.MemoList;

import java.util.List;

public class MemoController {

    private MemoList m_list = new MemoList();

    public void addMemo(Memo memo) {
        m_list.addMemoList(memo);
    }
    public List<Memo> getMemo(){
        return m_list.getMemoList();
    }
    public void modifyMemo(int num, Memo memo){
        m_list.setMemoList(num, memo);
    }

    public Memo selectMemoNum(int num){
        return m_list.getMemoNum(num);
    }

    public void removeMemo(int num){
        m_list.removeMemoList(num);
    }
}
