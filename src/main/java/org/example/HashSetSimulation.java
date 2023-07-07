package org.example;

import java.util.ArrayList;
import java.util.List;

public class HashSetSimulation {
    private List<Integer> set;

    public HashSetSimulation() {
        set = new ArrayList<>();
    }

    public void add(int element) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }

    public String toString() {
        return set.toString();
    }

    public int getElementByIndex(int index) {
        if (index >= 0 && index < set.size()) {
            return set.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public static void main(String[] args) {
        HashSetSimulation setSim = new HashSetSimulation();
        setSim.add(1);
        setSim.add(2);
        setSim.add(3);
        System.out.println(setSim.toString());
        System.out.println(setSim.getElementByIndex(1));
    }
}
