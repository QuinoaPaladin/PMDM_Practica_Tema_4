package es.studium.pmdm_tema_4_prctica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogSexo extends DialogFragment
{

    dialogsListeners miListener;

    RadioGroup rgSexo;
    RadioButton rbHombre;
    RadioButton rbMujer;
    RadioButton rbGeneroElegido;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View MyView = inflater.inflate(R.layout.dialogo_sexo, null);
        rgSexo = MyView.findViewById(R.id.radioSexo);
        rbHombre = MyView.findViewById(R.id.radioHombre);
        rbMujer = MyView.findViewById(R.id.radioMujer);

        builder.setView(MyView);

        builder.setTitle("Sexo")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        int sexoelegido = rgSexo.getCheckedRadioButtonId();
                        rbGeneroElegido = (RadioButton) MyView.findViewById(sexoelegido);

                        miListener.onDataSexo(rbGeneroElegido.getText().toString());
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
