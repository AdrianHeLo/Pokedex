package net.oliversne.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Pokemons> pokemonsArrayList;
    private static CustomAdapter adapter;
    private MediaPlayer mediaPlayer;
    public void PlaySounds(int name){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, name);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AdapterView
        listView = findViewById(R.id.list_view_pokemons);

        //Data Source
        pokemonsArrayList = new ArrayList<>();
        Pokemons pokemon1 = new Pokemons("Bulbasaur","45","49","49","45",R.drawable.bulbasaur);
        Pokemons pokemon2 = new Pokemons("Bellsprout", "50","75","35","40",R.drawable.bellsprout);
        Pokemons pokemon3 = new Pokemons("Charmander", "39","52","43","65", R.drawable.charmander);
        Pokemons pokemon4 = new Pokemons("Eevee", "55","55","50","55", R.drawable.eevee);
        Pokemons pokemon5 = new Pokemons("Dratini", "41","64","45","50", R.drawable.dratini);
        Pokemons pokemon6 = new Pokemons("Pikachu", "35","55","40","90", R.drawable.pikachu);
        Pokemons pokemon7 = new Pokemons("Zubat", "40","45","35","55", R.drawable.ubat);
        Pokemons pokemon8 = new Pokemons("Snorlax", "160","110","65","30", R.drawable.snorlax);
        Pokemons pokemon9 = new Pokemons("Squirtle", "44","48","65","43", R.drawable.squirtle);
        Pokemons pokemon10 = new Pokemons("Psyduck", "50","52","48","55", R.drawable.psyduck);

        pokemonsArrayList.add(pokemon1);
        pokemonsArrayList.add(pokemon2);
        pokemonsArrayList.add(pokemon3);
        pokemonsArrayList.add(pokemon4);
        pokemonsArrayList.add(pokemon5);
        pokemonsArrayList.add(pokemon6);
        pokemonsArrayList.add(pokemon7);
        pokemonsArrayList.add(pokemon8);
        pokemonsArrayList.add(pokemon9);
        pokemonsArrayList.add(pokemon10);

        adapter = new CustomAdapter(pokemonsArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name;
                name = adapter.getItem(position).getName();
                Toast.makeText(MainActivity.this, "Pokemon Name: " + adapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
                if(name == "Pikachu"){
                    mediaPlayer = MediaPlayer.create(this,name);
                    PlaySounds(R.raw.pikachu_sound);
                }
            }

        });

    }
}