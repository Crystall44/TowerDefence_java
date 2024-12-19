package TowerDefence;

// Класс врага-босса, наследующий от Enemy
abstract class BossEnemy extends Enemy {
    public BossEnemy() {
        setName("Boss");
        setHp((short) 500);  // Здоровье босса
        setCost(20);         // Стоимость босса
        setDmg((short) 50);  // Урон босса
        setPct('B');         // Символ для босса
    }
}

