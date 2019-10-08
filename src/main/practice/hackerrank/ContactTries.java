package main.practice.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ContactTries {
    private static final Scanner scanner = new Scanner(System.in);
    private Node rootNode = new Node();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ContactTries contactTries = new ContactTries();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];

            if("add".equalsIgnoreCase(op)){
                contactTries.addWord(contact);
            }else if("find".equalsIgnoreCase(op)){
                System.out.println(contactTries.findSize(contact));
            }
        }

        scanner.close();
    }

    private void addWord(String word){
        char[] characters = word.toCharArray();
        Node parentNode = rootNode;
        for(int i = 0; i < characters.length; i++){
            parentNode.addCharacterNode(characters[i]);
            parentNode = parentNode.getCharacterNode(characters[i]);
            parentNode.size++;
        }

        parentNode.setIsTerminal();
    }

    private int findSize(String searchString){
        Node parentNode = rootNode;

        for(char ch : searchString.toCharArray()){
            if(parentNode.getCharacterNode(ch) == null){
                return 0;
            }

            parentNode = parentNode.getCharacterNode(ch);
        }

        return parentNode.size;
    }

    private int findWords(String search){
        char[] characters = search.toCharArray();

        int count = 0;
        Node node = getLastValidNode(characters);
        if(node != null){
            Stack<Node> stackedNodes = new Stack<>();
            stackedNodes.push(node);

            while(!stackedNodes.isEmpty()){
                Node n = stackedNodes.pop();
                pushNodesToStack(n, stackedNodes);
                if(n.isTerminal()){
                    count++;
                    continue;
                }
            }
        }
        return count;
    }

    private void pushNodesToStack(Node node, Stack<Node> stackedNodes){
        for(Map.Entry<Character, Node> entry : node.getCharacterMap().entrySet()){
            stackedNodes.push(entry.getValue());
        }
    }

    private Node getLastValidNode(char[] characters){
        Node parentNode = rootNode;
        Node previousNode = parentNode;
        for(int i = 0; i < characters.length; i++){
            Node node = parentNode.getCharacterNode(characters[i]);
            if(node == null){
                return null;
            }
            previousNode = parentNode;
            parentNode = node;
        }

        return previousNode;
    }

    class Node{
        private HashMap<Character, Node> characterMap;
        private boolean isTerminal;
        private int size;

        public Node(){
            this.characterMap = new HashMap<>();
            this.isTerminal = false;
            this.size = 0;
        }

        public void addCharacterNode(Character character){
            characterMap.putIfAbsent(character, new Node());
        }

        public Node getCharacterNode(Character character){
            return characterMap.get(character);
        }

        public HashMap<Character, Node> getCharacterMap(){
            return characterMap;
        }

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setIsTerminal() {
            this.isTerminal = true;
        }
    }
}