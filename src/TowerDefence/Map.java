package TowerDefence;

// Класс карты
class Map {
    private char[][] place;

    public Map() {
        place = new char[40][3];
        for (int i = 0; i < 40; i++) {
            place[i][0] = '-';
            place[i][1] = ' ';
            place[i][2] = '-';
        }
        for (int i = 2; i < 40; i += 5) {
            place[i][0] = '0';
        }
        place[39][1] = '9';
    }

    public void clear(int pos, int n) {
        place[pos][n] = ' ';
    }

    public void towerPlace(int num, int n) {
        if (n == 1) place[num * 5 + 2][0] = 'T';
        else if (n == 2) place[num * 5 + 2][0] = 'L';
        else place[num * 5 + 2][0] = 'R';
    }
    public void towerBrake(int num) {
        place[num * 5 + 2][0] = '0';
    }

    public void placeEnemy(int pos, char pct) {
        place[pos][1] = pct;
    }

    public void printMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(place[j][i]);
            }
            System.out.println();
        }
    }
}
