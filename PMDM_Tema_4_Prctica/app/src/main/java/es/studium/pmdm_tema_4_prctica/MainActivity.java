package es.studium.pmdm_tema_4_prctica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , dialogsListeners{

    TextView nombreAvatar;
    TextView txvVida;
    TextView txvMagia;
    TextView txvFuerza;
    TextView txvVelocidad;

    DialogNombre dialogNombre;
    DialogSexo dialogSexo;
    DialogEspecie dialogEspecie;
    DialogProfesion dialogProfesion;

    Button btnNombre;
    Button btnSexo;
    Button btnEspecie;
    Button btnProfesion;

    int vida;
    int magia;
    int fuerza;
    int velocidad;

    String nombreFinal;
    String sexoFinal;
    String especieFinal;
    String profesionFinal;

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreAvatar = findViewById(R.id.nombreAvatar);
        txvVida = findViewById(R.id.txVida);
        txvMagia = findViewById(R.id.txMagia);
        txvFuerza = findViewById(R.id.txFuerza);
        txvVelocidad = findViewById(R.id.txVelocidad);

        btnNombre = findViewById(R.id.btnNombre);
        btnSexo = findViewById(R.id.btnSexo);
        btnEspecie = findViewById(R.id.btnEspecie);
        btnProfesion = findViewById(R.id.btnProfesion);

        btnNombre.setOnClickListener(this);
        btnSexo.setOnClickListener(this);
        btnEspecie.setOnClickListener(this);
        btnProfesion.setOnClickListener(this);

        imagen = findViewById(R.id.imagenAvatar);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==(R.id.btnNombre))
        {
        dialogNombre = new DialogNombre();
        dialogNombre.setCancelable(false);
        dialogNombre.show(getSupportFragmentManager(), "Nombre");
        }
        if(v.getId()==(R.id.btnSexo))
        {
        dialogSexo = new DialogSexo();
        dialogSexo.setCancelable(false);
        dialogSexo.show(getSupportFragmentManager(), "Sexo");
        }
        if(v.getId()==(R.id.btnEspecie))
        {
        dialogEspecie = new DialogEspecie();
        dialogEspecie.setCancelable(false);
        dialogEspecie.show(getSupportFragmentManager(), "Especie");
        }
        if(v.getId()==(R.id.btnProfesion))
        {
        dialogProfesion = new DialogProfesion();
        dialogProfesion.setCancelable(false);
        dialogProfesion.show(getSupportFragmentManager(), "Profesión");
        }
    }

    @Override
    public void dialogNombreAceptarListener()
    {
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dialogNombreCancelarListener()
    {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataNombre(String nombre)
    {
        nombreAvatar.setText(nombre);
        nombreFinal=nombre;

    }

    @Override
    public void dialogSexoAceptarListener()
    {
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dialogSexoCancelarListener()
    {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSexo(String sexo)
    {
        if(sexo.equals("Hombre"))
        {
            Toast.makeText(this, "Hombre", Toast.LENGTH_SHORT).show();
            sexoFinal= sexo;
            imagen.setImageResource(R.drawable.ic_baseline_face_24);
        }
        else
        {
            Toast.makeText(this, "Mujer", Toast.LENGTH_SHORT).show();
            sexoFinal= sexo;
            imagen.setImageResource(R.drawable.ic_baseline_elderly_woman_24);
        }
    }

    @Override
    public void dialogEspecieAceptarListener()
    {
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dialogEspecieCancelarListener()
    {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataEspecie(String especie)
    {
        if(especie.equals("Elfo"))
        {
            Toast.makeText(this, "Elfo", Toast.LENGTH_SHORT).show();
            especieFinal=especie;
        }
        if(especie.equals("Enano"))
        {
            Toast.makeText(this, "Enano", Toast.LENGTH_SHORT).show();
            especieFinal=especie;
        }
        if(especie.equals("Hobbit"))
        {
            Toast.makeText(this, "Hobbit", Toast.LENGTH_SHORT).show();
            especieFinal=especie;
        }
        if(especie.equals("Humuano"))
        {
            Toast.makeText(this, "Humano", Toast.LENGTH_SHORT).show();
            especieFinal=especie;
        }
    }

    @Override
    public void dialogProfesionAceptarListener()
    {
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dialogProfesionCancelarListener()
    {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataProfesion(String profesion)
    {
        if(profesion.equals("Arquero"))
        {
            Toast.makeText(this, "Arquero", Toast.LENGTH_SHORT).show();
            profesionFinal=profesion;
        }
        if(profesion.equals("Guerrero"))
        {
            Toast.makeText(this, "Guerrero", Toast.LENGTH_SHORT).show();
            profesionFinal=profesion;
        }
        if(profesion.equals("Mago"))
        {
            Toast.makeText(this, "Mago", Toast.LENGTH_SHORT).show();
            profesionFinal=profesion;
        }
        if(profesion.equals("Herrero"))
        {
            Toast.makeText(this, "Herrero", Toast.LENGTH_SHORT).show();
            profesionFinal=profesion;
        }
        if(profesion.equals("Minero"))
        {
            Toast.makeText(this, "Minero", Toast.LENGTH_SHORT).show();
            profesionFinal=profesion;
        }
    }


    @Override
    public void comprobarPoderes()
    {
        if((nombreFinal!=null) && (sexoFinal!=null) && (especieFinal!=null) && (profesionFinal!=null))
        {
            Random nuevonumero = new Random();
            vida = nuevonumero.nextInt(100) + 1;
            magia=nuevonumero.nextInt(10) + 1;
            fuerza=nuevonumero.nextInt(20) + 1;
            velocidad=nuevonumero.nextInt(5) + 1;

            String vidaConvertir = getString(R.string.cadenavida) + " " + vida + "";
            String magiaConvertir = getString(R.string.cadenamagia) + " " + magia + "";
            String fuerzaConvertir = getString(R.string.cadenafuerza) + " " + fuerza + "";
            String velocidadConvertir = getString(R.string.cadenavelocidad) + " " + velocidad + "";

            txvVida.setText(vidaConvertir);
            txvMagia.setText(magiaConvertir);
            txvFuerza.setText(fuerzaConvertir);
            txvVelocidad.setText(velocidadConvertir);
        }
    }

}