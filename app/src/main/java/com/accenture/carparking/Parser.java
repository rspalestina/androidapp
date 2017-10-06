package com.accenture.carparking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.accenture.bean.Empleado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by j.zamora.villasenor on 10/3/2017.
 */

public class Parser extends AsyncTask<Void,Integer,Integer> {
    Context c;
    ListView lv;
    String data;
    MyCustomAdapter myCustomAdapter=null;
    ArrayList<Empleado> employees=new ArrayList<>();
    ProgressDialog pd;
    public Parser(Context c, String data,ListView lv) {
        this.c = c;
        this.lv = lv;
        this.data = data;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer==1){
            ArrayAdapter<Empleado> adapter=new ArrayAdapter<Empleado>(c,android.R.layout.simple_list_item_1,employees);
            myCustomAdapter= new MyCustomAdapter(c,R.layout.program_list,employees);
            lv.setAdapter(myCustomAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Snackbar.make(view,employees.get(position),Snackbar.LENGTH_SHORT).show();;
                }
            });
        }else{
            Toast.makeText(c,"No se puede unir",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }
    private int parse(){
        try {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;
            employees.clear();
            for (int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);
                String nombre=jo.getString("nombre");
                String apellido=jo.getString("apellido");
                String status=jo.getString("status");
                String telefono=jo.getString("telefono");
                employees.add(new Empleado(status,nombre,apellido,telefono));
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
