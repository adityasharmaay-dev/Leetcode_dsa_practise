class Solution {
    class pair{
        String fir;
        int sec;
        pair(String fir, int sec){
            this.fir = fir;
            this.sec = sec;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().fir;
            int steps = q.peek().sec;
            q.poll();
            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedword = word.toCharArray();
                    replacedword[i] = ch;
                    String newWord = new String(replacedword);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new pair(newWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}