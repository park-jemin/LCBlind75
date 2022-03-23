// https://leetcode.com/problems/same-tree/
// 100. Same Tree


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


// 0ms runtime
bool isSameTree(struct TreeNode* p, struct TreeNode* q){
    if (!p ^ !q)  // if only one is null
        return false;
    
    return p == q || 
        p->val == q->val && 
        isSameTree(p->left, q->left) && 
        isSameTree(p->right, q->right);
        
}