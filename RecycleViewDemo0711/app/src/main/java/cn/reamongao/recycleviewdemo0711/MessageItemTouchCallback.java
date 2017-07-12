package cn.reamongao.recycleviewdemo0711;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class MessageItemTouchCallback extends ItemTouchHelper.Callback {

    AdapterCallback callback;

    MessageItemTouchCallback(AdapterCallback callback){
        this.callback = callback;
    }



    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 移动标识 上下 左右

        // 支持上下拖拽
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        // 支持左右侧滑
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // adapter.move 耦合的实现方式不太好，使用接口
        callback.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        callback.onItemSwiped(viewHolder.getAdapterPosition());
    }
}
