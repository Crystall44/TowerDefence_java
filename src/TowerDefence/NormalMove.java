package TowerDefence;

// Обычная скорость движения
class NormalMove implements MoveStrategy {
    @Override
    public void move(int[] place, int hp, int maxHp) {
        place[0]++;   // Движение на 1 клетку
    }
    @Override
    public String getSpeedDescription() {
        return "Обычная скорость. 1 клетка за 1 кадр.";  // Реализация метода
    }
}
