package F122;

public class PokemonTesterOne 
{
    public static void main(String[] args) 
    {
        Charmander ch = new Charmander("CharChar");
        Bulbasaur b = new Bulbasaur("Bulby");
        Squirtle sq = new Squirtle("Squirty");

        ch.printHP();
        b.printHP();
        sq.printHP();

        ch.attack(b);
        b.attack(sq);
        sq.attack(ch);

        ch.printHP();
        b.printHP();
        sq.printHP();
    }
    
}
