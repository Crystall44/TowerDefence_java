package TowerDefence;

// Структура босса - дочерний класс Enemy
class BossEnemy extends Enemy {
    public BossEnemy() {
        super();
        setName("Boss");
        setHp((short) 500);
        setCost(20);
        setDmg((short) 50);
        setPct('B');
        setMoveStrategy(new SlowMove());
    }
    @Override
    public String getDescription() {
        return "Босс - выходит на каждую 5 волну, и только 1 босс на карте. Очень медленный, но очень опасный враг.\n" +
                "Огромное количество здоровья и урона, до него игра кажеться совсем лёгкой,не так ли?\n";
    }
}
