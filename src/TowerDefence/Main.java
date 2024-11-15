package TowerDefence;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tower mainTower = new Tower();
        Map gameMap = new Map();
        Shop shop = new Shop();
        Game game = new Game();
        TowerDef[] towers = new TowerDef[8];

        for(int i = 0;i < towers.length; i++){
            towers[i] = new TowerDef();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Tower Defence!");
        boolean gameOver = false;
        shop.openShop();
        while(!gameOver) {
            System.out.println("\nВаши действия:\n1.Начать новую волну\n2.Открыть магазин\n3.Выход из игры\nВыберите действие:");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    game.buyEnemy();
                    boolean waveResult = game.wave(mainTower, towers, gameMap);
                    if(!waveResult || !mainTower.isAlive()) {
                        System.out.println("Ваша главная башня разрушена! Вы проиграли.");
                        gameOver = true;
                    } else {
                        System.out.println("Вы отбились от волны врагов, заработанно золота: "+ game.getMoney());
                    }
                    break;
                case 2:
                    int mon = shop.info(mainTower, game.getMoney(), towers, gameMap);
                    game.setMoney(mon);
                    break;
                case 3:
                    System.out.println("Спасибо за игру!");
                    gameOver = true;
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
        scanner.close();
    }
}