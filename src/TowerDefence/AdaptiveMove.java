package TowerDefence;

// Динамическое передвижение - ускоряется, если здоровье меньше половины
class AdaptiveMove implements MoveStrategy {
    @Override
    public void move(int place[], int hp, int maxHp) {
        if (hp > maxHp / 2) {
            place[0]++;
        } else {
            place[0] += 2;
        }
    }
    @Override
    public String getSpeedDescription() {
        return "Переменчивая скорость. 1 клетка за 1 кадр, но 2 клетки за кадр если здоровье меньше половины.";  // Реализация метода
    }
}