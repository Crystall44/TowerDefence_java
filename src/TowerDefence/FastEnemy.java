package TowerDefence;

// Класс быстрого врага
class FastEnemy extends Enemy {
    public FastEnemy() {
        super();
        setName("FastEnemy");
        setHp((short) 50);
        setCost(10);
        setDmg((short) 20);
        setPct('F');
        maxHp = hp;
        setPlace(-2);
    }
}