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
    public void buyEnemy() { //Рандомайзер врагов
        do {
            int r = (int) (Math.random() * 3) + 1;
            Enemy newEnemy = new Enemy();
            switch (r) {
                case 1:
                    newEnemy.setName("Zombe");
                    newEnemy.setCost(4);
                    newEnemy.setHp((short) 100);
                    newEnemy.setDmg((short) 10);
                    newEnemy.setPct('Z');
                    break;
                case 2:
                    newEnemy.setName("Skeleton");
                    newEnemy.setCost(2);
                    newEnemy.setHp((short) 30);
                    newEnemy.setDmg((short) 20);
                    newEnemy.setPct('S');
                    break;
                case 3:
                    newEnemy.setName("Angry Zombe");
                    newEnemy.setCost(6);
                    newEnemy.setHp((short) 75);
                    newEnemy.setDmg((short) 25);
                    newEnemy.setPct('A');
                    break;
            }
            if (this.enemyMoney >= newEnemy.getCost()) {
                this.enemyMoney -= newEnemy.getCost();
                this.enemys.add(newEnemy);
                this.enemysCount++;
            }
        } while (enemyMoney >= 2);
    }
    public boolean wave(Tower mainTower, TowerDef[] towers, Map gameMap){ //Волна
        int k = 0;
        boolean f = true;
        int chek = this.enemysCount;
        do {
            if(k < chek) {
                gameMap.placeEnemy(0, enemys.get(k).getPct());
                k++;
                enemys.get(k - 1).move();
            }
            for (int j = 0; j < 8; j++) {
                for (int i = 0;i < enemysCount; i++) {
                    if(enemys.get(i).isAlive()) {
                        if (towers[j].isNear(enemys.get(i).getPlace(), j) && towers[j].getLvl() != 0) {
                            enemys.get(i).takeDmg(towers[j].getDamage());
                            break;
                        }
                    }
                }
            }
            for(int i = 0; i < enemysCount; i++) {
                if (enemys.get(i).isAlive() && enemys.get(i) != null) {
                    if (mainTower.isNear(enemys.get(i).getPlace())) {
                        enemys.get(i).takeDmg(mainTower.getDamage());
                        if(!enemys.get(i).isAlive()) {
                            gameMap.clear(enemys.get(i).getPlace(), 1);
                            this.money += enemys.get(i).getCost();
                        }
                    }
                }
            }
            for (int i = 0; i < enemysCount; i++) {
                if (enemys.get(i).isAlive()) {
                    if (enemys.get(i).getPlace() != 38 && enemys.get(i).getPlace() >= 0) {
                        gameMap.clear(enemys.get(i).getPlace(), 1);
                        enemys.get(i).move();
                        gameMap.placeEnemy(enemys.get(i).getPlace(), enemys.get(i).getPct());
                    } else {
                        mainTower.takeDmg(enemys.get(i).getDmg());
                    }
                } else {
                    gameMap.clear(enemys.get(i).getPlace(), 1);
                    money += enemys.get(i).getCost() * 2;
                    enemys.remove(i);
                    totalEnemyCount++;
                    enemysCount--;
                    i--;
                }
            }
            gameMap.printMap();
            try{
                Thread.sleep(800);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            if (enemysCount == 0 || !mainTower.isAlive()) {
                f = false;
            }
        } while (f);
        if (!mainTower.isAlive()) {
            System.out.println("Вы проиграли!");
            return false;
        } else {
            upenemys();
            return true;
        }
    }
}
