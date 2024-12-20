package TowerDefence;

// Быстрое передвижение
class FastMove implements MoveStrategy {
    @Override
    public void move(int[] place, int hp, int maxHp) {
        place[0] += 2; // Движение на 2 клетки
    }
    @Override
    public String getSpeedDescription() {
        return "Быстрая скорость. 2 клетки за 1 кадр.";  // Реализация метода
    }
}