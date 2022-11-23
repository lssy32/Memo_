package Data;

import Application.Memo;
import Application.MemoList;

public class MemoAdd {

    public MemoAdd(int write_num, Memo memo){
        MemoList m_list = new MemoList();
        m_list.setMemoList(write_num, memo);
    }
}
