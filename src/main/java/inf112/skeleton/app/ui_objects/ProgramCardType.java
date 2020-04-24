package inf112.skeleton.app.ui_objects;

public enum ProgramCardType {
    MOVE1("src/main/java/inf112/skeleton/app/assets/sprites/move1.png"), MOVE2("src/main/java/inf112/skeleton/app/assets/sprites/move2.png"),
    MOVE3("src/main/java/inf112/skeleton/app/assets/sprites/move3.png"), BACKUP("src/main/java/inf112/skeleton/app/assets/sprites/backup.png"),
    ROTATE_LEFT("src/main/java/inf112/skeleton/app/assets/sprites/rotateleft.png"), ROTATE_RIGTH("src/main/java/inf112/skeleton/app/assets/sprites/rotateright.png"),
    UTURN("src/main/java/inf112/skeleton/app/assets/sprites/uturn.png");

    public final String src;

    ProgramCardType(String src) {
        this.src = src;
    }

}

// "src/main/java/inf112/skeleton/app/assets/sprites/5.png"
