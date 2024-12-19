package TowerDefence;

// Класс оборонительной башни
class TowerDef extends AbstractTower implements Upgradable {
    protected short dmg;      // Урон
    protected short lvl;      // Уровень
    protected short range;    // Дальность
    protected boolean boostTower;  // Увеличение башни
    protected int attackSpeed;     // Скорость атаки
    // Конструктор
    public TowerDef(short dmg1, short lvl1, short range1, boolean boostTower1) {
        dmg = dmg1;
        lvl = lvl1;
        range = range1;
        boostTower = boostTower1;
    }

    // Клонирование данных башни
    public void clone(TowerDef other) {
        lvl = other.lvl;
        dmg = other.dmg;
        range = other.range;
        boostTower = other.boostTower;
        attackSpeed = other.attackSpeed;
    }

    // Методы-сеттеры
    public void setLvl(short l) { lvl = l; }
    public void setDmg(short d) { dmg = d; }
    public void setRange(short r) { range = r; }

    // Получение урона
    public short getDamage() {
        return dmg;
    }

    // Получение уровня
    public short getLvl() {
        return lvl;
    }

    // Проверка, находится ли враг в пределах досягаемости
    public boolean isNear(int enemyPlace, int towerPlace) {
        return (enemyPlace >= ((towerPlace * 5 + 2) - range) && (enemyPlace <= ((towerPlace * 5 + 2) + range)));
    }

    // Увеличение урона
    public void Upgrade() {
        dmg += 25;
    }

    // Увеличение дальности
    public void upRange() {
        range += 1;
    }

    // Показ информации о башне
    public void Info() {
        System.out.println("Уровень = " + lvl + ", Урон = " + dmg + ", Дальность = " + range);
    }

    // Строительство башни
    public void build() {
        range = 2;
        dmg = 15;
        lvl = 1;
    }

    // Удаление башни
    public void deleteTower() {
        lvl = 0;
        range = 0;
        dmg = 0;
        boostTower = false;
    }

    // Проверка, увеличена ли башня
    public boolean isBoosted() {
        return boostTower;
    }

    // Увеличение башни
    public void boost() {
        boostTower = true;
    }

    // Увеличение башни другого типа
    public void boost(TowerDef tower) {
        tower.dmg -= 10;
        tower.boostTower = true;
    }

    @Override
    public void specialAbility() {
        System.out.println("\nОбычная башня. Нет специальных возможностей.");
    }
}
