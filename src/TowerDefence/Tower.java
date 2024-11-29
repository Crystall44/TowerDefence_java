package TowerDefence;
public class Tower {
    private short hp;
    private short lvl;
    private short dmg;

    public Tower() {
        hp = 3000;
        lvl = 1;
        dmg = 20;
    }

    public void takeDmg(short damage) {hp -= damage;}
    public boolean isAlive() {return hp > 0;}
    public short getDamage() {return dmg;}
    public short getLvl() {return lvl;}
    public short getHp() {return hp;}
    public boolean isNear(int enemyPlace) {return enemyPlace >= 35;}

    public void repair(){ //Починка главной башни
        hp += 500;
        if(hp > 3000) hp = 3000;
    }
    public void upDmg() { //Повышение урона
        lvl++;
        dmg += 20;
    }
    public void Info() { //Информация о главной башне
        System.out.println("Здоровье = " + hp + ", урон = " + dmg + ", уровень = " + lvl);
    }
}
