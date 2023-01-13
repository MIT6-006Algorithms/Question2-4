import java.util.ArrayList;
import java.util.Arrays;

public class question {
    public static void main(String[] args) {

        House e1001 = new House(34);
        House e1002 = new House(57);
        House e1003 = new House(70);
        House e1004 = new House(19);
        House e1005 = new House(48);
        House e1006 = new House(2);
        House e1007 = new House(94);
        House e1008 = new House(7);


        e1001.next = e1002;
        e1002.next = e1003;
        e1003.next = e1004;
        e1004.next = e1005;
        e1005.next = e1006;
        e1006.next = e1007;
        e1007.next = e1008;

        Porktown porktown = new Porktown(e1001);

        int b = (int) (Math.random() * 100);

    //print b
        System.out.println("b = " + b);

    //print initial set up of porktown
        System.out.println("Linked List = " + e1001.printList(0));

        porktown.assessDamage(b);

        System.out.println("Linked List = " + e1001.printList(0));


    }
}
