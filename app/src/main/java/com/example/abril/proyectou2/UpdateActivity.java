package com.example.abril.proyectou2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText nombre, celular, correo;
    Button actualizar;
    DBAdapter db;
    TextView text;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toast.makeText(getApplicationContext(), "oh oh, algo anda mal", Toast.LENGTH_SHORT);

        nombre = (EditText) findViewById(R.id.nombre_update);
        celular = (EditText) findViewById(R.id.tel_update);
        correo = (EditText) findViewById(R.id.correo_update);

        db = new DBAdapter(getApplicationContext());

        text.setText("Actualizar este contacto");

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            id = parametros.getInt("id");
        }
        Toast.makeText(getApplicationContext(), "manda mensaje si llega hasta aqui(actualizar bd open)", Toast.LENGTH_SHORT);
        db.open();
        Cursor result = db.getContact(id);
        db.close();
        String name = "", email = "", phone = "";
        result.moveToFirst();
        while (!result.isAfterLast()) {
            name = result.getString(1);
            email = result.getString(2);
            phone = result.getString(3);
            result.moveToNext();
        }
        result.close();

        final int auxid = id;
        nombre.setText(name);
        celular.setText(phone);
        correo.setText(email);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "iniciando el metodo onclick para actualizar", Toast.LENGTH_SHORT);
                String n = nombre.getText().toString();
                String t = celular.getText().toString();
                String c = correo.getText().toString();

                db.open();
                db.updateContact(auxid, n, c, t);
                db.close();
                //updateContact(long rowId, String name, String email, String phone)
                Toast.makeText(getApplicationContext(), "Actualizado", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(UpdateActivity.this, MainActivity.class));
            }
        });
    }
}
