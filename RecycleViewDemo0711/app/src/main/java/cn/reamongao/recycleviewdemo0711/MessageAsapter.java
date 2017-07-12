package cn.reamongao.recycleviewdemo0711;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class MessageAsapter extends RecyclerView.Adapter<MessqgeHolder> implements AdapterCallback{

    private List<MessageBean> dataList;
    private Context context;


    MessageAsapter(Context context, List<MessageBean> dataList){
        this.dataList = dataList;
        this.context = context;
    }

    //两个callback方法
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(dataList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return false;
    }

    @Override
    public boolean onItemSwiped(int adapterPosition) {
        dataList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        return false;
    }


    //  Recyclerview Adapter 实现方法
    @Override
    public MessqgeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_message,parent,false);
        MessqgeHolder viewHolder = new MessqgeHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessqgeHolder holder, final int position) {
        final MessageBean messageBean = dataList.get(position);
        holder.tvTitle.setText(messageBean.getTitle());
        holder.tvContent.setText(messageBean.getContent());
        holder.ivIcon.setImageResource(messageBean.getPicId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.format(Locale.getDefault(),"点击了第 %d 个,标题为 %s",position,messageBean.getTitle()),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
