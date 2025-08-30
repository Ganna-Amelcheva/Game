package modelCharacter;

public class Player extends Character {
    public Player(String name){
        super(name);
        this.maxHealth=100;
       setHealth(maxHealth);
    }
    public void printResultStartPlayer(Monstr monstr) {
        System.out.println("Атака игрока:" + getAttack());
        System.out.println("защита монстра: " + monstr.getDefense());
        System.out.println("здоровье игрока " + getHealth());
        System.out.println("здоровье монстра: " + monstr.getHealth());
        System.out.println();
    }
}
//123