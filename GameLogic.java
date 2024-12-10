public class GameLogic {
    final int[] x; 
    final int[] y;
    int bodyParts;
    int appleEaten;
    char direction;

    public GameLogic(int[] x, int[] y, int bodyParts, char direction) {
        this.x = x;
        this.y = y;
        this.bodyParts = bodyParts;
        this.direction = direction;
        this.appleEaten = 0;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - 25;
                break;
            case 'D':
                y[0] = y[0] + 25;
                break;
            case 'L':
                x[0] = x[0] - 25;
                break;
            case 'R':
                x[0] = x[0] + 25;
                break;
        }
    }

    public void checkApple(int appleX, int appleY) {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            appleEaten++;
        }
    }

    public boolean checkCollisions(int screenWidth, int screenHeight) {
        // Check collision with body
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                return true;
            }
        }
        // Check collision with walls
        if (x[0] < 0 || x[0] >= screenWidth || y[0] < 0 || y[0] >= screenHeight) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return appleEaten;
    }
}
