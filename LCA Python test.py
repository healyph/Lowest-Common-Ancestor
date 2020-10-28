import unittest
import LCA Python

class LCAtest(unittest.TestCase):
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    self.assertEqual(1, LCA Python.findLCA(root, 4, 7))
