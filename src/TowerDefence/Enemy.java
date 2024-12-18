package TowerDefence;
public class Enemy {
    private String name;
    private int cost;
    private short hp;
    private short dmg;
    private char pct;
    private int place;

    public Enemy() {
        hp = 0;
        cost = 0;
        dmg = 0;
        pct = ' ';
        place = -1;
    }

    public void setName(String name) {this.name = name;}
    public void setHp(short hp) {this.hp = hp;}
    public void setCost(int cost) {this.cost = cost;}
    public void setDmg(short dmg) {this.dmg = dmg;}
    public void setPct(char pct) {this.pct = pct;}
    public void takeDmg(short damage) {hp -= damage;}
    public void move() {place++;}
    public boolean isAlive() {return hp > 0;}
    public char getPct() {return pct;}
    public short getDmg() {return dmg;}
    public int getCost() {return cost;}
    public int getPlace() {return place;}
}
