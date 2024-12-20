package TowerDefence;

// Медленная скорость - для босса
class SlowMove implements MoveStrategy {
    private int f = 0;

    @Override
    public void move(int[] place, int hp, int maxHp) {
        if (f == 0) {
            f++;
        } else {
            f = 0;
            place[0]++;
        }
    }
    public String getSpeedDescription() {
        return "Медленная скорость. 1 клетка за 2 кадра.";  // Реализация метода
    }
}