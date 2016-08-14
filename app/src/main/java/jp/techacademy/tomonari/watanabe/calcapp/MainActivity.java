package jp.techacademy.tomonari.watanabe.calcapp;

import android.content.Intent;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText AEditText;
    EditText BEditText;
    TextView note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //idを取得している
        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);

        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        Button times = (Button) findViewById(R.id.times);
        times.setOnClickListener(this);

        Button bar = (Button) findViewById(R.id.bar);
        bar.setOnClickListener(this);


        AEditText = (EditText) findViewById(R.id.VALUE1);
        BEditText = (EditText) findViewById(R.id.VALUE2);
        note =(TextView) findViewById(R.id.note);


    }




    @Override
    public void onClick(View v) {

        if (AEditText.getText().toString().equals("")|| BEditText.getText().toString().equals("")) {

           note.setText("値を入力してください");

        } else {
        Intent intent = new Intent(this, Main2Activity.class);//intent（画面遷移）の設定
        intent.putExtra("valueA", Double.parseDouble(AEditText.getText().toString()));
        intent.putExtra("valueB", Double.parseDouble(BEditText.getText().toString()));

        if (v.getId() == R.id.plus){
            intent.putExtra("Check",1);
        } else if (v.getId() == R.id.minus){
            intent.putExtra("Check",2);
        } else if (v.getId() == R.id.times){
            intent.putExtra("Check",3);
        } else if (v.getId() == R.id.bar && Double.parseDouble(BEditText.getText().toString()) == 0){ //B=0の時のエラー
            intent.putExtra("Check",0);
        } else if (v.getId() == R.id.bar){
            intent.putExtra("Check",4);
        } else {
            intent.putExtra("Check",0);//エラー用
        }

            startActivity(intent);
        }


    }

}
