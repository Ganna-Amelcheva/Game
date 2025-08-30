package modelCharacter;

public class Monstr extends Character {
    public Monstr(String name){
        super(name);
        this.maxHealth=80;
        setHealth(maxHealth);
    }
    public void printResultStartMonstr(Player player) {
        System.out.println("Атака монстра: " + getAttack());
        System.out.println("Защита игрока: " + player.getDefense());
        System.out.println("здоровье монстра: " + getHealth());
        System.out.println("здоровье игрока " + player.getHealth());
        System.out.println();
    }
}
//123