import java.util.LinkedList;
import java.util.List;

// AvlTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// boolean contains( x )  --> Return true if x is present
// boolean remove( x )    --> Return true if x was present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

public class AvlTree {
	/**
	 * Construct the tree.
	 */
	public AvlTree() {
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	private void insert(String x, int i) {
		root = insert(x, i, root);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * 
	 * @param x
	 *            the item to remove.
	 */
	public void remove(String x) {
		root = remove(x, root);
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x
	 *            the item to remove.
	 * @param t
	 *            the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private AvlNode remove(String x, AvlNode t) {
		if (t == null)
			return t; // Item not found; do nothing

		int compareResult = x.compareTo(t.word);

		if (compareResult < 0)
			t.left = remove(x, t.left);
		else if (compareResult > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) // Two children
		{
			t.word = findMin(t.right).word;
			t.right = remove(t.word, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return balance(t);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public String findMin() {
		if (isEmpty())
			throw new UnderflowException();
		return findMin(root).word;
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item of null if empty.
	 */
	public String findMax() {
		if (isEmpty())
			throw new UnderflowException();
		return findMax(root).word;
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return true if x is found.
	 */
	public boolean contains(String x) {
		return contains(x, root);
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	private void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	private static final int ALLOWED_IMBALANCE = 1;

	// Assume t is either balanced or within one of being balanced
	private AvlNode balance(AvlNode t) {
		if (t == null)
			return t;

		if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
			if (height(t.left.left) >= height(t.left.right))
				t = rotateWithLeftChild(t);
			else
				t = doubleWithLeftChild(t);
		else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
			if (height(t.right.right) >= height(t.right.left))
				t = rotateWithRightChild(t);
			else
				t = doubleWithRightChild(t);

		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	public void checkBalance() {
		checkBalance(root);
	}

	private int checkBalance(AvlNode t) {
		if (t == null)
			return -1;

		if (t != null) {
			int hl = checkBalance(t.left);
			int hr = checkBalance(t.right);
			if (Math.abs(height(t.left) - height(t.right)) > 1 || height(t.left) != hl || height(t.right) != hr)
				System.out.println("OOPS!!");
		}

		return height(t);
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @param t
	 *            the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private AvlNode insert(String x, int index, AvlNode t) {
		if (t == null)
			return new AvlNode(x, index, null, null);

		int compareResult = x.compareTo(t.word);

		if (compareResult < 0)
			t.left = insert(x, index, t.left);
		else if (compareResult > 0)
			t.right = insert(x, index, t.right);
		else
			t.addIndex(index);
		return balance(t);
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	private AvlNode findMin(AvlNode t) {
		if (t == null)
			return t;

		while (t.left != null)
			t = t.left;
		return t;
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private AvlNode findMax(AvlNode t) {
		if (t == null)
			return t;

		while (t.right != null)
			t = t.right;
		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x
	 *            is item to search for.
	 * @param t
	 *            the node that roots the tree.
	 * @return true if x is found in subtree.
	 */
	private boolean contains(String x, AvlNode t) {
		while (t != null) {
			int compareResult = x.compareTo(t.word);

			if (compareResult < 0)
				t = t.left;
			else if (compareResult > 0)
				t = t.right;
			else
				return true; // Match
		}

		return false; // No match
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 */
	private void printTree(AvlNode t) {
		if (t != null) {
			printTree(t.left);
			t.print();
			printTree(t.right);
		}
	}

	/**
	 * Return the height of node t, or -1, if null.
	 */
	private int height(AvlNode t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * Rotate binary tree node with left child. For AVL trees, this is a single
	 * rotation for case 1. Update heights, then return new root.
	 */
	private AvlNode rotateWithLeftChild(AvlNode k2) {
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * Rotate binary tree node with right child. For AVL trees, this is a single
	 * rotation for case 4. Update heights, then return new root.
	 */
	private AvlNode rotateWithRightChild(AvlNode k1) {
		AvlNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child. For AVL trees, this is a double
	 * rotation for case 2. Update heights, then return new root.
	 */
	private AvlNode doubleWithLeftChild(AvlNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child. For AVL trees, this is a double
	 * rotation for case 3. Update heights, then return new root.
	 */
	private AvlNode doubleWithRightChild(AvlNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	private static class AvlNode {
		String word; // The word in the file
		LinkedList<Integer> index = new LinkedList<Integer>(); // The list of
																// lines where
																// the word
																// appears
		AvlNode left; // Left child
		AvlNode right; // Right child
		int height; // Height
		// Constructors

		@SuppressWarnings("unused")
		AvlNode(String nodeWord, int firstIndex) {
			this(nodeWord, firstIndex, null, null);
		}

		public void print() {
			System.out.println("Word: " + word + ". Occurrences: " + index.toString());
		}

		AvlNode(String nodeWord, int firstIndex, AvlNode lt, AvlNode rt) {
			word = nodeWord;
			index.add(firstIndex);
			left = lt;
			right = rt;
			height = 0;
		}

		public void addIndex(int newIndex) {
			if (!index.contains(newIndex))
				index.add(newIndex);
		}
	}

	/** The tree root. */
	private AvlNode root;

	// METHODS ADDED FOR PROBLEM 2
	public void indexWord(String word, int line) {
		insert(word, line);
	}

	public AvlNode findWord(String x) {
		return findWord(x, root);
	}

	private AvlNode findWord(String x, AvlNode t) {
		while (t != null) {
			int compareResult = x.compareTo(t.word);

			if (compareResult < 0)
				t = t.left;
			else if (compareResult > 0)
				t = t.right;
			else
				return t; // Match
		}

		return null; // No match
	}

	public List<Integer> getLinesForWord(String word) {
		word = word.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().trim();
		AvlNode wordNode = findWord(word);
		return wordNode == null ? null : wordNode.index;
	}

	public void printIndex() {
		printTree();
	}
}
