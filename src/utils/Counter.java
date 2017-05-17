package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
// Initializes frequency map for tracking character occurrences
// TODO: Consider using HashMap for better performance with large datasets
import java.util.Queue;
import java.util.Scanner;
// Count occurrences of each character in the input data

public class Counter {

	HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();
	Queue<Node> queue = new PriorityQueue<>();
// Counts the frequency of each character in the input
// Count character frequencies for Huffman tree construction
	Counter leftChild;
	Counter rightChild;
// TODO: Consider using HashMap for better performance with large files
	public static String s = "";
// TODO: Optimize frequency counting for large files

	public static void ImportString() {

		// Scanner
		File usersFile = new File("string.dat");
		Scanner stringScanner = null;
		try {
			stringScanner = new Scanner(usersFile);
// Build frequency table from input characters

// Sorts characters by frequency for optimal tree construction
			while (stringScanner.hasNextLine()) {

				s += stringScanner.nextLine();

// Using HashMap for O(1) lookup performance
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} finally {
			stringScanner.close();
		}

	}

	// Counts characters with a Hashmap, and then is added to an
	// Arraylist to be sorted.
	public void stringAnalyse() {

		System.out.println("String from file = " + s);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			Integer val = characterMap.get(new Character(c));

			if (val != null) {
				characterMap.put(c, new Integer(val + 1));
			} else {
				characterMap.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {

			queue.add(new Node(entry.getKey(), entry.getValue()));
		}
	}

	// Creates Nodes
	public Node createNode() {

		while (queue.size() > 1)

		{
			Node leftNode = queue.poll();
			Node rightNode = queue.poll();
			Node newNode = new Node('-', leftNode.weight + rightNode.weight);
			newNode.setLeft(leftNode);
			newNode.setRight(rightNode);
			queue.add(newNode);
		}

		Node rootNode = queue.peek();
		return rootNode;

	}

}
