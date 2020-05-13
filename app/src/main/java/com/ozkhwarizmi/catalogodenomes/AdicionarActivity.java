package com.ozkhwarizmi.catalogodenomes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdicionarActivity extends AppCompatActivity {

    EditText txtNome;
    Button btnAdicionar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        txtNome = findViewById(R.id.txtNome);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText().toString();
                Intent it = new Intent();
                it.putExtra("nome", nome);
                setResult(RESULT_OK, it);//Sinaliza para quem solicitou a tarefa de que tarefa deu certo, sendo passdo por código
                finish();
            }
        });
    }
}
