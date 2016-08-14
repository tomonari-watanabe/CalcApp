package jp.techacademy.tomonari.watanabe.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    TextView ValueA;
    TextView ValueB;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        double valueA = intent.getDoubleExtra("valueA",0);
        double valueB = intent.getDoubleExtra("valueB",0);
        int check = intent.getIntExtra("Check", 0);

        Log.d("test", String.valueOf(check) +";" + String.valueOf(valueA)+ ";" + String.valueOf(valueB)); //確認用

        ValueA =(TextView) findViewById(R.id.ValueA);
        ValueB =(TextView) findViewById(R.id.ValueB);
        result = (TextView) findViewById(R.id.result);

        ValueA.setText(String.valueOf(valueA));
        ValueB.setText(String.valueOf(valueB));


        if (check == 1) {
            result.setText(String.valueOf(valueA + valueB));
        } else if (check == 2){
            result.setText(String.valueOf(valueA - valueB));
        } else if (check == 3){
            result.setText(String.valueOf(valueA * valueB));
        } else if (check == 4){
            result.setText(String.valueOf(valueA / valueB));
        } else {
            result.setText("エラー");
        }



    }


}
