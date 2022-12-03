package application;

import exceptions.TreeException;
import utilities.BSTree;
import utilities.Iterator;
import modules.Word;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

/**
 * Class description: test arguments: "res/textfile.txt" -po
 *
 * @author
 */

public class WordTracker {
    private static String fileOutputName;
    private static String fileInputName;
    private static String userOption;
    static final File REPOSITORY_FILE = new File("ser/repository.ser");

    public static void main(String[] args) {
        //create new binary file to store words if it does not exist

        BSTree<Word> wordTree = new BSTree<>();


        // use scanner to read txt file
        try {
            new WordTracker().parseArgs(args); // pass the arguments to the method

            Scanner sc = new Scanner(new File(fileInputName));
            int lineCount = 0; // count the line number

             // read from repository binary file,if it doesn't exist, create a new one
             try {
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE));
             ois.close();
             } catch (FileNotFoundException ex) {// when the repository file doesn't exist, create a new one
             wordTree = new BSTree<>();
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE));
             oos.writeObject(wordTree); // write the new tree to the repository file
             oos.close();
             }
             // when the repository file exists, read the tree from the repository and restore a tree



             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REPOSITORY_FILE));
             wordTree = (BSTree<Word>) ois.readObject();
             ois.close();

             // when user choose the output option, output the repository file
             if (fileOutputName != null) {

             PrintStream out = new PrintStream(fileOutputName);
             System.setOut(out);
             }

            // find the word in the input file, if it is a new word, add it to the node of binary tree. Otherwise, add the line number to the node
            while (sc.hasNextLine()) {
                lineCount++;
                String line = sc.nextLine().trim();
                for (int i = 0; i < line.length(); i++) {
                    if (!Character.isLetter(line.charAt(i)) && !Character.isWhitespace(line.charAt(i))) {
                        line = line.replaceAll("\\s", " ");
                       line = line.replace(line.charAt(i) + "", " ");
                    }
                }
                for (String word : line.split("\\s")) {
                    Word addWord = new Word(word, lineCount, fileInputName);
                    if (wordTree.isEmpty() || wordTree.search(addWord) == null) {
                        wordTree.add(addWord);
                        //System.out.println("A word " + addWord.getWord() + " at line number " + addWord.getLineNumbers() + " is added to a Tree");

                    } else {
                        wordTree.search(addWord).getElement().addCount(lineCount, fileInputName);
                       // System.out.println("A word " + addWord.getWord() + " :is already stored in the tree");
                    }
                }
            }
            // write the binary tree to the repository file in pre-order traversal
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE));
            oos.writeObject(wordTree);
            oos.close();



            System.out.println("The number of words in the file is " + wordTree.size());
            sc.hasNextLine();
            // Iterate through the tree and print out the words and their records
            Iterator<Word> iterator = wordTree.inorderIterator();
            while (iterator.hasNext()) {
                Word word = iterator.next();
                System.out.println(word.getWord());
                List<String> fileNames = word.getFileNames();
                List<Integer> lineNumbers = word.getLineNumbers();
                System.out.println("A word "+ word.getWord() + " on line " + word.getLineNumbers());


                if (userOption.equals("f")) {
                    for (int i = 0; i < fileNames.size(); i++) {
                        System.out.println("File name: " + fileNames.get(i).substring(fileNames.get(i).indexOf("/")  + 1) );
                        //System.out.println(fileNames.get(i).indexOf("/"));
                    }
                } else if (userOption.equals("l")) {
                    for (int i = 0; i < fileNames.size(); i++) {
                        System.out.println("File name: " + fileNames.get(i).substring(fileNames.get(i).indexOf("/")  + 1)   );
                    }
                } else if (userOption.equals("o")) {
                    for (int i = 0; i < fileNames.size(); i++) {
                        System.out.println("File name: " + fileNames.get(i).substring(fileNames.get(i).indexOf("/")  + 1)  );
                    }
                    System.out.println("Occurrence: " + word.getCount());
                }
            }
        } catch (IOException | TreeException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseArgs(String[] args) {
        if (args.length == 0 || args.length > 3 || args.length < 2)
            System.out.println("There were errors on the arguments");
        else {
            for (int i = 0; i < args.length; i++) {
                // when the file start with -f, the rest of the string is the file name
                if (args[i].toLowerCase().substring(0, 2).equals("-f")) {
                    fileOutputName = args[i].substring(2); // get the output file name
                    System.out.println("Output file name is: " + fileOutputName);
                    // when the file start with -p, the rest of the string is the option from user
                } else if (args[i].toLowerCase().substring(0, 2).equals("-p") && args[i].length() == 3) {
                    userOption = args[i].substring(2); // get the input file name
                    System.out.println("User option is: " + userOption + " ");
                } else {
                    fileInputName = args[i];
                    System.out.println("Input file name is: " + fileInputName);
                }
            }

        }

    }
}
