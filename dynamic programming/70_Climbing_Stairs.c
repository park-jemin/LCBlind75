// https://leetcode.com/problems/climbing-stairs/


int climbStairs(int n) {
	int a = 1, b = 1;
    while (n--)
    	a = (b += a) - a;
 
    return a;
}

int climbStairs2(int n){
    // O(n) time, O(1) space
    if (n <= 3)
        return n;
    
    // track # ways in one step back and two steps back
    int step1 = 2, step2 = 3;
    for (int i = 4; i < n; i++) {
        int nextStep = step1 + step2;
        step1 = step2;
        step2 = nextStep;
    }
    
    return step1 + step2;
}


int climbStairs3(int n) {
	// O(n) time, O(n) space
    if (n <= 3)
        return n;
    
    int* ways = malloc(n * sizeof(int));
    ways[0] = 1;
    ways[1] = 2;
    for (int i = 2; i < n; i++) {
        ways[i] = ways[i - 1] + ways[i - 2];
    }
    
    int result = ways[n - 1];
    free(ways);
    return result;

}