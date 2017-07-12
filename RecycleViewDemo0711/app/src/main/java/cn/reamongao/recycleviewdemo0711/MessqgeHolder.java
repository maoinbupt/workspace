package cn.reamongao.recycleviewdemo0711;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class MessqgeHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvContent;
        public ImageView ivIcon;

        public MessqgeHolder(View itemView) {
            super(itemView);
            initView();
        }

    private void initView() {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
    }
}
