package es.iesnervion.dbenitez.pokemonlist;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable
{
    private int numero;
    private String nombre;
    private String descripcion;
    private String tipoPrimario;
    private String tipoSecundario;
    private String habilidadPrimaria;
    private String habilidadSecundaria;
    private String habilidadOcultaPrimaria;
    private String habilidadOcultaSecundaria;
    private int imagen;

    public Pokemon()
    {
        numero = 1;
        nombre = "Bulbasaur";
        descripcion = "A Bulbasaur es fácil verle echándose una siesta al sol. La semilla que tiene en el lomo va creciendo cada vez más a medida que absorbe los rayos del sol.";
        tipoPrimario = "Planta";
        tipoSecundario = "Veneno";
        habilidadPrimaria = "Espesura";
        habilidadSecundaria = null;
        habilidadOcultaPrimaria = "Clorofila";
        habilidadOcultaSecundaria = null;
        imagen = R.drawable.bulbasaur2;
    }

    public Pokemon(int number, String nombre, String descripcion, String tipoPrimario, String tipoSecundario, String habilidadPrimaria, String habilidadSecundaria, String habilidadOcultaPrimaria, String habilidadOcultaSecundaria, int imagen)
    {
        this.numero = number;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoPrimario = tipoPrimario;
        this.tipoSecundario = tipoSecundario;
        this.habilidadPrimaria = habilidadPrimaria;
        this.habilidadSecundaria = habilidadSecundaria;
        this.habilidadOcultaPrimaria = habilidadOcultaPrimaria;
        this.habilidadOcultaSecundaria = habilidadOcultaSecundaria;
        this.imagen = imagen;
    }

    protected Pokemon(Parcel in) {
        numero = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        tipoPrimario = in.readString();
        tipoSecundario = in.readString();
        habilidadPrimaria = in.readString();
        habilidadSecundaria = in.readString();
        habilidadOcultaPrimaria = in.readString();
        habilidadOcultaSecundaria = in.readString();
        imagen = in.readInt();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int number)
    {
        this.numero = number;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getTipoPrimario()
    {
        return tipoPrimario;
    }

    public void setTipoPrimario(String tipoPrimario)
    {
        this.tipoPrimario = tipoPrimario;
    }

    public String getTipoSecundario()
    {
        return tipoSecundario;
    }

    public void setTipoSecundario(String tipoSecundario)
    {
        this.tipoSecundario = tipoSecundario;
    }

    public String getHabilidadPrimaria()
    {
        return habilidadPrimaria;
    }

    public void setHabilidadPrimaria(String habilidadPrimaria)
    {
        this.habilidadPrimaria = habilidadPrimaria;
    }

    public String getHabilidadSecundaria()
    {
        return habilidadSecundaria;
    }

    public void setHabilidadSecundaria(String habilidadSecundaria)
    {
        this.habilidadSecundaria = habilidadSecundaria;
    }

    public String getHabilidadOcultaPrimaria()
    {
        return habilidadOcultaPrimaria;
    }

    public void setHabilidadOcultaPrimaria(String habilidadOcultaPrimaria)
    {
        this.habilidadOcultaPrimaria = habilidadOcultaPrimaria;
    }

    public String getHabilidadOcultaSecundaria()
    {
        return habilidadOcultaSecundaria;
    }

    public void setHabilidadOcultaSecundaria(String habilidadOcultaSecundaria)
    {
        this.habilidadOcultaPrimaria = habilidadOcultaPrimaria;
    }

    public int getImagen()
    {
        return imagen;
    }

    public void setImagen(int imagen)
    {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numero);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeString(tipoPrimario);
        dest.writeString(tipoSecundario);
        dest.writeString(habilidadPrimaria);
        dest.writeString(habilidadSecundaria);
        dest.writeString(habilidadOcultaPrimaria);
        dest.writeString(habilidadOcultaSecundaria);
        dest.writeInt(imagen);
    }
}
