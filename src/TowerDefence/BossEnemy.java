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
    }
}
