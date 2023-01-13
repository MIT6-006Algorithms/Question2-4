import java.util.ArrayList;

public class Porktown {

    ArrayList<House> pt;

    public Porktown(ArrayList<House> pt) {
        this.pt = pt;
    }

    public Porktown(House h) {
        ArrayList<House> list = new ArrayList<House>();
        list = buildArray(list, h);
        this.pt = list;
    }

    public ArrayList<House> buildArray (ArrayList<House> list, House h) {
        if (h.next == null) {
            list.add(h);
            return list;
        } else {
            list.add(h);
            buildArray(list, h.next);
        }
        return list;
    }

    //=========================================================================

    public int printPt(int x) {
        try {
            pt.get(x);
            System.out.println("PT Array at " + x + " = " + pt.get(x).bricks);
            x++;
            printPt(x);
        } catch (IndexOutOfBoundsException e) {
            return 1;
        }
        return 0;
    }

    //=================================================================================

    public ArrayList sort(ArrayList<House> shuffled) {
        ArrayList<House> array1 = new ArrayList();
        ArrayList<House> array2 = new ArrayList();
        int x = shuffled.size() / 2;
        if (x == 0) {
            return shuffled;
        }
        ArrayList<House> sortedArray1 = null;
        for (int i = 0; i < x; i++) {
            array1.add(shuffled.get(i));
            sortedArray1 = sort(array1);
        }
        ArrayList<House> sortedArray2 = null;
        for (int i = x; i < shuffled.size(); i++) {
            array2.add(shuffled.get(i));
            sortedArray2 = sort(array2);
        }
        ArrayList<House> mergedArray = new ArrayList<House>();
        mergedArray = merge(mergedArray, sortedArray1, sortedArray2, 0, 0);

        return mergedArray;
    }

    public ArrayList<House> merge(ArrayList<House> mergedArray, ArrayList<House> sortedArray1, ArrayList<House> sortedArray2, int x, int y) {
        try {
            if (sortedArray1.get(x).bricks < sortedArray2.get(y).bricks) {
                mergedArray.add(sortedArray1.get(x));
                x++;
                merge(mergedArray, sortedArray1, sortedArray2, x, y);
            } else if (sortedArray1.get(x).bricks > sortedArray2.get(y).bricks) {
                mergedArray.add(sortedArray2.get(y));
                y++;
                merge(mergedArray, sortedArray1, sortedArray2, x, y);
            }
        } catch (IndexOutOfBoundsException e) {
            try {
                mergedArray.add(sortedArray1.get(x));
                x++;
                merge(mergedArray, sortedArray1, sortedArray2, x, y);
            } catch (IndexOutOfBoundsException f) {
                try {
                    mergedArray.add(sortedArray2.get(y));
                    y++;
                    merge(mergedArray, sortedArray1, sortedArray2, x, y);
                } catch (IndexOutOfBoundsException g) {
                    return mergedArray;
                }
            }
        }
        return mergedArray;
    }

    public ArrayList check(int b, int x) {
        try {
            pt.get(x);
        } catch (IndexOutOfBoundsException e) {
            return pt;
        }
        if (pt.get(x).bricks <= b) {
            pt.get(x).bricks = 0;
            x++;
            check(b, x);
        } else if (pt.get(x).bricks > b) {
            return pt;
        }
        return pt;
    }

    public void assessDamage(int b) {
        this.pt = sort(this.pt);
        this.pt = check(b, 0);
        printPt(0);
    }

}
