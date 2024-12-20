package TowerDefence;

// Быстрое передвижение
class FastMove implements MoveStrategy {
    @Override
    public void move(int[] place, int hp, int maxHp) {
        place[0] += 2; // Движение на 2 клетки
    }
}