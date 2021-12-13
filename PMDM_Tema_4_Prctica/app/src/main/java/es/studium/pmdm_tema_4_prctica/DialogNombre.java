package es.studium.pmdm_tema_4_prctica;

import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogNombre extends DialogFragment
{
    dialogsListeners miListener;

    EditText etNombre;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View MyView = inflater.inflate(R.layout.dialogo_nombre, null);
        etNombre = MyView.findViewById(R.id.editNombre);

        builder.setView(MyView);
        builder.setTitle("Nombre")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                       try
                        {
                        miListener.onDataNombre(etNombre.getText().toString());
                        miListener.comprobarPoderes();

                        }
                       catch(Exception e)
                        {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                        miListener.dialogNombreAceptarListener();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cerrar el diálogo simplemente
                        dialog.dismiss();
                        miListener.dialogNombreCancelarListener();
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
