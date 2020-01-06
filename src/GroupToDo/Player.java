package GroupToDo;

public class Player {
    private int points = 0;
    private String name;
    public static int count;

    public Player(String name) {
        count++;
        this.name = name;
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void roll(){
        points += (int)((Math.random() * 6) + 1);
    }

    @Override
    public String toString() {
        return name + " with " + points + " points.";
    }
}
