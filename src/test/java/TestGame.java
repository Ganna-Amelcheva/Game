
import modelCharacter.Monstr;
import modelCharacter.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import serviceGame.Game;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static serviceGame.Game.isCorrectAttacka;


public class TestGame {
    private Player player;
    private Monstr monstr;
    @Before
   public void setUp() {
        player = new Player("NewPlayer");
        monstr = new Monstr("NewMonster");
    }
  @Test
  public void isCorrectAttackTest(){
      Scanner scanner=new Scanner(System.in);
      String atacka ="10\n";
      System.setIn(new ByteArrayInputStream(atacka.getBytes()));
    Game.isCorrectAttacka();

   Assert.assertTrue(isCorrectAttacka());
   Assert.assertFalse(isCorrectAttacka());
  }
}
