package codeofli.leetcode.everyday.tree;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

public class Intersect558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null || quadTree2 == null) {
            return null;
        }
        if (quadTree1.isLeaf && quadTree2.isLeaf) { //都为叶子结点
            return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
        } else if (!quadTree1.isLeaf && !quadTree2.isLeaf) { //都不为叶子结点
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&  // 全为叶子结点
                    topLeft.val == topRight.val && bottomLeft.val == bottomRight.val && topLeft.val == bottomLeft.val) { //并且值相同
                return new Node(topLeft.val, true, null, null, null, null);
            }
            //val[0,1]任意值
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        } else { // 其中有一个为叶子结点
            Node leftNode, notLeftNode;
            if (quadTree1.isLeaf) {
                leftNode = quadTree1;
                notLeftNode = quadTree2;
            } else {
                leftNode = quadTree2;
                notLeftNode = quadTree1;
            }
            if (leftNode.val) { // 全true | 其他 == 全true
                return new Node(true, true, null, null, null, null);
            } else {  // 全false | 其他 == 其他
                //val[0,1]任意值
                return new Node(false, false, notLeftNode.topLeft, notLeftNode.topRight, notLeftNode.bottomLeft, notLeftNode.bottomRight);
            }
        }
    }
}
