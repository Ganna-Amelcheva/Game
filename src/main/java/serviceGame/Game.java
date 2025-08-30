package serviceGame;

import modelCharacter.Monstr;
import modelCharacter.Player;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        Player player = new Player("Ivan");
        Monstr monstr = new Monstr("Voin");

        startGame(player, monstr);
        printWinner(player, monstr);
    }

    public static void startGame(Player player, Monstr monstr) {
        boolean flag = random.nextBoolean();
        while (player.getHealth() > 0 && monstr.getHealth() > 0) {
            if (flag == true) {
                gameStartPlayer(player, monstr);
            } else {
                gameStartMonstr(player, monstr);
            }
          flag=!flag;
        }
    }

    public static void gameStartPlayer(Player player, Monstr monstr) {
        System.out.println("игру начинает игрок");
        int attackPlayer=checkAttack();
        player.setAttack(attackPlayer);
        monstr.setDefense(random.nextInt(0, 10));
        player.attack(monstr);
        printResultStartPlayer(player, monstr);
    }
    public static int checkAttack(){
        boolean flag;
        int attackPlayer=0;
        do {
            flag=true;
            System.out.println("произведите атаку: от 0 до 20");
            if(scanner.hasNextInt()){
                attackPlayer = scanner.nextInt();
                scanner.nextLine();
                if(attackPlayer<0 || attackPlayer>=21){
                    System.out.println("вы вышли из диапазона \n повторите попытку");
                    flag=false;
                }
            }else {
                System.out.println("вы ввели не целое число");
                flag=false;
                scanner.nextLine();

            }
        }while (flag==false);
        return attackPlayer;
    }

    public static void gameStartMonstr(Player player, Monstr monstr) {
        System.out.println("игру начинает монстр");
        int attackMonstr = random.nextInt(0, 20);
        monstr.setAttack(attackMonstr);
        player.setDefense(random.nextInt(0, 10));
        monstr.attack(player);
        printResultStartMonstr(player, monstr);
    }

    public static void printResultStartPlayer(Player player, Monstr monstr) {

        System.out.println("Атака игрока:" + player.getAttack());
        System.out.println("защита монстра: " + monstr.getDefense());
        System.out.println("здоровье игрока " + player.getHealth());
        System.out.println("здоровье монстра: " + monstr.getHealth());
        System.out.println();
    }

    public static void printResultStartMonstr(Player player, Monstr monstr) {
        System.out.println("Атака монстра: " + monstr.getAttack());
        System.out.println("Защита игрока: " + player.getDefense());
        System.out.println("здоровье монстра: " + monstr.getHealth());
        System.out.println("здоровье игрока " + player.getHealth());
        System.out.println();
    }

    public static void printWinner(Player player, Monstr monstr) {
        if (player.getHealth() >= 0 && monstr.getHealth() < 0) {
            System.out.println("Победил игрок");
        } else {
            System.out.println("Победил монстр");
        }
    }
}