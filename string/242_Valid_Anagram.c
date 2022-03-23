// https://leetcode.com/problems/valid-anagram/
// 242. Valid Anagram

bool isAnagram(char * s, char * t){
    if (strlen(s) != strlen(t))
        return false;
    
    int charCount[26] = { 0 };
    for (char* ch = s; *ch ; ++ch)
        ++charCount[*ch - 'a'];
    
    for (char* ch = t; *ch ; ++ch)
        if (--charCount[*ch - 'a'] < 0)
            return false;
    
    return true;
}