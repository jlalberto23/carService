package com.example.carservice;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
    Button auto,cargoEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        auto = (Button) findViewById(R.id.btnAuto);
        cargoEmp = (Button) findViewById(R.id.btnCargoEm);
        auto.setOnClickListener(onclick);
        cargoEmp.setOnClickListener(onclick);
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()){
                    case R.id.btnAuto:
                        Intent intent = new Intent(MenuPrincipal.this,Auto.class);
                        MenuPrincipal.this.startActivity(intent);
                        break;
                    case R.id.btnCargoEm:
                        Intent intent1 = new Intent(MenuPrincipal.this,CargoEmpleado.class);
                        MenuPrincipal.this.startActivity(intent1);
                        break;/*
                    case R.id.btnCategoriaF:
                        intent = new Intent(MenuPrincipal.this,CategoriaFalla.class);
                        break;
                    case R.id.btnUsuario:
                        intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnCliente:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnEmpleado:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnFalla:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnMantenimiento:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnMarcaA:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnModeloAuto:
                        //intent = new Intent(MenuPrincipal.this,Usuario.class);
                        break;
                    case R.id.btnSucursal:
                        intent = new Intent(MenuPrincipal.this,Sucursal.class);
                        break;
                    case R.id.btnTipoA:
                        break;
                    case R.id.btnTipoMto:
                        intent = new Intent(MenuPrincipal.this,TipoMto.class);
                        break;*/
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    };
}