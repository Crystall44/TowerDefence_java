package TowerDefence;

// Класс снайперской башни
class SniperTower extends TowerDef implements Upgradable {
    public SniperTower(short dmg1, short lvl1, short range1, boolean boostTower1) {
        super(dmg1, lvl1, range1, boostTower1);
    }

    @Override
    public void specialAbility() {
        System.out.println("\nОсобая способность - высокий урон и дальность");
    }

    @Override
    public void Info() {
        super.Info();
        System.out.println("Тип башни - Снайперская (Увеличена дальность и урон)");
    }

    public void build() {
        dmg = 20;
        range = 5;
        lvl = 1;
        boostTower = false;
    }
}
