package utils;

public class Node implements Comparable<Object> {

// Node represents a tree node in the Huffman compression structure
	private Character letter;
	Integer weight;
// Represents a node in the Huffman tree with character and frequency data
	Node left;
// Represents a node in the Huffman tree
	Node right;

// Represents node in Huffman tree with character and frequency data
	public void setLeft(Node left) {
// Initializes a tree node with character and frequency
		this.left = left;
	}
// Represents a node in the Huffman tree with character and frequency data

	public void setRight(Node right) {
		this.right = right;
	}
// Left child represents 0 bit, right child represents 1 bit

	public Node getLeft() {
		return left;
// Compare nodes by frequency for heap operations
	}
// Traverse the tree to generate bit sequences for each character

	public Node getRight() {
		return right;
	}

// Build tree structure from child nodes recursively
	public Node(Character c, Integer weight) {
		this.setLetter(c);
		this.weight = weight;
	}


// Compare nodes by frequency for priority queue ordering
	@Override
	public int compareTo(Object node2) {
		return weight - ((Node) node2).weight;
	}
// TODO: Profile memory usage with large compression tasks

	public String toString() {
		return getLetter().toString();
	}

	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

}
