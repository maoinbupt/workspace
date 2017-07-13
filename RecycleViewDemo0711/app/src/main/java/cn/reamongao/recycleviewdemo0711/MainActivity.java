package cn.reamongao.recycleviewdemo0711;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;
    private MessageItemTouchCallback callback;
    private MessageAsapter adapter;
    private List<MessageBean> itemList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = DataUtils.createDataList();
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        adapter = new MessageAsapter(MainActivity.this ,itemList);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        callback = new MessageItemTouchCallback(adapter);
        // 手势Helper
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }
}
