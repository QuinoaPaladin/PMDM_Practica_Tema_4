package es.studium.pmdm_tema_4_prctica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogEspecie extends DialogFragment

{
    dialogsListeners miListener;

    RadioGroup rgEspecie;
    RadioButton rbElfo;
    RadioButton rbEnano;
    RadioButton rbHobbit;
    RadioButton rbHumano;
    RadioButton rbEspecieElegida;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View MyView = inflater.inflate(R.layout.dialogo_especie, null);

        rgEspecie = (RadioGroup) MyView.findViewById(R.id.radioEspecie);
        rbElfo = (RadioButton) MyView.findViewById(R.id.radioElfo);
        rbEnano = (RadioButton) MyView.findViewById(R.id.radioEnano);
        rbHobbit = (RadioButton) MyView.findViewById(R.id.radioHobbit);
        rbHumano = (RadioButton) MyView.findViewById(R.id.radioHumano);


        builder.setView(MyView);
        builder.setTitle("Especie")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        int especieelegida = rgEspecie.getCheckedRadioButtonId();
                        rbEspecieElegida = (RadioButton) MyView.findViewById(especieelegida);

                        miListener.onDataEspecie(rbEspecieElegida.getText().toString());
                        miListener.comprobarPoderes();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cerrar el diálogo simplemente
                        dialog.dismiss();
                    }
                });
        //Crear el objeto y devolverlo
        return builder.create();
    }

    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            miListener = (dialogsListeners) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "debe implementar dialogListeners");
        }
    }
}
