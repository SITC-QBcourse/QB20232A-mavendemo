import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		var list1 = Arrays.asList(1,5,3,4,2);
		var list2 = List.of(1,2,3,4,5);
		
		var list3 = new ArrayList<>(Arrays.asList(1,5,3,4,2));
		list3.add(555);
	}
}
