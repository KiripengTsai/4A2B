package com.example.dell.playgame;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.Random;

public class SecondActivity extends Activity{
    int number[]=new int[4];
    Button play;
    EditText output1;
    EditText input1;
    Random random=new Random();
    int count=0;
    boolean judgeTrue(String s){
        if(s.length()!=4)return false;
        String temp[]=s.split("");
        for(int i=1;i<temp.length;i++){
            for(int j=i+1;j<temp.length;j++){
                if(temp[i].equals(temp[j]))return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       play=(Button)findViewById(R.id.play);
        output1=(EditText)findViewById(R.id.output1);
       input1=(EditText)findViewById(R.id.input1);


       play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    for(int i=0;i<4;i++){
            int d=random.nextInt(10);
            int j=0;
            while(j!=i){
                if(number[j]!=d)j++;
                if(number[j]==d){
                    j=0;
                    d=random.nextInt(10);
                }
            }
            number[i]=d;
          }
                }
                String temp=input1.getText().toString();
                if(!judgeTrue(temp)){
                    output1.setText("不合法，请重新输入");
                    input1.setText("");
                }
                else{
                    int A=0,B=0;
                    String temp1[]=temp.split("");
                    for(int i=0;i<4;i++){
                        for(int j=0;j<4;j++){
                            if(Integer.parseInt(temp1[i+1])==number[j]&&j==i){
                                A++;
                                break;
                            }
                            if(Integer.parseInt(temp1[i+1])==number[j]&&j!=i){
                                B++;
                                break;
                            }
                        }
                    }
                    if(A==4){
                        output1.setText("回答正确，已重置猜测数字");
                        count=0;
                        input1.setText("");
                    }
                    else{
                        String sx=""+A+"A"+B+"B";
                        count++;
                        output1.setText(sx);
                        input1.setText("");
                    }
                }
                //
            }
        });
    }
}
