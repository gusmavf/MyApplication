package com.example.gustavo.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.media.midi.MidiDevice;
import android.os.Bundle;
import android.widget.Toast;

public class MiDialogo extends DialogFragment {

    public interface Notificado{
        public void onPositiveButton(DialogFragment mDialog);
        public void onNegativeButton(DialogFragment mDialog);
    }

    Notificado mNotificado;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            mNotificado = (Notificado) activity;
            Toast.makeText(activity, "on atache", Toast.LENGTH_SHORT).show();

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " debe implementar Notificado");
        }

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.sTituloDialogo1)
        .setMessage(R.string.sMensajeDialogo1)
                .setPositiveButton(R.string.sBtnDialogo1Aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mNotificado.onPositiveButton(MiDialogo.this);

                    }
                })
        .setNegativeButton(R.string.sBtnDialogo1Cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mNotificado.onNegativeButton(MiDialogo.this);

            }
        })
        ;
        return builder.create();
    }
}
