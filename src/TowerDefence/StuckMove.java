package TowerDefence;

// Стоящее на месте поведение врага (будет использовано в будущем)
class StuckMove implements MoveStrategy {
    @Override
    public void move(int[] place, int hp, int maxHp) {
        // На месте (например, оглушение)
    }
    public String getSpeedDescription() {
        return "Стоит на месте.";  // Реализация метода
    }
}