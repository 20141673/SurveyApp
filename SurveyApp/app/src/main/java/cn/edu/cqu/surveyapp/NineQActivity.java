package cn.edu.cqu.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class NineQActivity extends AppCompatActivity {
    private static final String[] strs=new String[]{
            "Less than 6 months","Almost 1 year","Less than 2 year","more than 2 year"
    };
    private String result01;
    private ListView lv01;
    private Button btn01;
    private int isSelected=0;
    MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_q);
        myApplication=(MyApplication)getApplication();
        lv01=(ListView)findViewById(R.id.lv01);
        lv01.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,strs));
        lv01.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result01=getString(R.string.qustion9)+strs[position];
                setTitle(result01);
                isSelected = 1;
            }
        });
        btn01=(Button)findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelected==1) {
                    myApplication.appendToResult(result01);
                    Intent intent = new Intent(NineQActivity.this, TenQActivity.class);
                    NineQActivity.this.startActivity(intent);
                }else {
                    Toast.makeText(NineQActivity.this,"Please make a selection",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
