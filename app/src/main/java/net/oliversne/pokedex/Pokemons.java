package net.oliversne.pokedex;

public class Pokemons {
    //Attributes
    private String name, defense, attack, speed;
    //Puntos de salud
    private String ps;
    private int pokemonImg;

    //Constructor
    public Pokemons(String name, String ps, String attack, String defense, String speed, int pokemonImg) {
        this.name = name;
        this.ps = ps;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.pokemonImg = pokemonImg;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getPokemonImg() {
        return pokemonImg;
    }

    public void setPokemonImg(int pokemonImg) {
        this.pokemonImg = pokemonImg;
    }
}
