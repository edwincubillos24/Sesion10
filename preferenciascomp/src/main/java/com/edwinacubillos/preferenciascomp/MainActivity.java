package com.edwinacubillos.preferenciascomp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();

        refreshPrefs();

    }

    public void savePrefs(View view){
        EditText campo = (EditText) findViewById(R.id.eNombre);
        String campoStr = campo.getText().toString();
        editor.putString("nombre",campoStr);
        editor.commit();
        refreshPrefs();
    }

    public void clearPrefs(View view){
        // editor.clear();Limpiar todas las preferencias
        editor.remove("nombre");
        editor.commit();
        refreshPrefs();

    }

    public void refreshPrefs(){
        TextView dato = (TextView) findViewById(R.id.tNombre);
        String nombre = prefs.getString("nombre", "NA");
        dato.setText(nombre);

    }


}
