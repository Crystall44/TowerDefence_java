package TowerDefence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();

    // Добавить врага
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    // Показать всех врагов
    public void showAll(boolean fullDetails) {
        for (Enemy enemy : enemies) {
            System.out.println("Имя: " + enemy.getName());
            if (fullDetails) {
                System.out.println("Здоровье: " + enemy.getHp() + "/" + enemy.getMaxHp());
            } else {
                System.out.println("Здоровье: " + enemy.getMaxHp());
            }
            System.out.println("Урон: " + enemy.getDmg());
            System.out.println("Скорость: " + enemy.getSpeedDescription());
            System.out.println("Появляется на карте в таком виде: " + enemy.getPct());
            if (fullDetails) {
                System.out.println("Стоимость(редкость): " + enemy.getCost());
                System.out.println("Позиция: " + enemy.getPlace());
                System.out.println("Описание: " + enemy.getDescription());
            }
            System.out.println();
        }
    }

    // Сортировка по здоровью
    public void sortByHp() {
        Collections.sort(enemies, Comparator.comparingInt(Enemy::getHp));
    }

    // Сортировка по стоимости
    public void sortByCost() {
        Collections.sort(enemies, Comparator.comparingInt(Enemy::getCost));
    }

    // Сортировка по урону
    public void sortByDmg() {
        Collections.sort(enemies, Comparator.comparingInt(Enemy::getDmg));
    }

    // Поиск врага по имени
    public void findEnemyByName(String name, boolean details) {
        boolean found = false;
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(name)) {
                found = true;
                System.out.println("Враг с таким именем найден!");
                System.out.println("Имя: " + enemy.getName());
                if (details) {
                    System.out.println("Здоровье: " + enemy.getHp() + "/" + enemy.getMaxHp());
                } else {
                    System.out.println("Здоровье: " + enemy.getMaxHp());
                }
                System.out.println("Урон: " + enemy.getDmg());
                System.out.println("Скорость: " + enemy.getSpeedDescription());
                System.out.println("Появляется на карте в таком виде: " + enemy.getPct());
                if (details) {
                    System.out.println("Стоимость(редкость): " + enemy.getCost());
                    System.out.println("Позиция: " + enemy.getPlace());
                    System.out.println("Описание: " + enemy.getDescription());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Враг с таким именем не найден.");
        }
    }

    // Поиск врага по картинке
    public void findEnemyByPct(char pct, boolean details) {
        boolean found = false;
        for (Enemy enemy : enemies) {
            if (enemy.getPct() == pct) {
                found = true;
                System.out.println("Враг с такой картинкой найден!");
                System.out.println("Имя: " + enemy.getName());
                if (details) {
                    System.out.println("Здоровье: " + enemy.getHp() + "/" + enemy.getMaxHp());
                } else {
                    System.out.println("Здоровье: " + enemy.getMaxHp());
                }
                System.out.println("Урон: " + enemy.getDmg());
                System.out.println("Скорость: " + enemy.getSpeedDescription());
                System.out.println("Появляется на карте в таком виде: " + enemy.getPct());
                if (details) {
                    System.out.println("Стоимость(редкость): " + enemy.getCost());
                    System.out.println("Позиция: " + enemy.getPlace());
                    System.out.println("Описание: " + enemy.getDescription());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Враг с такой картинкой не найден.");
        }
    }
}
