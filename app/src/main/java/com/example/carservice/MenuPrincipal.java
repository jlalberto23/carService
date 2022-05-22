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
        auto.setOnClickListener(onclick);
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
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    };
}