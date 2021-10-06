import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Counter {

    public Word getMostPupularWord(String[] words) {
        List<Word> wordsArray = new ArrayList<>();
        wordsArray.add(new Word(words[0]));
        for (int i = 1; i < words.length; i++) {
            boolean dontFindWord = true;
            for(Word oldWord: wordsArray){
                if(oldWord.getName().contains(words[i])){
                    oldWord.addWord();
                    dontFindWord = false;
                    break;
                }
            }
            if(dontFindWord) {
                wordsArray.add(new Word(words[i]));
            }
        }
        List<Word> sortWords = wordsArray.stream().sorted((o1, o2) -> o2.getCount() - o1.getCount())
                .collect(Collectors.toList());

        return sortWords.get(0);
    }

    public double getAvarageSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.averagingDouble(s -> s.getSalary()));
    }

    public void getSeniors(List<Employee> employees, int i) {
        System.out.println(employees.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .map((Function<Employee, String>) worker -> worker.getName())
                .limit(i)
                .collect(Collectors.joining(", ", i + " самых старших сотрудников зовут: ",";")));
    }
}
