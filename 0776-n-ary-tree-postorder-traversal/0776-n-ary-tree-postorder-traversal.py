"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []

        res = []

        def dfs(root):
            for x in root.children:
                dfs(x)
            res.append(root.val)

        dfs(root)

        return res
