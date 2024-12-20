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
        setMoveStrategy(new FastMove());
    }
    @Override
    public String getDescription() {
        return "Быстрый враг - соответствует названию, быстрый и опасный враг.\\nДвигается очень быстро, наносит много урона, но у него совсем мало здоровья.\n";
    }
}