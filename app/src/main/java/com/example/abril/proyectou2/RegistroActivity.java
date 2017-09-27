package com.example.abril.proyectou2;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    DBAdapter db;
    Button btn;
    EditText name, mail, phone;
    SQLiteDatabase a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn = (Button) findViewById(R.id.btn_guardar);
        name = (EditText) findViewById(R.id.edt_name);
        mail = (EditText) findViewById(R.id.edt_email);
        phone = (EditText) findViewById(R.id.edt_tel);

        db=new DBAdapter(getApplicationContext());
        insertarDatos();

    }


    public void insertarDatos(){
        Toast.makeText(getApplicationContext(), "Pasando por el método insertarDatos", Toast.LENGTH_SHORT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.open();
                String n = name.getText().toString();
                String t = phone.getText().toString();
                String m = mail.getText().toString();
                long val = db.insertContact(n,m,t);
                //Log.d("MyDB",val+"");
                Toast.makeText(getApplicationContext(),"Se insertó un nuevo contacto",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                db.close();
            }
        });
    }

}
