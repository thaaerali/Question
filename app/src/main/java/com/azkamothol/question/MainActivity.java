package com.azkamothol.question;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView qu, An_1, An_2, An_3, result;
    ArrayList<String> listQu = new ArrayList<>();
    ArrayList<String> listAn = new ArrayList<>();
    ArrayList<String> listShowq = new ArrayList<>();
    int AnNUM, ReNUM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qu = (TextView) findViewById(R.id.textView_qu);
        An_1 = (TextView) findViewById(R.id.textView_an1);
        An_2 = (TextView) findViewById(R.id.textView_an2);
        An_3 = (TextView) findViewById(R.id.textView_an3);
        result = (TextView) findViewById(R.id.textView_result);
        try {
            InputStream inputStream = getAssets().open("qu.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listQu.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = getAssets().open("an.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listAn.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listShowq.add("");
        ShowTXT();
    }
    public void ShowTXT() {
        if (listShowq.size() < listQu.size()) {
            Random R1 = new Random();
            int Rnd_Qu = R1.nextInt(listQu.size());
            String Qus = listQu.get(Rnd_Qu);
            Boolean a = true;
            for (int i = 0; i < listShowq.size(); i++) {
                if (Qus.equals(listShowq.get(i))) {
                    ShowTXT();
                    a = false;
                    listShowq.add(listQu.get(Rnd_Qu));
                    break;
                }
            }
            if (a) {
                qu.setText(Qus);
                String[] Aan = listAn.get(Rnd_Qu).split(",");
                An_1.setText(Aan[0]);
                An_2.setText(Aan[1]);
                An_3.setText(Aan[2]);
                AnNUM = Integer.parseInt(Aan[3]);
                listShowq.add(listQu.get(Rnd_Qu));
            }
        }else{
            Toast.makeText(MainActivity.this, "انتهت الأسئلة", Toast.LENGTH_SHORT).show();
            qu.setText("");
            An_1.setText("");
            An_2.setText("");
            An_3.setText("");
        }
    }
    public void textView_an1(View view) {
        if (AnNUM == 1) {
            Toast.makeText(MainActivity.this, "الاجابة صحيحة", Toast.LENGTH_SHORT).show();
            ReNUM++;
            result.setText("الاجابات الصحيحة : " + ReNUM);
            ShowTXT();
        } else {
            Toast.makeText(MainActivity.this, "الاجابة خاطئة", Toast.LENGTH_SHORT).show();
            ShowTXT();
        }
    }
    public void textView_an2(View view) {
        if (AnNUM == 2) {
            Toast.makeText(MainActivity.this, "الاجابة صحيحة", Toast.LENGTH_SHORT).show();
            ReNUM++;
            result.setText("الاجابات الصحيحة : " + ReNUM);
            ShowTXT();
        } else {
            Toast.makeText(MainActivity.this, "الاجابة خاطئة", Toast.LENGTH_SHORT).show();
            ShowTXT();
        }
    }
    public void textView_an3(View view) {
        if (AnNUM == 3) {
            Toast.makeText(MainActivity.this, "الاجابة صحيحة", Toast.LENGTH_SHORT).show();
            ReNUM++;
            result.setText("الاجابات الصحيحة : " + ReNUM);
            ShowTXT();
        } else {
            Toast.makeText(MainActivity.this, "الاجابة خاطئة", Toast.LENGTH_SHORT).show();
            ShowTXT();
        }
    }
}