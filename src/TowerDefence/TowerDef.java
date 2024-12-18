package TowerDefence;

public class TowerDef {
    public short dmg;
    public short lvl;
    public short range;

    public TowerDef() {
        dmg = 0;
        lvl = 0;
        range = 0;
    }

    public void setDmg(short dmg) {this.dmg = dmg;}
    public void setRange(short range) {this.range = range;}

    public short getDmg() {return dmg;}
    public short getLvl() {return lvl;}

    public boolean isNear(int  enemyPlace, int towerPlace) {
        return ((enemyPlace >= ((towerPlace * 5 - 2) - range)) && (enemyPlace <= ((towerPlace * 5 + 2) + range)));
    }
    public void upDmg() {
        lvl++;
        dmg += 25;
    }
    public void upRange() {
        lvl++;
        range++;
    }
    public void Info() {
        System.out.println("Уровень = " + lvl + ", урон = " + dmg + ", дальность = " + range);
    }
    public void build() {
        lvl = 1;
        range = 2;
        dmg = 15;
    }
    public void del() {
        lvl = 0;
        range = 0;
        dmg = 0;
    }
}
