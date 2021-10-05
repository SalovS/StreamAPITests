public class Word{
    private String name;
    private int count;

    Word(String name){
        this.name = name;
        count = 1;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void addWord() {
        this.count ++;
    }
}