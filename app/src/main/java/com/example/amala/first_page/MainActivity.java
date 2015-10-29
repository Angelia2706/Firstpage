package com.example.amala.first_page;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.SystemClock;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
public class MainActivity extends ActionBarActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Date dt = new Date();
                    SimpleDateFormat ft1 = new SimpleDateFormat("ddMM");
                    SimpleDateFormat ft2 = new SimpleDateFormat("HHmm");
                    String date = ft1.format(dt);
                    String time = ft2.format(dt);
                    SimpleDateFormat ft3 = new SimpleDateFormat("dd.MM.yyyy");
                    SimpleDateFormat ft4 = new SimpleDateFormat("HH:mm:ss");
                    //SimpleDateFormat ft1 = new SimpleDateFormat("dd.MM.YYYY");
                    File f1 = Environment.getExternalStorageDirectory();
                    File f2 = new File(f1.getPath() + "/" + "VC" + date + time + ".txt");
                    f2.createNewFile();
                    /* FileOutputStream fos = new FileOutputStream(f2);
                    byte[] loc = editText.getText().toString().getBytes();
                    fos.write(loc);
                    byte dat[] = date.getBytes();
                    fos.write(dat);*/
                    String values [] = {editText.getText().toString() ,ft3.format(dt),ft4.format(dt) ,f2.getAbsolutePath()};
                    Intent i = new Intent(MainActivity.this,second_page.class);
                    i.putExtra("details",values );

                    startActivity(i);


                    //Toast.makeText(MainActivity.this, "" + ,sToast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
