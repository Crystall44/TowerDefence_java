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
        // Создание объекта EnemyManager
        EnemyManager enemyManager = new EnemyManager();
        // Добавление врагов
        enemyManager.addEnemy(new Enemy("Zombe", 4, 100, 10, 'Z', new NormalMove()));
        enemyManager.addEnemy(new Enemy("Skeleton", 2, 30, 20, 'S', new NormalMove()));
        enemyManager.addEnemy(new Enemy("Angry Zombe", 6, 75, 20, 'A', new AdaptiveMove()));
        enemyManager.addEnemy(new Enemy("Fly", 1, 5, 10, '*', new NormalMove()));
        enemyManager.addEnemy(new BossEnemy());
        enemyManager.addEnemy(new FastEnemy());
        shop.openShop();
        while(!gameOver) {
            System.out.println("\nВаши действия:\n1.Начать новую волну\n2.Открыть магазин\n3.Список всех врагов\n4.Выход из игры\nВыберите действие:");
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
                // Сортировка и поиск
                case 3: // Сортировка и поиск
                    System.out.println("Ваши действия:");
                    System.out.println("1. Открыть полный список врагов");
                    System.out.println("2. Поиск");
                    System.out.println("3. Выход");
                    int poisk = scanner.nextInt();
                    switch (poisk) {
                        case 1:
                            System.out.println("1. Без сортировки");
                            System.out.println("2. Сортировка по здоровью");
                            System.out.println("3. Сортировка по стоимости (редкости)");
                            System.out.println("4. Сортировка по урону");
                            int poisk2 = scanner.nextInt();
                            if (poisk2 == 2) {
                                enemyManager.sortByHp();
                            } else if (poisk2 == 3) {
                                enemyManager.sortByCost();
                            } else if (poisk2 == 4) {
                                enemyManager.sortByDmg();
                            }
                            System.out.println("1. Краткая информация о врагах");
                            System.out.println("2. Полная информация и описание каждого врага");
                            System.out.println("Любая другая клавиша - выход.");
                            poisk2 = scanner.nextInt();
                            if (poisk2 == 1) {
                                enemyManager.showAll(false);
                            } else if (poisk2 == 2) {
                                enemyManager.showAll(true);
                            }
                            break;

                        case 2:
                            System.out.println("1. Поиск по имени");
                            System.out.println("2. Поиск по картинке");
                            System.out.println("3. Выход");
                            int poisk3 = scanner.nextInt();
                            if (poisk3 == 1) {
                                scanner.nextLine();
                                System.out.println("Введите имя врага (латиница): ");
                                String name = scanner.nextLine();
                                System.out.println("При успешном поиске:");
                                System.out.println("1. Краткая информация о враге");
                                System.out.println("2. Полная информация и описание");
                                int poisk4;
                                do {
                                    poisk4 = scanner.nextInt();
                                } while (poisk4 != 1 && poisk4 != 2);
                                if (poisk4 == 1) {
                                    enemyManager.findEnemyByName(name, false);
                                } else {
                                    enemyManager.findEnemyByName(name, true);
                                }
                            } else if (poisk3 == 2) {
                                System.out.println("Введите картинку врага (латиница): ");
                                char pct = scanner.next().charAt(0);
                                System.out.println("При успешном поиске:");
                                System.out.println("1. Краткая информация о враге");
                                System.out.println("2. Полная информация и описание");
                                int poisk4;
                                do {
                                    poisk4 = scanner.nextInt();
                                } while (poisk4 != 1 && poisk4 != 2);
                                if (poisk4 == 1) {
                                    enemyManager.findEnemyByPct(pct, false);
                                } else {
                                    enemyManager.findEnemyByPct(pct, true);
                                }
                            }
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Неверный ввод!");
                            break;
                    }
                    break;
                case 4:
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