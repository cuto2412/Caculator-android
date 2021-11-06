package com.example.caculotor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String input;
    private String output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }
    public void ButtonClick(View view){
        Button btn = (Button) view;
        String data = btn.getText().toString();
        switch (data){
            case "AC":
                input = "";
                break;
            case "C":
                if(input.length() > 0){
                    String newtext = input.substring(0,input.length() - 1);
                    input = newtext;
                }
                break;
            case "=":
                solve();
                output = input;
                break;
            case "x":
                solve();
                input += "*";
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    //show results
                    solve();
                }
                input += data;
        }
        if(input != "*" || input != "x")
            textView.setText(input);
        else textView.setText("x");
    }
    public void solve(){
        if(input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);

                input = "" + mul;
            }catch (Exception e){
                textView.setText("EROR!");
            }
        }
        else if(input.split("\\/").length == 2){
            String number[] = input.split("\\/");
            try{
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);

                input = "" + div;
            }catch (Exception e){
                textView.setText("EROR!");
            }
        }
        else if(input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);

                input = "" + sum;
            }catch (Exception e){
                textView.setText("EROR!");
            }
        }
        else if(input.split("\\-").length == 2){
            String number[] = input.split("\\-");
            try{
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = "" + sub;
            }catch (Exception e){
                textView.setText("EROR!");
            }
        }
        else{
            textView.setText("Eror!");
        }
        String z[] = input.split("\\.");
        if(z.length > 1){
            if(z[1].equals("0"))
                input = z[0];
        }
    }
}