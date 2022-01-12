package com.example.headerandfooterrv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.headerandfooterrv.R;
import com.example.headerandfooterrv.adapter.MemberAdapter;
import com.example.headerandfooterrv.model.Member;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }


    private void refreshAdapter(ArrayList<Member> members){
        MemberAdapter adapter = new MemberAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<Member> prepareMemberList(){
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member()); // For Header
        for (int i = 1; i < 31; i++) {
            if (i == 4 || i == 10 || i == 13 || i == 16 || i == 19 || i == 22 || i == 25 || i == 29){
                members.add(new Member(i+")Selena", i+")Gomez", R.drawable.selena, false));
            }else {
                members.add(new Member(i+")Michael", i+")Jackson", R.drawable.michael, true));
            }
        }
        members.add(new Member()); // For Footer
        return members;
    }

}