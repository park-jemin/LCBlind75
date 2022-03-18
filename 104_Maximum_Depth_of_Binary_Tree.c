// https://leetcode.com/problems/maximum-depth-of-binary-tree/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

// v1

int depth(struct TreeNode* node, int level) {
    if (!node)
        return level;
    
    int leftDepth = depth(node->left, level + 1);
    int rightDepth = depth(node->right, level + 1);
    return leftDepth > rightDepth ? leftDepth : rightDepth;
    
}

int maxDepth(struct TreeNode* root){
    return depth(root, 0);
}




// v2

int maxDepth(struct TreeNode* root){
    if (root == NULL)
        return 0;
    
    int l_depth = maxDepth(root->left);
    int r_depth = maxDepth(root->right);
    return 1 + (l_depth > r_depth ? l_depth : r_depth);
}