package com.example.ex7;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    Button btnXML, btnJSON;

    TextView tvXML, tvJSON;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        btnXML = findViewById(R.id.btnXML);
        btnJSON = findViewById(R.id.btnJSON);

        tvXML = findViewById(R.id.tvXML);
        tvJSON = findViewById(R.id.tvJSON);



        btnXML.setOnClickListener(v -> parseXML());


        btnJSON.setOnClickListener(v -> parseJSON());

    }



    // XML Parsing

    private void parseXML(){

        String data = "";

        try {

            InputStream inputStream =
                    getResources().openRawResource(R.raw.student_xml);


            XmlPullParserFactory factory =
                    XmlPullParserFactory.newInstance();


            XmlPullParser parser =
                    factory.newPullParser();


            parser.setInput(inputStream,null);


            int eventType = parser.getEventType();

            String name="";

            while(eventType != XmlPullParser.END_DOCUMENT){


                if(eventType == XmlPullParser.START_TAG){

                    name = parser.getName();

                }


                else if(eventType == XmlPullParser.TEXT){

                    if(name.equals("name") ||
                            name.equals("age")){

                        data += name + " : "
                                + parser.getText()
                                + "\n";

                    }

                }


                eventType = parser.next();

            }


            tvXML.setText(data);


        }

        catch(Exception e){

            tvXML.setText(e.toString());

        }

    }




    // JSON Parsing

    private void parseJSON(){

        String data="";


        try {


            InputStream inputStream =
                    getResources()
                            .openRawResource(R.raw.student_json);


            byte[] buffer =
                    new byte[inputStream.available()];


            inputStream.read(buffer);


            String json =
                    new String(buffer,"UTF-8");


            JSONObject object =
                    new JSONObject(json);


            JSONArray array =
                    object.getJSONArray("students");



            for(int i=0;i<array.length();i++){


                JSONObject student = array.getJSONObject(i);


                data += "Name : "
                        + student.getString("name")
                        + "\n";


                data += "Age : "
                        + student.getString("age")
                        + "\n\n";

            }


            tvJSON.setText(data);


        }

        catch(Exception e){

            tvJSON.setText(e.toString());

        }

    }

}