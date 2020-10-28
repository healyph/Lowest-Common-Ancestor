import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommonAncestorTest {

	@Test
	void test() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		assertEquals(3, tree.findLCA(7,3));
		assertEquals(1, tree.findLCA(6,2));
		assertEquals(1, tree.findLCA(3,4));
		assertEquals(2, tree.findLCA(2,5));
	}

}
