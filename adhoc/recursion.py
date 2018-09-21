from tree_node import TreeNode
from traversal import stringToTreeNode

import sys
import json

from collections import deque


class Recursion:

    answer = 0

    def maximum_depth_top(self, root, depth):
        if not root:
            return
        if not root.left and not root.right:
            self.answer = max(self.answer, depth)
        self.maximum_depth_top(root.left, depth + 1)
        self.maximum_depth_top(root.right, depth + 1)

    def maximum_depth_bottom(self, root):
        if not root:
            return 0
        left_depth = self.maximum_depth_bottom(root.left)
        right_depth = self.maximum_depth_bottom(root.right)
        return max(left_depth, right_depth) + 1

    def isSymmetric(self, root):

        if root is None:
            return True
        else:
            return self.isMirror(root.left, root.right)

    def isMirror(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val == right.val:
            outerPair = self.isMirror(left.left, right.right)
            innerPair = self.isMirror(left.right, right.left)
            return outerPair and innerPair
        else:
            return False

    def isSymmetricIterative(self, root):

        if root is None:
            return True

        stack = deque()
        stack.append((root.left, root.right))

        while len(stack) > 0:
            pair = stack.pop()
            left, right = pair

            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val == right.val:
                stack.append((left.left, right.right))
                stack.append((left.right, right.left))
            else:
                return False
        return True

    def hasPathSum(self, root, sum):
        if root is None:
            return False

        stack = deque()
        total = 0
        stack.append((root, root.val))

        while len(stack) > 0:
            node, total = stack.pop()
            if total == sum and node.left is None and node.right is None:
                return True

            if node.left is not None:
                stack.append((node.left, node.left.val + total))
            if node.right is not None:
                stack.append((node.right, node.right.val + total))
        return False


def readlines():
    for line in sys.stdin:
        yield line.strip('\n')


def stringToList(input):
    return json.loads(input)

if __name__ == '__main__':
    lines = readlines()
    line = next(lines)

    root = stringToTreeNode(line)

    r = Recursion()

    # r.maximum_depth_top(root, 0)
    # print(r.answer)

    # print(r.maximum_depth_bottom(root))

    # print(r.isSymmetric(root))
    # print(r.isSymmetricIterative(root))

    print("Enter sum: ")
    line = next(lines)
    line = line.strip()
    print(r.hasPathSum(root, int(line)))
