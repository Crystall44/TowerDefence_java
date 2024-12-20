package TowerDefence;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int money;
    private int enemysCount;
    private int enemyMoney;
    private static int totalEnemyCount; //Статическое поле - счетчик убитых врагов
    private ArrayList<Enemy> enemys;
    public Game() {
        enemysCount = 0;
        money = 20;
        enemyMoney = 20;
        enemys = new ArrayList<>();
    }
    public static int getTotalEnemyCount() {
        return totalEnemyCount;
    }
    public int getMoney() {return money;}
    public void setMoney(int money) {this.money = money;}
    public int getEnemyMoney() {return enemyMoney;}
    public void earnMoney(int n) {this.money += n;}
    public void upenemys() {this.enemyMoney += 20;}
    public void buyEnemy(int wave) { //Рандомайзер врагов
        if (wave % 5 == 0 && enemysCount == 0) {
            BossEnemy boss = new BossEnemy();
            if (enemyMoney >= boss.getCost()) {
                enemyMoney -= boss.getCost();
                boss.setMoveStrategy(new SlowMove());
                enemys.add(boss);
                enemysCount++;
                boss.setPlace(-1 * enemysCount);
            }
        }
        do {
            if (wave % 5 == 0 && enemysCount == 0) {
                BossEnemy boss = new BossEnemy();
                if (enemyMoney >= boss.getCost()) {
                    enemyMoney -= boss.getCost();
                    boss.setMoveStrategy(new SlowMove());
                    enemys.add(boss);
                    enemysCount++;
                    enemys.get(enemysCount - 1).setPlace(-1 * enemysCount);
                }
            }
            Enemy newEnemy = new Enemy();
            Random rand = new Random();
            int r = rand.nextInt(4) + 1;

            switch (r) {
                case 1:
                    newEnemy.setName("Zombe");
                    newEnemy.setCost(4);
                    newEnemy.setHp((short) 100);
                    newEnemy.setDmg((short) 10);
                    newEnemy.setPct('Z');
                    newEnemy.setMoveStrategy(new NormalMove());
                    break;
                case 2:
                    newEnemy.setName("Skeleton");
                    newEnemy.setCost(2);
                    newEnemy.setHp((short) 30);
                    newEnemy.setDmg((short) 20);
                    newEnemy.setPct('S');
                    newEnemy.setMoveStrategy(new NormalMove());
                    break;
                case 3:
                    newEnemy.setName("Angry Zombe");
                    newEnemy.setCost(6);
                    newEnemy.setHp((short) 75);
                    newEnemy.setDmg((short) 25);
                    newEnemy.setPct('A');
                    newEnemy.setMoveStrategy(new AdaptiveMove());
                    break;
                case 4:
                    FastEnemy fastEnemy = new FastEnemy();
                    newEnemy.setName(fastEnemy.getName());
                    newEnemy.setCost(fastEnemy.getCost());
                    newEnemy.setHp(fastEnemy.getHp());
                    newEnemy.setDmg(fastEnemy.getDmg());
                    newEnemy.setPct(fastEnemy.getPct());
                    newEnemy.setMoveStrategy(new FastMove());
                    break;
            }
            if (enemyMoney >= newEnemy.getCost()) {
                enemyMoney -= newEnemy.getCost();
                enemys.add(newEnemy);
                enemysCount++;
                enemys.get(enemysCount - 1).setPlace(-1 * enemysCount);
            }
        } while (enemyMoney >= 2);
    }
    public boolean Wave(Tower mainTower, TowerDef[] towers, Map gameMap) {
        int k = 0;
        boolean f = true;
        int i = 0;
        int chek = enemysCount;
        do {
            for (int j = 0; j < 8; j++) {
                if (towers[j].isBoosted()) {
                    for (int p = 0; p < 3; p++) {
                        for (i = 0; i < enemysCount; i++) {
                            if (enemys.get(i).isAlive()) {
                                if (towers[j].isNear(enemys.get(i).getPlace(), j) && (towers[j].getLvl() != 0) && enemys.get(i).getPlace() >= 0) {
                                    enemys.get(i).takeDmg(towers[j].getDamage());
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    for (i = 0; i < enemysCount; i++) {
                        if (enemys.get(i).isAlive()) {
                            if (towers[j].isNear(enemys.get(i).getPlace(), j) && (towers[j].getLvl() != 0) && enemys.get(i).getPlace() >= 0) {
                                enemys.get(i).takeDmg(towers[j].getDamage());
                                break;
                            }
                        }
                    }
                }
            }
            for (i = 0; i < enemysCount; i++) {
                if (enemys.get(i).isAlive()) {
                    if (mainTower.isNear(enemys.get(i).getPlace()) && enemys.get(i).getPlace() >= 0) {
                        enemys.get(i).takeDmg(mainTower.getDamage());
                        break;
                    }
                }
            }
            for (i = 0; i < enemysCount; i++) {
                if (enemys.get(i).isAlive()) {
                    if (enemys.get(i).getPlace() != 38 && enemys.get(i).getPlace() >= 0) {
                        gameMap.clear(enemys.get(i).getPlace(), 1);
                        enemys.get(i).move();
                        if (enemys.get(i).getPlace() > 38) enemys.get(i).setPlace(38);
                        gameMap.placeEnemy(enemys.get(i).getPlace(), enemys.get(i).getPct());
                    } else if (enemys.get(i).getPlace() == 38) {
                        mainTower.takeDmg(enemys.get(i).getDmg());
                    } else {
                        enemys.get(i).move();
                        if (enemys.get(i).getPlace() == 0) gameMap.placeEnemy(0, enemys.get(i).getPct());
                    }
                } else {
                    gameMap.clear(enemys.get(i).getPlace(), 1);
                    money += enemys.get(i).getCost() * 2;
                    enemys.remove(i);
                    enemysCount--;
                    i--;
                }
            }
            gameMap.printMap();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemysCount == 0) f = false;
            if (!mainTower.isAlive()) f = false;
        } while (f);
        enemysCount = 0;
        if (!mainTower.isAlive()) {
            System.out.println("Вы проиграли!");
            return false;
        } else {
            upenemys();
            return true;
        }
    }
}

