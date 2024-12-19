package TowerDefence;
// Класс башни
class Tower {
    private short hp;     // Здоровье башни
    private short lvl;    // Уровень башни
    private short dmg;    // Урон башни

    public Tower() {
        hp = 3000;  // Начальное здоровье
        lvl = 1;    // Начальный уровень
        dmg = 20;   // Начальный урон
    }

    // Уменьшение здоровья башни на величину урона
    public void takeDmg(short damage) {
        hp -= damage;
    }

    // Проверка, жива ли башня
    public boolean isAlive() {
        return hp > 0;
    }

    // Методы-геттеры
    public short getDamage() { return dmg; }
    public short getLvl() { return lvl; }
    public short getHp() { return hp; }
    public void setHp(short hp1) { hp = hp1; }
    public void setLvl(short lvl1) { lvl = lvl1; }

    // Проверка, находится ли враг рядом с башней
    public boolean isNear(int enemyPlace) {
        return (enemyPlace >= 35);  // Если враг достиг определенного места
    }

    // Ремонт башни
    public void repair() {
        hp += 500;
        if (hp > 3000) hp = 3000;  // Максимум 3000 здоровья
    }

    // Улучшение башни
    public void upDmg() {
        lvl++;
        dmg += 20;  // Увеличение урона
    }

    // Показ информации о башне
    public void Info() {
        System.out.println("Здоровье = " + hp + ", Урон = " + dmg + ", Уровень = " + lvl);
    }
}
