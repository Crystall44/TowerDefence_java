package TowerDefence;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tower mainTower = new Tower();
        Map gameMap = new Map();
        Shop shop = new Shop();
        Game game = new Game();
        int wave = 0;
        TowerDef[] towers = new TowerDef[8];
        int booster = 0;
        for(int i = 0;i < towers.length; i++){
            towers[i] = new TowerDef((short)0, (short)0, (short)0, false);
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
                    wave++;
                    game.buyEnemy(wave);
                    boolean waveResult = game.Wave(mainTower, towers, gameMap);
                    if(!waveResult || !mainTower.isAlive()) {
                        System.out.println("Ваша главная башня разрушена! Вы проиграли.");
                        gameOver = true;
                    } else {
                        System.out.println("Вы отбились от волны врагов, заработанно золота: "+ game.getMoney() + "\nВсего убито врагов за игру: " + Game.getTotalEnemyCount());
                    }
                    break;
                case 2:
                    int mon = shop.Info(mainTower, game.getMoney(), towers, gameMap, booster);
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