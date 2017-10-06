package com.accenture.carparking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.accenture.bean.Empleado;

import java.util.ArrayList;

/**
 * Created by j.zamora.villasenor on 10/3/2017.
 */

public class MyCustomAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Empleado> emp;

    public MyCustomAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context,textViewResourceId, objects);

        this.context= context;
        emp=objects;

    }
    private class ViewHolder
    {
        TextView empName;
        TextView empApe;
        TextView empTel;
        ImageView empStatus;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.program_list, null);
            holder = new ViewHolder();
            holder.empName = (TextView) convertView.findViewById(R.id.textView1);
            holder.empApe = (TextView) convertView.findViewById(R.id.textView2);
            holder.empTel = (TextView) convertView.findViewById(R.id.textView3);
            holder.empStatus = (ImageView) convertView.findViewById(R.id.imageView1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Empleado empleado = emp.get(position);
        if(empleado.getStatus().equals("disponible")){
            holder.empName.setText("Nombre:" + empleado.getNombre());
            holder.empApe.setText("Apellido:" + empleado.getApellido());
            holder.empTel.setText("Telefono:" + empleado.getTelefono());
            holder.empStatus.setImageResource(R.drawable.image2);
        }else if(empleado.getStatus().equals("ocupado")) {
            holder.empName.setText("Nombre:" + empleado.getNombre());
            holder.empApe.setText("Apellido:" + empleado.getApellido());
            holder.empTel.setText("Telefono:" + empleado.getTelefono());
            holder.empStatus.setImageResource(R.drawable.image1);
        }
        return convertView;
    }
}
