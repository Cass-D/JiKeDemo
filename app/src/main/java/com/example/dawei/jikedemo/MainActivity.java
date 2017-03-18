package com.example.dawei.jikedemo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {
 private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_test);

         text= (TextView) findViewById(R.id.text);

        try {

            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
           /* Document document=builder.parse(getAssets().open("languages.xml"));
            Element element=document.getDocumentElement();
            NodeList list=element.getElementsByTagName("lan");
            for(int i=0;i<list.getLength();i++){
                Element lan= (Element) list.item(i);
                text.append("\n"+lan.getAttribute("id")+"\n");
                text.append(lan.getElementsByTagName("name").item(0).getTextContent()+"\n");
                text.append(lan.getElementsByTagName("ide").item(0).getTextContent()+"\n");
            }*/

            Document newxml=builder.newDocument();
            Element languages=newxml.createElement("Languages");
            languages.setAttribute("cat","it");

            Element lan1=newxml.createElement("lan");
            lan1.setAttribute("id","1");
            Element name1=newxml.createElement("name");
            name1.setTextContent("java");
            Element ide1=newxml.createElement("ide");
            ide1.setTextContent("eclipse");
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            languages.appendChild(lan1);

            newxml.appendChild(languages);

            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer= transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding","utf-8");
            StringWriter sw=new StringWriter();
            transformer.transform(new DOMSource(newxml),new StreamResult(sw));
            text.setText(sw.toString());


        /*} catch (IOException e) {
            e.printStackTrace();*/
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
       /* } catch (SAXException e) {
            e.printStackTrace();*/
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

/*
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class MainActivity extends ListActivity {
    private TextView text;
   // private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(xml_test);
        text= (TextView) findViewById(R.id.text);

        try {

            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
            Document document=builder.parse(getAssets().open("languages.xml"));
            Element element=document.getDocumentElement();
            NodeList list=element.getElementsByTagName("lan");

            for(int i=0;i<list.getLength();i++){
                Element lan= (Element) list.item(i);
                text.append(lan.getAttribute("id"));
                text.append(lan.getElementsByTagName("name").item(0).getTextContent()+"\n");
                text.append(lan.getElementsByTagName("ide").item(0).getTextContent()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    *//*  setContentView(R.layout.activity_list);
        DB db=new DB(this);
        SQLiteDatabase dbread=db.getReadableDatabase();
        Cursor c=dbread.query("user",null,null,null,null,null,null);
        adapter=new SimpleCursorAdapter(this,R.layout.user_list,c,new String[]{"name","sex"}, new int[]{R.id.name,R.id.sex});
        setListAdapter(adapter);

       DB db=new DB(this);
        SQLiteDatabase dbWrite=db.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name","wang");
        cv.put("sex","男");
        dbWrite.insert("user",null,cv);
        cv=new ContentValues();
        cv.put("name","lin");
        cv.put("sex","男");
        dbWrite.insert("user",null,cv);
        dbWrite.close();*//*


       *//* DB db=new DB(this);
        SQLiteDatabase dbread=db.getReadableDatabase();
        Cursor c=dbread.query("user",null,null,null,null,null,null);
        while(c.moveToNext()){
            String name=c.getString(c.getColumnIndex("name"));
            String sex=c.getString(c.getColumnIndex("sex"));
            System.out.println(String.format("name=%s,sex=%s",name,sex));
        }*//*
    }



}*/
