package com.edwinacubillos.notificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doNotification(View view){

        String title="", content="", ticker="";

        EditText eTitulo = (EditText) findViewById(R.id.eTitulo);
        EditText eContenido = (EditText) findViewById(R.id.eContenido);
        EditText eTicker = (EditText) findViewById(R.id.eTicker);

        title = eTitulo.getText().toString();
        content = eContenido.getText().toString();
        ticker = eTicker.getText().toString();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle(title)
                .setContentText(content)
                .setTicker(ticker)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentInfo("Dato");

        Intent i = new Intent (MainActivity.this, InfoActivity.class);

        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0 , i, 0);

        builder.setContentIntent(pi);

        NotificationManager nm =  (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1,builder.build());


    }


}
