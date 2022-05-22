package com.example.carservice.fragmets;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.carservice.R;
import com.example.carservice.mto.Conexion;
import com.example.carservice.mto.mtoCliente;
import com.example.carservice.mto.mtoEmpleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarCliente extends Fragment {
    Conexion cn;
    Button guardar,cancelar;
    EditText codigo,usuario,nombre,apellido,telefono,direccion;
    TextView fecha_ingreso;
    Context thiscontext = null;
    long ahora = System.currentTimeMillis();
    Date fecha = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String salida = df.format(fecha);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guardar_cliente, container, false);
        guardar = (Button)v.findViewById(R.id.btnGuardarEmp);
        cancelar = (Button)v.findViewById(R.id.btnCancelarEmp);
        codigo = (EditText)v.findViewById(R.id.txtCodigoEmpG);
        usuario = (EditText)v.findViewById(R.id.editTextTextPersonName16);
        nombre = (EditText)v.findViewById(R.id.txtNOmbreEmpG);
        apellido = (EditText)v.findViewById(R.id.txtApellidosEmpG);
        telefono = (EditText)v.findViewById(R.id.txtTelefonoEmpG);
        fecha_ingreso = (TextView)v.findViewById(R.id.txtFechaEmpG);
        fecha_ingreso.setText(salida);
        guardar.setOnClickListener(onclick);
        cancelar.setOnClickListener(onclick);
        thiscontext = this.getActivity();
        cn = new Conexion(thiscontext);
        return v;
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnGuardarEmp:
                    String resp;
                    mtoCliente cliente = new mtoCliente();
                    cliente.setId_cliente(Integer.parseInt(codigo.getText().toString()));
                    cliente.setNombre(nombre.getText().toString());
                    cliente.setApellidos(apellido.getText().toString());
                    cliente.setUsuario(usuario.getText().toString());
                    cliente.setFecha_registro(salida);
                    cliente.setTelefono(telefono.getText().toString());
                    cliente.setDireccion(direccion.getText().toString());
                    cn.abrir();
                    resp=cn.insertar(cliente);
                    cn.cerrar();
                    Toast.makeText(v.getContext(), resp, Toast.LENGTH_SHORT).show();
                    limpiarTxt();
                    break;
                case R.id.btnCancelarEmp:
                    limpiarTxt();
                    break;
            }
        }
    };

    private void limpiarTxt(){
        codigo.setText("");
        usuario.setText("");
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        direccion.setText("");
    }
}