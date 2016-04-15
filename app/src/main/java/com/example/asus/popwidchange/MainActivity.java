package com.example.asus.popwidchange;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.asus.popwidchange.adapter.MyImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        private Button mButton;
    private PopupWindow mPopupWindow;
    private List<Integer> mList;
    private RecyclerView mRecycleView;
    private MyImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView=(RecyclerView) findViewById(R.id.activity_chooser_view_content);
        mButton=(Button)findViewById(R.id.but);
        mButton.setOnClickListener(this);
        mList=new ArrayList<>();
        mList.add(R.mipmap.zhaoxin);
        mList.add(R.mipmap.caocao);
        mList.add(R.mipmap.dahan);
        mList.add(R.mipmap.liubei);
        mList.add(R.mipmap.dahan);
        mList.add(R.mipmap.zhangfei);
        mList.add(R.mipmap.guanyu);
        mList.add(R.mipmap.zhangfei);
        mList.add(R.mipmap.zhaoxin);
        adapter=new MyImageAdapter(this,mList);
       LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecycleView.setLayoutManager(manager);
        mRecycleView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        RecyclerView.LayoutManager manager;
        switch (v.getId()){
            case R.id.but:
                setPop();
                break;
            case R.id.text1:

                 manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
                mRecycleView.setLayoutManager(manager);
                mRecycleView.setAdapter(adapter);
                mPopupWindow.dismiss();
                break;
            case R.id.text2:

                 manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                mRecycleView.setLayoutManager(manager);
                mRecycleView.setAdapter(adapter);
                mPopupWindow.dismiss();
                break;
            case R.id.text3:
                manager=new GridLayoutManager(this,2);
                mRecycleView.setLayoutManager(manager);
                mRecycleView.setAdapter(adapter);
                mPopupWindow.dismiss();
                break;
            case R.id.text4:

                manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                mRecycleView.setLayoutManager(manager);
                mRecycleView.setAdapter(adapter);
                mPopupWindow.dismiss();
                break;
        }
    }
    private void setPop(){
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.popwidow_layout,null);
        mPopupWindow=new PopupWindow();
        mPopupWindow.setContentView(view);
        mPopupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView textView1= (TextView) view.findViewById(R.id.text1);
        TextView textView2= (TextView) view.findViewById(R.id.text2);
        TextView textView3= (TextView) view.findViewById(R.id.text3);
        TextView textView4= (TextView) view.findViewById(R.id.text4);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
//        View rootView=LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
//        mPopupWindow.showAtLocation(rootView,Gravity.BOTTOM,0,0);
        mPopupWindow.showAsDropDown(mButton);
    }


}
