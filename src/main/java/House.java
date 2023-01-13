import java.util.ArrayList;

public class House<h> {

    Integer bricks;
    House next;

    public House(Integer bricks) {
        this.bricks = bricks;
    }

    public int printList(int x) {
        System.out.println("LL at " + x + " = " + bricks);
        if (next == null) {
            return 1;
        } else {
            x++;
            next.printList(x);
        }
        return 0;
    }
}
