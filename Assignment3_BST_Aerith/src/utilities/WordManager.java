package utilities;

import java.io.Serializable;

public class WordManager implements Comparable<WordManager>, Serializable {
    private int linePosition;
    private String fileName;
    private String word;

    public WordManager(String word) {
        this.word = word;
    }

    public WordManager(int linePosition, String fileName, String word) {
        this.linePosition = linePosition;
        this.fileName = fileName;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public void setLinePosition(int linePosition) {
        this.linePosition = linePosition;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(WordManager o) {
        return  this.word.compareTo(o.getWord());
    }

    @Override
    public String toString() {
        return "WordManager{" +
                "linePosition=" + linePosition +
                ", fileName='" + fileName + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}


