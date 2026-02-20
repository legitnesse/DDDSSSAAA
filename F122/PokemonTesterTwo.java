package F122;

import java.util.Random;

public class PokemonTesterTwo 
{
   public static void battle(Pokemon p1, Pokemon p2)
    {
        Random r = new Random();
        Pokemon attacker, victim;
        if(r.nextInt(2) == 0)
        {
            attacker = p1;
            victim = p2;
        }
        else
        {
            attacker = p2;
            victim = p1;
        }
        
        int firstBaseHP = attacker.getHP();
        int secondBaseHP = victim.getHP();
        int rounds = 1;

            while(attacker.getHP() > 0 && victim.getHP() > 0)
            {
                attacker.attack(victim);
                Pokemon temp = attacker;
                attacker = victim;
                victim = temp;
                rounds++;
            }
            attacker.printHP();
            victim.printHP();
            if(attacker.getHP() <= 0)
            {
                attacker.getHP();
                System.out.println(attacker.getName() + " lost to " + victim.getName() + ".");
            }
            if(victim.getHP() <= 0)
            {
                victim.getHP();
                System.out.println(victim.getName() + " lost to " + attacker.getName() + ".");
            }

        if(rounds %2 == 0)
        {
            attacker.setHP(firstBaseHP);
            victim.setHP(secondBaseHP);
        }
        else
        {
            attacker.setHP(secondBaseHP);
            victim.setHP(firstBaseHP);
        }
            
        System.out.println(attacker.getName() + " and " + victim.getName() + " have been healed to full health. \nThey are ready for battle again.");
        }
    public static void main(String[] args) 
    {
        Charmander ch = new Charmander("CharChar");
        Bulbasaur b = new Bulbasaur("Bulby");
        Squirtle sq = new Squirtle("Squirty");

        battle(ch, b);
        battle(ch, sq);
        battle(b, sq);

        Charmander ch2 = new Charmander("Charo");
        Charmander ch3 = new Charmander("Chara");
        ch2.attack(ch3);
        ch3.attack(ch2);
        System.out.println(ch2.equals(ch3));
        System.out.println(ch3);
        
    } 
}
