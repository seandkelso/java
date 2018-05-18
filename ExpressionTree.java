import java.util.NoSuchElementException;

public class ExpressionTree {
	private ExpressionNode treeRoot;

	public ExpressionTree(String expressionStr) {
		// create a new expression tree
		try {
			this.treeRoot = constructTree(expressionStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.treeRoot = new ExpressionNode(null);
		}
	}

	public int eval() {
		if (treeRoot.nodeString == null) {
			System.out.println("Can't evaluate invalid expression!");
			return -1;
		}
		return treeRoot.eval();
	}

	public String postfix() {
		return treeRoot.nodeString == null ? "Can't generate postfix for invalid expression!" : postfix(treeRoot);
	}

	private String postfix(ExpressionNode root) {
		if (root == null)
			return "";
		if (root.left == null && root.right == null)
			return root.toString();
		return postfix(root.left) + " " + postfix(root.right) + " " + root.toString();
	}

	public String prefix() {
		return treeRoot.nodeString == null ? "Can't generate prefix for invalid expression!" : prefix(treeRoot);
	}

	private String prefix(ExpressionNode root) {
		if (root == null)
			return "";
		if (root.left == null && root.right == null)
			return root.toString();
		return root.toString() + " " + prefix(root.left) + " " + prefix(root.right);
	}

	public String infix() {
		return treeRoot.nodeString == null ? "Can't generate infix for invalid expression!" : infix(treeRoot);
	}

	private String infix(ExpressionNode root) {
		if (root == null)
			return "";
		if (root.left == null && root.right == null)
			return root.toString();
		return "(" + infix(root.left) + " " + root.toString() + " " + infix(root.right) + ")";
	}

	private ExpressionNode constructTree(String expressionStr) throws Exception {
		// first get all the tokens and initialize the auxilliary stack
		String[] tokens = expressionStr.split(" ");
		MyStack<ExpressionNode> parseStack = new MyStack<>();
		// iterate through tokens
		for (String token : tokens) {
			if (token.length() > 1 || ((int) token.charAt(0) > 47 && (int) token.charAt(0) < 58))
				// token is a number, just push it to the stack
				parseStack.push(new ExpressionNode(token));
			else {
				// token is an operator, pop twice to get its arguments, catch
				// error
				try {
					parseStack.push(new ExpressionNode(token, parseStack.pop(), parseStack.pop()));
				} catch (NoSuchElementException e) {
					throw new Exception("Invalid expression string!");
				}
			}
		}
		if (parseStack.size() != 1)
			throw new Exception("Invalid expression string!");
		else
			return parseStack.pop();
	}

	public static class ExpressionNode {
		private char operator;
		private int operand;
		private String nodeString;
		private ExpressionNode left;
		private ExpressionNode right;

		public ExpressionNode(String operand) {
			this.operand = operand == null ? 0 : Integer.parseInt(operand);
			this.nodeString = operand;
		}

		public ExpressionNode(String operator, ExpressionNode right, ExpressionNode left) {
			this.operator = operator.charAt(0);
			this.left = left;
			this.right = right;
			this.nodeString = operator;
		}

		private int eval() {
			if (left == null && right == null)
				return operand;
			else
				switch (operator) {
				case '+':
					return left.eval() + right.eval();
				case '-':
					return left.eval() - right.eval();
				case '*':
					return left.eval() * right.eval();
				case '/':
					return left.eval() / right.eval();
				default:
					return 0;
				}
		}

		public String toString() {
			return nodeString;
		}
	}
}
