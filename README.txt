Program Name: Binary Search Trees and Serialization

Introduction:

DATE: 28th Nov, 2022

Author: Weilong Mao, Hoa Le, Chris Wang, Hu Peng

The program accepts the user's input to the text file and generates a word object of the binary tree, which is serialized into the repository.ser file.
Users can choose three ways to print information:

- -pf to print in alphabetic order all words along with the corresponding list of files in which
the words occur.
- -pl to print in alphabetic order all words along with the corresponding list of files and
numbers of the lines in which the word occur.
- -po to print in alphabetic order all words along with the corresponding list of files,
numbers of the lines in which the word occur and the frequency of occurrence of the
words.

How to run this program:
Open command line on the WordTracker.jar folder.
It needs three parameters: the input file path, the processing type, and the output file path
Example:
java -jar WordTracker.jar textfile.txt -pf -f output.txt
java -jar WordTracker.jar textfile.txt -pl -f output.txt
java -jar WordTracker.jar textfile.txt -po -f output.txt


