package inf112.skeleton.app.ui_objects;

public enum ProgramCardType {
    MOVE1("src/main/java/inf112/skeleton/app/assets/sprites/move1.png", 49, 66), 
    MOVE2("src/main/java/inf112/skeleton/app/assets/sprites/move2.png", 67, 78),
    MOVE3("src/main/java/inf112/skeleton/app/assets/sprites/move3.png", 79, 84), 
    BACKUP("src/main/java/inf112/skeleton/app/assets/sprites/backup.png", 43, 48),
    ROTATE_LEFT("src/main/java/inf112/skeleton/app/assets/sprites/rotateleft.png", 8, 42), 
    ROTATE_RIGTH("src/main/java/inf112/skeleton/app/assets/sprites/rotateright.png", 8, 42),
    UTURN("src/main/java/inf112/skeleton/app/assets/sprites/uturn.png", 1, 6);

    public final String src;
    private final int max, min;

    ProgramCardType(String src, int min, int max) {
        this.src = src;
        this.max = max;
        this.min = min;
    }

    public static int getRandomInt(ProgramCardType type) {
        int max = type.max;
        int min = type.min;


        int x = (int) (((Math.random()*((max-min)+1))+min));
    
        if (type == ROTATE_LEFT){
            if (x % 2 == 0) x -= 1;
        }

        if (type == ROTATE_RIGTH){
            if (x % 2 != 0) x -= 1;
        }
        
        return x*10;
    }

    public static ProgramCardType getRandomCard() {
        int c = (int)(Math.random() * (7 - 1 + 1) + 1);
        switch (c) {
            case 1:
                return MOVE1;
            case 2:
                return MOVE2;
            case 3:
                return MOVE3;
            case 4:
                return BACKUP;
            case 5:
                return ROTATE_LEFT;
            case 6:
                return ROTATE_RIGTH;
            case 7:
                return UTURN;
            default:
                return null;
        }
    }
}
