import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("12");
        list1.add("12");
        list1.add("34");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("12");
        list2.add("12");
        list2.add("56");

        // Intersection without Hashset
        Collections.sort(list1);
        Collections.sort(list2);

        ArrayList<String> intersectionList = new ArrayList<>();
        String[] arr1 =  list1.toArray(new String[list1.size()]);
        String[] arr2 = list2.toArray(new String[list2.size()]);

        for(int i=0; i< arr1.length ; i++) {
            for(int j=0 ; j< arr2.length; j++) {
                if(arr1[i].equals(arr2[j])) {
                    intersectionList.add(arr1[i]);
                    arr2[j] = null;
                    break;
                }
            }
        }
        for(String element : intersectionList) {
            System.out.println(element);
        }

        // Union without Hashset
        ArrayList<String> unionList = new ArrayList<>(intersectionList);
        arr2 = list2.toArray(new String[list2.size()]);
        for(int i=0; i< arr1.length ; i++) {
            boolean isIntersect = false;
            for(String element : intersectionList) {
                if(element.equals(arr1[i])) {
                    isIntersect = true;
                    break;
                }
            }
            if(!isIntersect) {
                unionList.add(arr1[i]);
            }
        }

        for(int i=0; i< arr2.length ; i++) {
            boolean isIntersect = false;
            for(String element : intersectionList) {
                if(element.equals(arr2[i])) {
                    isIntersect = true;
                    break;
                }
            }
            if(!isIntersect) {
                unionList.add(arr2[i]);
            }
        }
        System.out.println();
        for(String element : unionList) {
            System.out.println(element);
        }

        // Intersection
        HashSet<String> set1 = new HashSet<>(list1);
        HashSet<String> set2 = new HashSet<>(list2);

        ArrayList<String> result = new ArrayList<>();
        for(String element : list2) {
            if(set1.contains(element)) {
                result.add(element);
            }
        }
        System.out.print("{ ");
        for (String element : result) {
            System.out.print(element+" ");
        }
        System.out.print(" }");

        // Union
        ArrayList<String> result2 = new ArrayList<>(result);

        for(String element : list2) {
            if(!set1.contains(element)) {
                result2.add(element);
            }
        }

        for(String element : list1) {
            if(!set2.contains(element)) {
                result2.add(element);
            }
        }
        System.out.print("{ ");

        for (String element : result2) {
            System.out.print(element +" ");
        }

        System.out.print(" }");
    }
}
