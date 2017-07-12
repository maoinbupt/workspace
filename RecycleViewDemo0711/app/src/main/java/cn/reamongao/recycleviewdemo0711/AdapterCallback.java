package cn.reamongao.recycleviewdemo0711;

/**
 * Created by GaoFeng on 2017.07.11.
 *
 * 为了在TouchCallback不直接造作adapter，引入接口
 */

public interface AdapterCallback {


    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemSwiped(int adapterPosition);
}
