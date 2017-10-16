package com.mycompany.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //把App Icon设置成可用的向上按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.content);
        relativeLayout.addView(textView);
    }

    //获取menu对象
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //获取用户点击的action按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSetting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void openSearch(){
        Toast.makeText(this, "openSearchButtonClick", Toast.LENGTH_SHORT).show();
    }

    protected void openSetting(){
        Toast.makeText(this, "openSettingButtonClick", Toast.LENGTH_SHORT).show();
    }
}
