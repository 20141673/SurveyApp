package cn.edu.cqu.surveyapp;

import android.app.Application;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 陈圳林 on 2017/3/11.
 */

public class MyApplication extends Application {
    private String finalResult="The Survey Result is:\n";
    public String getFinalResult(){
        return finalResult;
    }
    public void appendToResult(String string){
        this.finalResult+=string+"\n";
    }
    public void Write(String text){
        try{
            FileOutputStream fos=this.openFileOutput("SurveyData.txt", Context.MODE_WORLD_READABLE);
            fos.write(text.getBytes());
           Toast.makeText(MyApplication.this,"The result has save to SurveyData.txt",Toast.LENGTH_SHORT).show();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read(TextView tv){
        try{
            FileInputStream fis=this.openFileInput("SurveyData.txt");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int length=-1;
            while ((length=fis.read(buffer))!=-1) {
                stream.write(buffer,0,length);
            }
            stream.close();
            fis.close();
            tv.setText(stream.toString()+"\nThe result has been saved to SurveyData.txt");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
