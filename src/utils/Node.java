package utils;

public class Node implements Comparable<Object> {

	private Character letter;
	Integer weight;
	Node left;
// Represents a node in the Huffman tree
	Node right;

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
	}

	public Node getRight() {
		return right;
	}

	public Node(Character c, Integer weight) {
		this.setLetter(c);
		this.weight = weight;
	}


// Compare nodes by frequency for priority queue ordering
	@Override
	public int compareTo(Object node2) {
		return weight - ((Node) node2).weight;
	}

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
