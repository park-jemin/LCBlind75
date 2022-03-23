// https://leetcode.com/problems/group-anagrams/
// 49. Group Anagrams

function groupAnagrams(strs: string[]): string[][] {
    
    const lengthMap = new Map() // number for word length, string[][]
    
    for (let word of strs) {
        
        if (lengthMap.has(word.length)) {
            // check all words of that letter length
            const wordList = lengthMap.get(word.length)
            
            let anagramList = null
            for (let candidateList of wordList) {
                if (isAnagram(word, candidateList[0])) {
                    anagramList = candidateList
                    break
                }
            }
            
            if (anagramList)
                anagramList.push(word)
            else
                wordList.push([word])
                
        } else {
            lengthMap.set(word.length, [[word]])
        }
        
    }   
    
    const result = []
    for (const [_, wordList] of lengthMap) {
        result.push(...wordList)
    }
    
    return result
}

function isAnagram(s: string, t: string) {
    const counts = { }
    for (const c of s) {
        counts[c] = ++counts[c] || 1
    }
    
    for (const c of t) {
        if (!(c in counts) || --counts[c] < 0) {
            // console.log(counts)
            return false
        }
    }
    
    return true
}