package nlpProject;

import java.util.Map.Entry;

public interface Comparator<Integer> {

	int compare(Entry<String, Integer> o1, Entry<String, Integer> o2);

}
