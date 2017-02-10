package com.example.dhaval.webserviceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dhaval.webserviceexample.Database.DBHelper;
import com.example.dhaval.webserviceexample.Utility.CommonUtility;
import com.example.dhaval.webserviceexample.Utility.DBConstant;
import com.example.dhaval.webserviceexample.pojo.UserInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

     String[] userName=new String[]{"Nandish","Rehan","Mahira"};
     String[] dob=new String[]{"02/01/1993","01/05/2008","09/06/2015"};

      List<UserInfo> userInfoList;
    RecyclerView recyclerView;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper= CommonUtility.getDBObject(this);
        int count= dbHelper.getFullCount(DBConstant.TABLE_NAME, null);
        if(count==0) {
            insertBookRecord();
        }
        setList();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter=new CustomAdapter(userInfoList);
        recyclerView.setAdapter(customAdapter);
    }

    public void setList()
    {

       userInfoList=dbHelper.getAllUser();
    }
}
