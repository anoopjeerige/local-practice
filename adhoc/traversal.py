from collections import deque
import sys
from tree_node import TreeNode


class Traversal:

    def preorderTraversal(self, root):
        """
        Pre order - root, left, right
        """
        result = []
        current = root
        stack = deque()

        while current or len(stack) != 0:
            if current:
                stack.appendleft(current)
                result.append(current.val)  # Add before going to children
                current = current.left
            else:
                temp = stack.popleft()
                current = temp.right

        return result

    def inorderTraversal(self, root):
        """
        Inorder - left, root, right
        """
        result = []
        current = root
        stack = deque()

        while current or len(stack) != 0:
            if current:
                stack.appendleft(current)
                current = current.left
            else:
                temp = stack.popleft()
                result.append(temp.val)
                current = temp.right

        return result

    def postorderTraversal(self, root):
        """
        Post order traversal
        :type root : TreeNode
        :rtype : List[int]
        """
        # Post order - left, right, root
        result = deque()
        current = root
        stack = deque()

        while current or len(stack) != 0:
            if current:
                stack.appendleft(current)
                result.appendleft(current.val)  # reverse preorder
                current = current.right  # reverse preorder
            else:
                temp = stack.popleft()
                current = temp.left  # reverse preorder

        return list(result)


def stringToTreeNode(input):

    # Trim trailing and leading whitespaces
    input = input.strip()
    # Remove list brackets
    input = input[1:-1]
    # Split the input
    parts = input.split(',')

    queue = deque()

    root = parts[0]
    root = root.strip()
    root = TreeNode(int(root))

    queue.append(root)
    index = 1

    while len(queue) != 0:

        node = queue.popleft()

        if index == len(parts):
            break

        leftchild = parts[index]
        leftchild = leftchild.strip()
        index += 1
        if leftchild != "null":

            leftchild = TreeNode(int(leftchild))

            node.left = leftchild
            queue.append(leftchild)

        if index == len(parts):
            break

        rightchild = parts[index]
        rightchild = rightchild.strip()
        index += 1
        if rightchild != "null":

            rightchild = TreeNode(int(rightchild))

            node.right = rightchild
            queue.append(rightchild)

    return root


def readlines():
    """
    Generator to read user input
    """
    for line in sys.stdin:
        yield line.strip('\n')


def listToString(input):
    return json.dumps(input)


if __name__ == '__main__':

    lines = readlines()
    line = next(lines)

    node = stringToTreeNode(line)
    print("Given {}".format(line))
    print("Preorder {}".format(Traversal().preorderTraversal(node)))
    print("Inorder {}".format(Traversal().inorderTraversal(node)))
    print("Postorder {}".format(Traversal().postorderTraversal(node)))
