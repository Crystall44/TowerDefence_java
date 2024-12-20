package TowerDefence;

public class Enemy {
    protected String name;
    protected int cost;
    protected short hp;
    protected short maxHp;
    protected short dmg;
    protected char pct;
    protected int[] place = new int[1];
    protected MoveStrategy moveStrategy;

    // Конструктор
    public Enemy() {
        cost = 0;
        hp = 0;
        dmg = 0;
        pct = ' ';
        place[0] = 0;
    }

    public Enemy(String name, int cost, int hp, int dmg, char pct, MoveStrategy moveStrategy) {
        this.name = name;
        this.hp = (short) hp;
        this.maxHp = (short) hp;
        this.cost = cost;
        this.dmg = (short) dmg;
        this.pct = pct;
        this.place[0] = 0;
        this.moveStrategy = moveStrategy;
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

    public void takeDmg(short damage) {
        hp -= damage;
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

    public short getMaxHp() {
        return maxHp;
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
    // Метод для получения описания скорости
    public String getSpeedDescription() {
        if (moveStrategy != null) {
            return moveStrategy.getSpeedDescription(); // Перенаправление на соответствующую стратегию
        }
        return "Нет информации о стратегии движения.";
    }

    // Метод для получения описания врага
    public String getDescription() {
        switch (pct) {
            case 'Z':
                return "Зомби - обычный враг, который имеет большое количество здоровья. \n" +
                        "Не представляет особой угрозы, но может быть щитом для других врагов, что делает его довольно опасным.\n" +
                        "Имеет малый урон и обычную скорость.\n";
            case 'S':
                return "Скелет - обычный враг, который имеет мало здоровья, появляется часто.\n" +
                        "В одиночку не представляет никакой угрозы.\n" +
                        "Но могут создавать неприятности, ведь может появится сразу много скелетов за счёт их малой редкости.\n";
            case 'A':
                return "Злой зомби - улучшенный зомби, с меньшим количеством здоровья, но с большим уроном.\n" +
                        "Представляет сам по себе опасность, ведь как только его здоровье падает до половины - начинает двигаться в 2 раза быстрее.\n";
            default:
                return "Информации об этом враге нет.";
        }
    }
}

