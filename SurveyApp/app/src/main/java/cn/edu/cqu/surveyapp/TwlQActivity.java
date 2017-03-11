package cn.edu.cqu.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TwlQActivity extends AppCompatActivity {
    private String result01="";
    private Button btn01;
    private EditText editText01;
    private int isSelected=0;
    MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twl_q);
        myApplication=(MyApplication)getApplication();
       editText01=(EditText)findViewById(R.id.editText01);
        btn01=(Button)findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected=editText01.length();
                if(isSelected<=0) {
                    Toast.makeText(TwlQActivity.this,"Please write something",Toast.LENGTH_SHORT).show();
                }else {
                    result01 = getString(R.string.qustion12)+editText01.getText();
                    myApplication.appendToResult(result01);
                    myApplication.Write(myApplication.getFinalResult());
                    Intent intent = new Intent(TwlQActivity.this, DoneActivity.class);
                    TwlQActivity.this.startActivity(intent);
                    //editText01.setText(myApplication.getFinalResult());
                }
            }
        });
    }
}
