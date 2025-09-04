import modelCharacter.Character;
import modelCharacter.Monstr;
import modelCharacter.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CharacterTest {
    private Character player;
    private Character monstr;

    @Before
    public void setUp(){
       player = new Player("NewPlayer");
       monstr = new Monstr("NewMonstr");
    }
    @Test
    public void attackTest(){
        player.setAttack(10);
        int health= player.getHealth();
        player.attack(monstr);
        int currentHealth = (int) (health-0.5* player.getAttack());
        Assert.assertEquals(currentHealth, player.getHealth());
    }
    @Test
    public void attackTestMoreThen20(){
        player.setAttack(25);
        player.setHealth(5);
        int health= player.getHealth();
        player.attack(monstr);
        int currentHealth = 5;
        Assert.assertEquals(currentHealth, player.getHealth());
    }
    @Test
    public void takeDefenseLessThenAtackaTest(){
        player.setAttack(10);
        int health= monstr.getHealth();
        player.attack(monstr);
        int currentHealth = (int) (health- player.getAttack());
        monstr.takeDefense(10, 9);
        Assert.assertEquals(currentHealth, monstr.getHealth());
    }
    @Test
    public void takeDefenseMoreThenAttackaTest(){
        player.setAttack(10);
        int health= monstr.getHealth();
        monstr.setDefense(15);
        player.attack(monstr);
        int currentHealth = (int) (health);
        Assert.assertEquals(currentHealth, monstr.getHealth());
    }
    @Test
    public void takeDefenseEqualsAttackaTest(){
        player.setAttack(10);
        int health= monstr.getHealth();
        monstr.setDefense(10);
        player.attack(monstr);
        int currentHealth = (int) (health-player.getAttack());
        Assert.assertEquals(currentHealth, monstr.getHealth());
    }
    @Test
    public void isAlliveTest(){
        Assert.assertTrue(monstr.isAlive());
    }
    @Test
    public void isAlliveFalseTest(){
        monstr.setHealth(0);
        Assert.assertFalse(monstr.isAlive());
    }
}
//123