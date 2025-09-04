package modelCharacter;

public class Character {
   private String name;
   private int health;
   private  int attack;
   private int defense;
   protected static int maxHealth;

   public Character (String name){
       this.name = name;

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public static void setMaxHealth(int maxHealth) {
        Character.maxHealth = maxHealth;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    public void attack(Character target){
       if(attack>=0 && health>0.2*maxHealth){
           health-=0.5*attack;
           takeDefense(attack, target.defense);
           target.health-=attack;

       }else{
           System.out.println("недостаточно здоровья");
       }
    }
    public  void takeDefense(int damage, int defense){
       if(defense>damage){
           attack=0;
       }else{
           System.out.println("атака нанесена");
       }
    }
    public boolean isAlive(){
     if(health>0)
         return true;
    else
        return false;
    }
}
//1234