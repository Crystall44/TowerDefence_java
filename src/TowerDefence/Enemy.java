package TowerDefence;

// Структура врага
class Enemy {
    protected String name;
    protected int cost;
    protected short hp;
    protected short maxHp;
    protected short dmg;
    protected char pct;
    protected int[] place = new int[1];
    protected MoveStrategy moveStrategy;

    public Enemy() {
        hp = 0;
        cost = 0;
        dmg = 0;
        pct = ' ';
        place[0] = -1;
    }

    public void setName(String n) {
        name = n;
    }

    public void setHp(short h) {
        hp = h;
        maxHp = h;
    }

    public void setCost(int c) {
        cost = c;
    }

    public void setDmg(short d) {
        dmg = d;
    }

    public void setPct(char p) {
        pct = p;
    }

    public Enemy takeDmg(short damage) {
        hp -= damage;
        return this;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public char getPct() {
        return pct;
    }

    public String getName() {
        return name;
    }

    public short getHp() {
        return hp;
    }

    public void setPlace(int p) {
        place[0] = p;
    }

    public void setMoveStrategy(MoveStrategy newStrategy) {
        moveStrategy = newStrategy;
    }

    public void move() {
        moveStrategy.move(place, hp, maxHp);
    }

    public short getDmg() {
        return dmg;
    }

    public int getCost() {
        return cost;
    }

    public int getPlace() {
        return place[0];
    }
}

