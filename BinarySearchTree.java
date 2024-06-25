package nazansonal211805027data;
import java.util.Scanner;
class Node {
    String word;
    String turkishEquivalent;
    String meaning;
    Node left;
    Node right;
    
    Node(String word, String turkishEquivalent, String meaning) {
        this.word = word;
        this.turkishEquivalent = turkishEquivalent;
        this.meaning = meaning;
        left = null;
        right = null;
    }
}
class BinarySearchTree{
    Node root;
    BinarySearchTree(){
        root = null;
    }
    void insert(String word, String turkishEquivalent, String meaning){
        root = insertRecursive(root, word, turkishEquivalent, meaning);
    }
    Node insertRecursive(Node root, String word, String turkishEquivalent, String meaning){
        if (root == null) {
            root = new Node(word, turkishEquivalent, meaning);
            return root;
        }

        if (word.compareTo(root.word) < 0){
            root.left = insertRecursive(root.left, word, turkishEquivalent, meaning);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insertRecursive(root.right, word, turkishEquivalent, meaning);
        }
return root;
    }
    void inorder() {
        inorderRecursive(root);
    }
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println("Word                :" + root.word + "\nTurkish Equivalent  :" + root.turkishEquivalent + "\nMeaning             :" + root.meaning);
            inorderRecursive(root.right);
}
    }
    void postorder() {
        postorderRecursive(root);
    }
    void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.println("Word                :" + root.word + "\nTurkish Equivalent  :" + root.turkishEquivalent + "\nMeaning             :" + root.meaning);
        }
    }
    void preorder() {
        preorderRecursive(root);
    }
    void preorderRecursive(Node root) {
        if (root != null) {
        	System.out.println("Word                :" + root.word + "\nTurkish Equivalent  :" + root.turkishEquivalent + "\nMeaning             :" + root.meaning);
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
    Node search(String word) {
        return searchRecursive(root, word);
    }
    Node searchRecursive(Node root, String word) {
        if (root == null || root.word.equals(word)) {
            return root;
        }
        if (word.compareTo(root.word) < 0) {
            return searchRecursive(root.left, word);
        }
        return searchRecursive(root.right, word);
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        tree.insert("large", "büyük", "geniş, eni çok olan");
        tree.insert("false", "yanlış", "bir kurala bir ilkeye bir gerçeğe uymama durumu");
        tree.insert("set off", "tetiklemek", "harekete geçirmek");
        tree.insert("carry on", "sürdürmek", "devam ettirmek");
        tree.insert("look after", "bakmak", "göz kulak olmak");
        tree.insert("break down", "bozulmak", "bozma işine konu olmak");
        tree.insert("temporal", "geçici", "kısa ve belli bir süre için olan");
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Insert a new node");
            System.out.println("2. Search for a word");
            System.out.println("3. Print in-order");
            System.out.println("4. Print post-order");
            System.out.println("5. Print pre-order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

        switch (choice){
                case 1:
                    System.out.print("Enter word: ");
                    String neword = scanner.nextLine();
                    System.out.print("Enter Turkish equivalent: ");
                    String newturkish = scanner.nextLine();
                    System.out.print("Enter meaning: ");
                    String newmeaning = scanner.nextLine();
                    tree.insert(neword, newturkish, newmeaning);
                    break;
                case 2:
                    System.out.print("Enter word to search: ");
                    String searchword = scanner.nextLine();
                    Node result = tree.search(searchword);
                    if (result != null) {
                        System.out.println("Word: " + result.word + "\nTurkish Equivalent: " + result.turkishEquivalent + "\nMeaning: " + result.meaning);
                    } else {
                        System.out.println("Word not found in the binary search tree");
                    }
                    break;
                 case 3: 
                    System.out.println("\nPrinting in-order:");
                    tree.inorder();
                    break;
                 case 4:
                    System.out.println("\nPrinting post-order:");
                    tree.postorder();
                    break;
                 case 5:
                    System.out.println("\nPrinting pre-order:");
                    tree.preorder();
                    break;
                 case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}

