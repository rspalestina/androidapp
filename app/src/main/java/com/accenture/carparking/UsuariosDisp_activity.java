package com.accenture.carparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class UsuariosDisp_activity extends AppCompatActivity {
    String url="http://carpaking.000webhostapp.com/employees.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_disp_activity);
        getSupportActionBar().setTitle("Usuarios Disponibles");
        final ListView lv = (ListView)findViewById(R.id.lv);
        final Downloader d=new Downloader(this,url,lv);
        d.execute();
    }
}
