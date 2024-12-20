package TowerDefence;

// Интерфейс поведения - движение врага
interface MoveStrategy {
    void move(int[] place, int hp, int maxHp);
    String getSpeedDescription();
}

