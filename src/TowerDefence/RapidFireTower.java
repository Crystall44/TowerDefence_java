package TowerDefence;

// Класс башни с быстрым огнем
class RapidFireTower extends TowerDef implements Upgradable {
    private int attackSpeed;

    public RapidFireTower(short dmg1, short lvl1, short range1, boolean boostTower1, int attackSpeed2) {
        super(dmg1, lvl1, range1, boostTower1);
        attackSpeed = attackSpeed2;
    }

    @Override
    public void specialAbility() {
        System.out.println("\nОсобая способность - низкий урон и высокая скорость атаки");
    }

    @Override
    public void Info() {
        System.out.println("Тип башни: Башня с быстрым огнем");
    }

    public void build() {
        dmg = 10;
        range = 2;
        lvl = 1;
        boostTower = true;
        attackSpeed = 2;
    }
}

