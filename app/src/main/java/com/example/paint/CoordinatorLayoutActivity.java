package com.example.paint;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends AppCompatActivity {
    private List<String> list;
    private MyAdapter myAdapter;
    private RecyclerView mRv;
    private RecyclerView mRecyclerView;
    private CircleView mMmview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        initView();

    }

    private void initView() {

        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item" + i);
        }
        mRv = (RecyclerView) findViewById(R.id.recyclerView);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list, this);
        mRv.setAdapter(myAdapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mMmview = (CircleView) findViewById(R.id.mmview);
        mMmview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    class MyAdapter extends RecyclerView.Adapter {

        private List<String> list;
        private Context context;

        public MyAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.adapter_layout, null);
            return new Hoo(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Hoo hoo = (Hoo) holder;
            hoo.name.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Hoo extends RecyclerView.ViewHolder {
            TextView name;

            public Hoo(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.txt_info);
            }
        }
    }
}
