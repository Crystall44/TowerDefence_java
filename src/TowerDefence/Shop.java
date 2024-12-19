package TowerDefence;
import java.util.Scanner;

public class Shop {
    private int repairCost;
    private int upgradeCost;
    private int mainUpgradeCost;

    public void openShop() {
        repairCost = 20;
        upgradeCost = 10;
        mainUpgradeCost = 30;
    }

    public int Info(Tower tower, int money, TowerDef[] deftowers, Map gameMap, int booster) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("  ---Магазин---  ");
            System.out.println("1.Главная башня");
            System.out.println("2.Вспомогательные башни");
            System.out.println("3.Выход");
            System.out.println("Ваши средства - " + money + " (Бустеров = " + booster + ")");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    tower.Info();
                    int choice2;
                    do { // Главная башня
                        System.out.println("\n1.Восполнить здоровье - " + repairCost);
                        System.out.println("2.Улучшить - " + mainUpgradeCost);
                        System.out.println("3.Выход");
                        choice2 = scanner.nextInt();

                        switch (choice2) {
                            case 1: // Восполнение здоровья
                                if (money >= repairCost) {
                                    tower.setHp((short) (tower.getHp() + 500));
                                    repairCost += 10;
                                    if (tower.getHp() > 3000) tower.setHp((short) 3000);
                                } else {
                                    System.out.println("Недостаточно средств!");
                                    scanner.nextLine();  // Пропуск очередной строки
                                }
                                break;
                            case 2: // Улучшение
                                if (money >= mainUpgradeCost && tower.getLvl() < 10) {
                                    tower.upDmg();  // метод для увеличения уровня
                                    money -= mainUpgradeCost;
                                    mainUpgradeCost += 20;
                                } else if (money < mainUpgradeCost) {
                                    System.out.println("Недостаточно средств!");
                                    scanner.nextLine();
                                } else {
                                    System.out.println("Главная башня прокачана на максимум.");
                                    scanner.nextLine();
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Неверный ввод.");
                                scanner.nextLine();
                        }
                    } while (choice2 != 3);
                    break;
                }
                case 2: { // Вспомогательные башни
                    int choice2;
                    int i;
                    do {
                        System.out.println("Выберите башню(1-8):");
                        i = scanner.nextInt();
                    } while (i < 1 || i > 8);

                    TowerDef deftow = deftowers[i - 1];
                    deftow.Info();
                    do {
                        TowerDef usual = new TowerDef((short) 0, (short) 0, (short) 0, false);
                        SniperTower sniper = new SniperTower((short) 0, (short) 0, (short) 0, false);
                        RapidFireTower rapid = new RapidFireTower((short) 10, (short) 2, (short) 1, true, 2);

                        System.out.println("\n1.Купить башню - 10");
                        System.out.println("2.Улучшить - " + upgradeCost);
                        System.out.println("3.Удалить башню");
                        System.out.println("4.Выход");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1: { // Покупка башни
                                System.out.println("\nВыберите тип башни:\n1 - Обычная(10)");
                                usual.specialAbility();
                                System.out.println("2 - Дальняя(25)");
                                sniper.specialAbility();
                                System.out.println("3 - Скорострельная(25)");
                                rapid.specialAbility();
                                int choice22;
                                do {
                                    choice22 = scanner.nextInt();
                                } while (choice22 < 1 || choice22 > 3);

                                if (choice22 == 1) {
                                    if (money >= 10 && deftow.getLvl() == 0) {
                                        gameMap.towerPlace(i - 1, 1);
                                        deftow.build();
                                        money -= 10;
                                    } else if (deftow.getLvl() != 0) {
                                        System.out.println("Эта башня уже построена!");
                                    } else {
                                        System.out.println("Недостаточно средств!");
                                    }
                                } else {
                                    if (money >= 25 && deftow.getLvl() == 0) {
                                        if (choice22 == 2) {
                                            gameMap.towerPlace(i - 1, 2);
                                            sniper.build();
                                            deftow.clone(sniper);
                                        } else {
                                            gameMap.towerPlace(i - 1, 3);
                                            rapid.build();
                                            deftow.clone(rapid);
                                        }
                                        money -= 25;
                                    } else if (deftow.getLvl() != 0) {
                                        System.out.println("Эта башня уже построена!");
                                    } else {
                                        System.out.println("Недостаточно средств!");
                                    }
                                }
                                break;
                            }
                            case 2: { // Улучшение башни
                                if (money >= upgradeCost && deftow.getLvl() < 10) {
                                    System.out.println("1.Увеличить урон(+2)");
                                    System.out.println("2.Увеличить дальность(+1)");
                                    System.out.println("3.Усиление(3x скорострельность башни)");
                                    System.out.println("4.Выход");
                                    int upgradeChoice;
                                    do {
                                        upgradeChoice = scanner.nextInt();
                                    } while (upgradeChoice < 1 || upgradeChoice > 4);

                                    if (upgradeChoice == 1) {
                                        deftow.Upgrade();
                                        money -= upgradeCost;
                                    } else if (upgradeChoice == 2) {
                                        deftow.upRange();
                                        money -= upgradeCost;
                                    } else if (upgradeChoice == 3) {
                                        if (!deftow.isBoosted()) {
                                            deftow.boost();
                                            booster--;
                                        } else {
                                            System.out.println("У вас нет бустеров!");
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: { // Удаление башни
                                System.out.println("Вы уверены?\n1.Удалить башню\n2.Назад");
                                int deleteChoice = scanner.nextInt();
                                if (deleteChoice == 1) {
                                    deftow.deleteTower();
                                    gameMap.towerBrake(i - 1);
                                }
                                break;
                            }
                            case 4:
                                break;
                            default:
                                System.out.println("Неверный ввод!");
                        }
                    } while (choice2 != 4);
                    break;
                }
                case 3:
                    break;
                default:
                    System.out.println("Неверный ввод!");
            }
        } while (choice != 3);
        return money;
    }
}