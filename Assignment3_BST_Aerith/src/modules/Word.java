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
    private List<WordLocation> wordLocations;
    private int count;

    public Word(String word) {
        this.word = word;
        this.wordLocations = new ArrayList<>();
        count = 0;
    }

    public void addCount(int lineNumber, String fileName) {
        if(wordLocations.size() == 0) {
            WordLocation wl = new WordLocation(fileName);
            wl.getLineNumbers().add(lineNumber);
            wordLocations.add(wl);
        } else {
            for(WordLocation wl : wordLocations) {
                if(wl.getFileName().equals(fileName)) {
                    if(!wl.getLineNumbers().contains(lineNumber)) {
                        wl.getLineNumbers().add(lineNumber);
                        count++;
                    }
                    return;
                }
            }
            WordLocation wl = new WordLocation(fileName);
            wl.getLineNumbers().add(lineNumber);
            wordLocations.add(wl);
        }
        count++;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<WordLocation> getWordLocations() {
        return wordLocations;
    }

    public void setWordLocations(List<WordLocation> wordLocations) {
        this.wordLocations = wordLocations;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Word thatWord) {
        return this.word.compareTo(thatWord.getWord());
    }
}
