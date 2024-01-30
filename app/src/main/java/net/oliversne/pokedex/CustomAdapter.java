package net.oliversne.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Pokemons> {
    //Attributes
    private ArrayList<Pokemons> pokemonsArrayList;
    Context context;

    //Constructor
    public CustomAdapter(ArrayList<Pokemons> pokemonsArrayList, Context context) {
        super(context, R.layout.list_pokedex, pokemonsArrayList);
        this.pokemonsArrayList = pokemonsArrayList;
        this.context = context;
    }

    private static class ViewHolder{
        ImageView pokemonImage;
        TextView pokemonName, pokemonAttack, pokemonDefense, pokemonSpeed, pokemonPS;
    }

    //Obtener la vista
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the pokemon object for the current position
        Pokemons pokemon = getItem(position);

        //Attributes
        ViewHolder holder;
        final View result;

        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_pokedex, parent, false);

            //Finding Views form convertView
            holder.pokemonName = (TextView) convertView.findViewById(R.id.pokemon_name);
            holder.pokemonAttack = (TextView) convertView.findViewById(R.id.pokemon_attack);
            holder.pokemonPS = (TextView) convertView.findViewById(R.id.pokemon_ps);
            holder.pokemonDefense = (TextView) convertView.findViewById(R.id.pokemon_defense);
            holder.pokemonSpeed = (TextView) convertView.findViewById(R.id.pokemon_speed);
            holder.pokemonImage = (ImageView) convertView.findViewById(R.id.pokemon_img);

            result = convertView;
            convertView.setTag(holder);
        }else{
            //Recycle View
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Getting data from the Pokemon Model
        holder.pokemonName.setText(pokemon.getName());
        holder.pokemonSpeed.setText(pokemon.getSpeed());
        holder.pokemonDefense.setText(pokemon.getDefense());
        holder.pokemonPS.setText(pokemon.getPs());
        holder.pokemonAttack.setText(pokemon.getAttack());
        holder.pokemonImage.setImageResource(pokemon.getPokemonImg());
        return result;
    }
}
