package com.pratik.playground;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = populateNodeList(root, p);
        List<TreeNode> qPath = populateNodeList(root, q);
        System.out.println("pPath" + pPath);
        System.out.println("qPath" + qPath);
        if (pPath == null || qPath == null) {
            return null;
        }
        Iterator<TreeNode> pIter = pPath.iterator();
        Iterator<TreeNode> qIter = qPath.iterator();
        //Preconditions.checkState(pIter.hasNext());
        //Preconditions.checkState(qIter.hasNext());
        TreeNode previous = pIter.next();
        if (!previous.equals(qIter.next())) {
            return null;
        }
        //Preconditions.checkState(previous.equals(qIter.next()));

        while (pIter.hasNext() && qIter.hasNext()) {
            TreeNode left = pIter.next();
            TreeNode right = qIter.next();
            if (!left.equals(right)) {
                return previous;
            }
            previous = left;
        }
        return previous;
    }

    private List<TreeNode> populateNodeList(TreeNode currNode, TreeNode targetNode) {
        List<TreeNode> result, leftPath, rightPath;
        if (currNode == null) {
            return null;
        }
        if (currNode.equals(targetNode)) {
            result = new LinkedList<>();
            result.add(currNode);
            return result;
        }
        leftPath = populateNodeList(currNode.left, targetNode);
        rightPath = populateNodeList(currNode.right, targetNode);
        if (leftPath != null) {
            result = leftPath;
        } else if (rightPath != null) {
            result = rightPath;
        } else {
            return null;
        }
        result.add(0, currNode);
        return result;
    }
}
