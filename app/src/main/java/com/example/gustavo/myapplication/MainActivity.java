package com.example.gustavo.myapplication;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MiDialogo.Notificado{

    Button oBtnUno;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        oBtnUno = (Button) findViewById(R.id.btnUno);
        oBtnUno.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {

        DialogFragment mDialog = new MiDialogo();
        mDialog.show(getFragmentManager(), "mDialogo");


        
    }

    @Override
    public void onPositiveButton(DialogFragment mDialog) {
        Toast.makeText(this, "boton positivo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButton(DialogFragment mDialog) {
        Toast.makeText(this, "boton negativo", Toast.LENGTH_SHORT).show();

    }
}
