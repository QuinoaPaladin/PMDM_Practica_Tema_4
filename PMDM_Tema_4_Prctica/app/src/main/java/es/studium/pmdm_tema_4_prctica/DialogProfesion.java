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

public class DialogProfesion extends DialogFragment
{
    dialogsListeners miListener;

    RadioGroup rgProfesion;
    RadioButton rbArquero;
    RadioButton rbGuerrero;
    RadioButton rbMago;
    RadioButton rbHerrero;
    RadioButton rbMinero;
    RadioButton rbProfesionElegida;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View MyView = inflater.inflate(R.layout.dialogo_profesion, null);

        rgProfesion = (RadioGroup) MyView.findViewById(R.id.radioProfesion);
        rbArquero = (RadioButton) MyView.findViewById(R.id.radioArquero);
        rbGuerrero = (RadioButton) MyView.findViewById(R.id.radioGuerrero);
        rbMago = (RadioButton) MyView.findViewById(R.id.radioMago);
        rbHerrero = (RadioButton) MyView.findViewById(R.id.radioHerrero);
        rbMinero = (RadioButton) MyView.findViewById(R.id.radioMinero);

        builder.setView(MyView);
        builder.setTitle("Profesion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        int profesionelegida = rgProfesion.getCheckedRadioButtonId();
                        rbProfesionElegida = (RadioButton) MyView.findViewById(profesionelegida);

                        miListener.onDataProfesion(rbProfesionElegida.getText().toString());
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
