Program Name: Binary Search Trees and Serialization

Introduction:

The program accepts the user's input on command line and read information from the text file and generate a word object
of the binary tree, which is serialized into the repository.ser file. The program will be stored in a list for each word
object stored in the BST. The program will also produce output, specified by the user at command line, to generate reports
using a variety of iterators built into the BST

DATE: 28th Nov, 2022

Author: Weilong Mao, Hoa Le, Chris Wang, Hu Peng


Users can choose three ways to retrieve information:

1. -pf to print in alphabetic order all words along with the corresponding list of files in which
the words occur.
2. -pl to print in alphabetic order all words along with the corresponding list of files and
numbers of the lines in which the word occur.
3. -po to print in alphabetic order all words along with the corresponding list of files,
numbers of the lines in which the word occur and the frequency of occurrence of the
words.

How to run this program:

Open command line on the WordTracker.jar folder.
It needs three parameters: the input file path, the processing type, and the output file path
Example:
java -jar WordTracker.jar "C:\cprg311\textfile.txt" -pf -f "C:\cprg311\output.txt"
java -jar WordTracker.jar "C:\cprg311\textfile.txt" -pl -f "C:\cprg311\output.txt"
java -jar WordTracker.jar "C:\cprg311\textfile.txt" -po -f "C:\cprg311\output.txt"


