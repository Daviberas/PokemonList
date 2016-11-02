package es.iesnervion.dbenitez.pokemonlist;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity
{
    private static final Pokemon[] pokes =
            {
                    new Pokemon(),
                    new Pokemon(25,"Pikachu","","Eléctrico","Eléctrico", "Electricidad estática",null,"Pararrayos", null, R.drawable.pikachu2),
                    new Pokemon(133,"Eevee","","Normal","Normal", "Fuga","Adaptable","Anticipación", null, R.drawable.eevee2),
                    new Pokemon(151,"Mew","","Psíquico","Psíquico", "Sincronía",null,null, null, R.drawable.mew2),
                    new Pokemon(609,"Chandelure","","Fantasma","Fuego", "Absorbe Fuego","Cuerpo llama","Sombra trampa", "Allanamiento", R.drawable.chandelure2),
                    new Pokemon(282,"Gardevoir","","Psíquico","Hada", "Sincronía","Rastro","Telepatía", null, R.drawable.gardevoir2),
                    new Pokemon(448,"Lucario","","Lucha","Acero", "Impasible","Foco interno","Justiciero", null, R.drawable.lucario2),
                    new Pokemon(492,"Shaymin","","Planta","Planta", "Cura natural","Dicha",null, null, R.drawable.shaymin2)
            };
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(android.R.id.list);

        lista.setAdapter(new AdapterIcono(this,R.layout.row,R.id.texto,pokes));
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        Intent intent = new Intent(this, PokeProfile.class);

        intent.putExtra(getString(R.string.pokemon), pokes[position]);
        startActivity(intent);
    }

    class AdapterIcono<T> extends ArrayAdapter<T>
    {
        AdapterIcono(Context c, int resourceId, int textId, T[] objects)
        {
            super(c, resourceId, textId, objects);
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View row = convertView;
            ViewHolder holder;

            if (row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);

                TextView tv = (TextView) row.findViewById(R.id.texto);
                ImageView iv = (ImageView) row.findViewById(R.id.img);

                holder = new ViewHolder (tv,iv);
                row.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) row.getTag();
            }

            holder.getTv().setText(pokes[position].getNombre());
            holder.getIv().setImageResource(pokes[position].getImagen());

            return (row);
        }
    }
    class ViewHolder
    {
        TextView tv;
        ImageView iv;

        ViewHolder (TextView tv, ImageView iv){
            this.tv = tv;
            this.iv = iv;
        }

        public TextView getTv (){
            return this.tv;
        }

        public ImageView getIv (){
            return this.iv;
        }
    }
}
