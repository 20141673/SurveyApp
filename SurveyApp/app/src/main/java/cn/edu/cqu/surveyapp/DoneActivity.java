package cn.edu.cqu.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DoneActivity extends AppCompatActivity {
    MyApplication myApplication;
    private TextView textView02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        myApplication=(MyApplication)getApplication();
        textView02=(TextView)findViewById(R.id.textView02) ;
        myApplication.read(textView02);
    }
}
