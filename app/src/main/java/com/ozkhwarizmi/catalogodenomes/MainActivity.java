package com.ozkhwarizmi.catalogodenomes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;
    EditText txtNome;
    Button btnAdicionar;
    ListView lvNome;
    List<String> lstNomes;//Componente do Java Array.

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome      = findViewById(R.id.txtNome);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        lvNome       = findViewById(R.id.lvNome);
        lstNomes = new ArrayList<>();//Inicializando a lista de nomes
        adapter  = new ArrayAdapter<>(this, R.layout.nome_item, R.id.txtNome, this.lstNomes);
        this.lvNome.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    String nome = txtNome.getText().toString();
                lstNomes.add(nome);
                txtNome.setText("");

                adapter.notifyDataSetChanged();
            */
            Toast.makeText(MainActivity.this, "Tamanho "+lstNomes.size(), Toast.LENGTH_LONG).show();//Toast irá mostrar o tamanho da lista .size()
            Intent it = new Intent (MainActivity.this, AdicionarActivity.class);
            startActivityForResult(it, REQUEST_CODE);//Toda vez que necessita enviar um inforamção para traz.
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            String nome = data.getStringExtra("nome");
            if(nome != null){
                lstNomes.add(nome);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
