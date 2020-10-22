import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrandSort {
    public ArrayList<Integer> strandSort(ArrayList<Integer> ip, ArrayList<Integer> op) {
        if (ip.isEmpty()) {
            return op;
        }

        ArrayList<Integer> sublist = new ArrayList<Integer>();
        sublist.add(ip.get(0));
        ip.remove(0);

        for (int i = 0; i < ip.size(); i++) {
            if (ip.get(i) > sublist.get(sublist.size() - 1)) {
                sublist.add(ip.get(i));
                ip.remove(i);
                i--;
            }
        }

        op = merge(sublist, op);

        return strandSort(ip, op);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int i, j, k, n1, n2;
        n1 = a.size();
        n2 = b.size();
        i = 0;
        j = 0;
        k = 0;

        while (i < n1 && j < n2) {
            if (a.get(i) <= b.get(j)) {
                result.add(k, a.get(i));
                i++;
            } else {
                result.add(k, b.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            result.add(k, a.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            result.add(k, b.get(j));
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ip = new ArrayList<Integer>(List.of( 10, 5, 30, 40, 2, 4, 9 ));
        ArrayList<Integer> op = new ArrayList<Integer>();
      
        System.out.println("Given array: " + ip);

        StrandSort ss = new StrandSort();
        op = ss.strandSort(ip, op);

        System.out.println("Sorted array: " + op);
    }
}