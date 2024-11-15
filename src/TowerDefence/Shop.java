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
    public int info(Tower mainTower, int money, TowerDef[] towers, Map gameMap) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Магазин ===\n1.Главная башня\n2.Вспомогаетльные башни\n3.Выход\nВаши средства = "+ money);
        choice = scanner.nextInt();
        switch(choice) {
            case 1 -> {
                mainTower.Info();
                int choice2 = 0;
                do {
                    System.out.println("\n1.Восстановить здоровье - " + repairCost + "\n2.Улучшить - " + mainUpgradeCost + "\n3.Выход\nВыберите действие:");
                    choice2 = scanner.nextInt();
                    switch(choice2) {
                        case 1->{
                            if(money >= repairCost) {
                                mainTower.repair();
                                money -= repairCost;
                                repairCost += 10;
                            } else {
                                System.out.println("\nНедостаточно средств!");
                            }
                        }
                        case 2 -> {
                            if (money >= mainUpgradeCost && mainTower.getLvl() < 10){
                                mainTower.upDmg();
                                money -= mainUpgradeCost;
                                mainUpgradeCost += 20;
                            }  else if(money < mainUpgradeCost) {
                                System.out.println("\nНедостаточно средств!");
                            } else {
                                System.out.println("\nГлавная башня улучшена на максимум.");
                            }
                        }
                        case 3 -> {
                            break;
                        }
                        default -> System.out.println("\nНеверный ввод.");
                    }
                } while (choice2 != 3);
            }
            case 2 -> {
                int choice2;
                int i;
                do {
                    System.out.println("Выберите башню(1 - 8):");
                    i = scanner.nextInt();
                } while (i < 1 || i > 8);
                TowerDef selectedTower = towers[i - 1];
                selectedTower.Info();
                do {
                    System.out.println("\n1.Купить башню - 10\n2.Улучшить - " + upgradeCost + "\n3.Удалить башню\n4.Выход\nВыберите действие:");
                    choice2 = scanner.nextInt();
                    switch(choice2) {
                        case 1 -> {
                            if(money >= 10 && selectedTower.getLvl() == 0) {
                                gameMap.towerPlace(i - 1);
                                selectedTower.build();
                                money -= 10;
                            } else if(selectedTower.getLvl() != 0) {
                                System.out.println("\nЭта башня уже построена.");
                            } else {
                                System.out.println("\nНедостаточно средств.");
                            }
                        }
                        case 2 -> {
                            if (money >= upgradeCost && selectedTower.getLvl() < 10) {
                                System.out.println("\n1.Увеличить урон(+2)\n2.Увеличить дальность(+1)\n3.Выход\nВыберите действие:");
                                int upgradeChoice = scanner.nextInt();

                                if(upgradeChoice == 1){
                                    selectedTower.upDmg();
                                    money -= upgradeChoice;
                                    upgradeCost += 5;
                                } else if(upgradeChoice == 2){
                                    selectedTower.upRange();
                                    money -= upgradeCost;
                                    upgradeCost += 5;
                                }
                            } else if(selectedTower.getLvl() >= 10) {
                                System.out.println("\nЭта башня уже на максимальном уровне.");
                            } else {
                                System.out.println("\nНедостаточно средств.");
                            }
                        }
                        case 3 -> {
                            System.out.println("\nВы уверены?(1 = да, 2 = отмена):");
                            int delshoice = scanner.nextInt();
                            if(delshoice == 1){
                                selectedTower.del();
                                gameMap.towerBrake(i - 1);
                            }
                        }
                        case 4 -> {
                            towers[i - 1] = selectedTower;
                            break;
                        }
                        default -> System.out.println("\nНеверный ввод.");
                    }
                } while(choice2 != 4);
            }
            case 3 -> {
                break;
            }
            default -> System.out.println("\nНеверный ввод.");
        }
        return money;
    }
}
