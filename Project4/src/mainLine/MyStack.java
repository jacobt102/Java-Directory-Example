package mainLine;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Jacob Turner
 * Project 4
 * Looks at HTML files to determine if tags are balanced (no extra opens or closes) using a stack
 */
public class MyStack<T> implements StackInterface<T>{
    Node topOfStack;
    int size;
    public MyStack(){
        topOfStack = null;
        size = 0;
    }
    public MyStack(T newTop){
        topOfStack = new Node(newTop);
        size++;
    }
    @Override
    public void push(T newEntry) {
        if(newEntry == null){
            throw new IllegalArgumentException();
        }
        Node temp = topOfStack; //Original top of stack
        topOfStack = new Node(newEntry,topOfStack);

        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T returnData = topOfStack.getData();
        topOfStack = topOfStack.next;

        size--;
        return returnData;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return topOfStack.data;
        }
        else{
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmpty() {
        if(topOfStack == null  && size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {
        topOfStack = null;
        size = 0;
    }
    public static boolean isBalanced(File webpage) throws FileNotFoundException {
        MyStack<String> fileStack = new MyStack<String>();
        boolean isBalanced = true;
        Scanner fileReader = new Scanner(webpage);
        if (!webpage.canRead() || !fileReader.hasNext()) {
            throw new IllegalArgumentException("Unable to open the file");
        }
        while(fileReader.hasNextLine()) {
            String line = "";

                line = fileReader.findInLine("<([^>]*)>");


            while(line == null && fileReader.hasNext()){
                fileReader.nextLine();
                line = fileReader.findInLine("<([^>]*)>");

            }
            if(fileStack.isEmpty() && line == null){
                break;
            }
            if(line == null){
                break;
            }
            int openingDelimiter = line.indexOf('<');
            int closingDelimiter = line.indexOf('>');
            //if -1, means delimiter not found
            if (openingDelimiter != -1) {
                //Means tag found is opening
                if (line.charAt(openingDelimiter + 1) != '/') {
                    fileStack.push(line.substring(openingDelimiter, closingDelimiter + 1));
                }
                //tag is closing
                else {
                    StringBuilder newBeginning;
                    try {
                        newBeginning = new StringBuilder(fileStack.peek());
                    }
                    catch (EmptyStackException ex){
                        isBalanced = false;
                        break;
                    }
                    newBeginning.insert(1, '/');
                    if (newBeginning.toString().equals(line.substring(openingDelimiter, closingDelimiter + 1))) {
                        fileStack.pop();
                    } else {
                        isBalanced = false;
                    }
                }
            }
        }
        if(!fileStack.isEmpty()){
            isBalanced = false;
        }
        fileReader.close();
        return isBalanced;
    }
    private class Node
    {
        private T data; // Entry in stack
        private Node next; // Link to nexE node
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        }
        private T getData()
        {
            return data;
        }
        private void setData(T newData)
        {
            data = newData;
        }
        private Node getNextNode()
        {
            return next;
        }
        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//       String line = "<html><body>";
//       String[] sum = line.split(">");

        File file = new File("9malformedtagpage.html");
        System.out.println(isBalanced(file));

    }

}
