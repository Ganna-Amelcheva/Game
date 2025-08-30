package modelCharacter;

public class Monstr extends Character {
    public Monstr(String name){
        super(name);
        this.maxHealth=80;
        setHealth(maxHealth);
    }
}
