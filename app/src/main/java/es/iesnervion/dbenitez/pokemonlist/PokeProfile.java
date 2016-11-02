package es.iesnervion.dbenitez.pokemonlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PokeProfile extends AppCompatActivity {

    private TextView nombre;
    private TextView numeroPokedex;
    private ImageView img;
    private TextView descripcion;
    private TextView tipos;
    private TextView habilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_profile);

        Pokemon poke = getIntent().getExtras().getParcelable("pokemon");

        nombre = (TextView) findViewById(R.id.nombre);
        numeroPokedex = (TextView) findViewById(R.id.numeroPokedex);
        img = (ImageView) findViewById(R.id.poke);
        descripcion = (TextView) findViewById(R.id.descripcion);
        tipos = (TextView) findViewById(R.id.tipos);
        habilidades = (TextView) findViewById(R.id.habilidades);

        nombre.setText("Nombre:\n"+poke.getNombre());
        numeroPokedex.setText("\nNº Pokédex: \n"+poke.getNumero());
        img.setImageResource(poke.getImagen());
        descripcion.setText("\nDescripción: \n"+poke.getDescripcion());
        if(!poke.getTipoPrimario().equals(poke.getTipoSecundario()))
        {
            tipos.setText("\nTipo: "+poke.getTipoPrimario()+"/"+poke.getTipoSecundario());
        }
        else
            tipos.setText("\nTipo: "+poke.getTipoPrimario());

        String habilidad = "\nHabilidades: \n"+poke.getHabilidadPrimaria();
        if(poke.getHabilidadSecundaria()!=null)
        {
            habilidad+= "/"+poke.getHabilidadSecundaria();
        }

        if(poke.getHabilidadOcultaPrimaria()!=null)
        {
            habilidad+= "\n"+poke.getHabilidadOcultaPrimaria();
            if(poke.getHabilidadOcultaSecundaria()!=null)
            {
                habilidad+= "/"+poke.getHabilidadOcultaSecundaria();
            }
        }

        habilidades.setText(habilidad);
    }
}
