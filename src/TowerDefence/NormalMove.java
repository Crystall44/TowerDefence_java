package TowerDefence;

// Обычная скорость движения
class NormalMove implements MoveStrategy {
    @Override
    public void move(int[] place, int hp, int maxHp) {
        place[0]++; // Движение на 1 клетку
    }
}
