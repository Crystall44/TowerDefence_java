package TowerDefence;
// Класс для врагов
class Enemy {
    protected String name;  // Имя врага
    protected int cost;     // Стоимость врага
    protected short hp;     // Здоровье врага
    protected short dmg;    // Урон врага
    protected char pct;     // Символ, представляющий врага
    protected int place;    // Место врага

    // Конструктор, инициализирующий значения
    public Enemy() {
        hp = 0;
        cost = 0;
        dmg = 0;
        pct = ' ';
        place = -1;
    }

    // Конструктор копирования
    public Enemy(Enemy other) {
        name = other.name;
        cost = other.cost;
        hp = other.hp;
        dmg = other.dmg;
        pct = other.pct;
    }

    // Оператор присваивания
    public Enemy assign(Enemy other) {
        if (this != other) {
            name = other.name;
            cost = other.cost;
            hp = other.hp;
            dmg = other.dmg;
            pct = other.pct;
        }
        return this;
    }

    // Методы-сеттеры и геттеры
    public void setName(String n) { name = n; }
    public void setHp(short h) { hp = h; }
    public void setCost(int c) { cost = c; }
    public void setDmg(short d) { dmg = d; }
    public void setPct(char p) { pct = p; }

    // Уменьшение здоровья врага на величину урона
    public void takeDmg(short damage) {
        hp -= damage;
    }

    // Проверка, жив ли враг
    public boolean isAlive() {
        return hp > 0;
    }

    // Методы-геттеры
    public char getPct() { return pct; }
    public short getHp() { return hp; }
    public void setPlace(int p) { place = p; }
    public int getPlace() { return place; }
    public short getDmg() { return dmg; }
    public int getCost() { return cost; }

    // Перемещение врага
    public void move() {
        place++;
    }
}
