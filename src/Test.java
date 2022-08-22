import java.util.ArrayList;

public class Test {

public static void main(String[] args) {

ArrayList<Integer>[] arr = new ArrayList[5];


for (int i = 0, j = 2; i < 5; i++, j *= 2) {

arr[i] = new ArrayList<Integer>();


for (int k = 0; k < j; k++) {

arr[i].add(k);

}

}

for (int i = 0; i < arr.length; i++) {

System.out.printf("%d ", arr[i].size());

}

}

}