package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;
    private String Username = "admin";
    private  String Userpass = "admin";
    private boolean isvalidate = false;
    private int counters = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = getApplicationContext();
        CharSequence text = "";
        final int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text , duration);
        toast.show();
        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPass);
        eLogin= findViewById(R.id.btnlogin);
        eAttemptsInfo= findViewById(R.id.tvInfo);
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = eName.getText().toString();
                String inputPass = ePassword.getText().toString();
                if (inputName.isEmpty() || inputPass.isEmpty()){
                    Toast.makeText(MainActivity.this, "សូមបំពេញពណ៍មានឲ្យគ្រប់!", duration).show();
                }else{
                    isvalidate = validate(inputName,inputPass);
                    if (!isvalidate){
                        counters --;
                        Toast.makeText(MainActivity.this, "លេខសំងាត់មិនត្រឹមត្រូវ !", duration).show();
                        eAttemptsInfo.setText("ការអនុញ្ញាតឲ្យបំពេញម្ដងទៀត :" +counters);
                        if (counters == 0 ){
                            eLogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Login ជោគជ័យ", duration).show();
                        Intent intent = new Intent(MainActivity.this, SecondPageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private boolean validate(String name, String password){
        if (name.equals(Username) && password.equals(Userpass)){
            return  true;
        }
        return  false;
    }

}