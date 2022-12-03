package modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class description: This class represents a word in the tree.
 *
 * @author Weilong Mao, Hoa Le, Chris Wang, Hu Peng
 */
public class Word implements Comparable<Word>, Serializable {

    private String word;
    private List<Integer> lineNumbers;
    private List<String> fileNames;
    private int count;

    public Word(String word, int lineNumber, String fileName) {
        this.word = word;
        this.lineNumbers = new ArrayList<>();
        this.fileNames = new ArrayList<>();
        this.lineNumbers.add(lineNumber);
        this.fileNames.add(fileName);
        this.count = 1;
    }

    public void addCount(int lineNumber, String fileName) {
        this.lineNumbers.add(lineNumber);
        this.fileNames.add(fileName);
        count++;
    }


    public String getWord() {
        return word;
    }

    public List<Integer> getLineNumbers() {
        return lineNumbers;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public int getCount() {
        return count;
    }

    private void setWord(String word) {
        this.word = word;
    }

    private void setLineNumbers(List<Integer> lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    private void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    private void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Word thatWord) {
        return this.word.compareTo(thatWord.getWord());
    }
}
