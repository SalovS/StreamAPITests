import java.util.*;
import java.util.stream.Collectors;

public class Counter {

    public String getMostPupularWord(String[] words) {
        Map<String, Integer> wordsArr = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            if(wordsArr.containsKey(words[i])){
                wordsArr.put(words[i], wordsArr.get(words[i]) + 1);
            }else{
                wordsArr.put(words[i], 1);
            }
        }

        return wordsArr.entrySet().stream()
                .sorted((word1, word2) -> word2.getValue() - word1.getValue())
                .map(word -> word.getKey())
                .filter(o1 -> o1.length() > 1)
                .limit(1)
                .collect(Collectors.toList())
                .toString()
                .replace('[',' ')
                .replace(']',' ')
                .trim();
    }

    public double getAvarageSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.averagingDouble(s -> s.getSalary()));
    }

    public void getSeniors(List<Employee> employees, int i) {
        System.out.println(employees.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .map(worker -> worker.getName())
                .limit(i)
                .collect(Collectors.joining(", ", i + " самых старших сотрудников зовут: ",";")));
    }
}
