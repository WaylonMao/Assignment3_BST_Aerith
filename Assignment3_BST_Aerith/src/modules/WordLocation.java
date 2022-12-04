package modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class description:
 *
 * @author Weilong Mao
 */
public class WordLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fileName;
    private List<Integer> lineNumbers;

    public WordLocation(String fileName) {
        this.fileName = fileName;
        this.lineNumbers = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(List<Integer> lineNumbers) {
        this.lineNumbers = lineNumbers;
    }
}

