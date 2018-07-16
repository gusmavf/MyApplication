package com.example.gustavo.myapplication;

import android.app.DialogFragment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loguin1 extends AppCompatActivity implements MiDialogo.Notificado {


    private FirebaseAuth mAuth;

    private EditText mUsuario, mPassword;
    private Button mLoguin;
    private String LOG = "Loguin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin1);

        mUsuario = (EditText) findViewById(R.id.etUsuario);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mLoguin = (Button) findViewById(R.id.btnLoguin);

        mUsuario.setText("gustavo01@gmail.com");
        mPassword.setText("123456");

        mLoguin.setOnClickListener(mOnClickListener);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser = mAuth.getCurrentUser();

    }


    @Override
    public void onPositiveButton(DialogFragment mDialog) {
        Toast.makeText(this, "boton positivo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButton(DialogFragment mDialog) {
        Toast.makeText(this, "boton negativo", Toast.LENGTH_SHORT).show();

    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String sEmail = mUsuario.getText().toString();
            String sPassword = mPassword.getText().toString();

            intentarLoguearse(sEmail, sPassword);
        }
    };

    private void intentarLoguearse(String sEmail, String sPassword) {



        mAuth.signInWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Loguin1.this, "Todo ok", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Loguin1.this, "No ok", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }
}
