package com.example.dawei.jikedemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by DaWei on 2017/1/26.
 */

public class UsingAsynctask extends Activity{
    TextView text;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctask_layout);

        text=(TextView) findViewById(R.id.textView);
        findViewById(R.id.dianji).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readURL("http://www.baidu.com");
            }
        });
    }

    public void readURL(String url){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... arg0) {
                try {
                    URL url=new URL(arg0[0]);
                    URLConnection connection= url.openConnection();
                    long total=connection.getContentLength();
                    InputStream istream = connection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(istream);
                    BufferedReader br=new BufferedReader(isr);
                    String line;
                    StringBuilder builder=new StringBuilder();
                    while ((line=br.readLine())!=null){
                        builder.append(line);
                       // publishProgress((float)builder.toString().length()/total);
                    }
                    br.close();
                    istream.close();
                    return  builder.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected  void onCancelled(){
                super.onCancelled();
            }

            protected  void onCancelled(String result){
                super.onCancelled(result);
            }
            protected  void onPreExecute(){
                Toast.makeText(UsingAsynctask.this,"开始读取",Toast.LENGTH_SHORT);
                super.onPreExecute();
            }
            protected  void onPostExecute(String result){
                text.setText(result);
                super.onPostExecute(result);
            }

            protected void onProgressUpdate(Void... values){
                System.err.println(values[0]);
                super.onProgressUpdate(values);
            }
        }.execute(url);
    }
}

