package Other.Zuo.Base.TrieTree;

/**
 * @title: Code_TrieTree
 * @Author: Lux_er
 * @Date: 2021/4/22 0022 上午 9:19
 * @Description:前缀树
 */
public class Code_TrieTree {
    public static class TrieNode{
        // 表示有几个字符串通过该节点,可以用来查询多少个以该节点结尾的前缀
        public int pass;
        // 表示有几个字符串以该节点做结尾,可以用来查询多少个以该节点结尾的字符串
        public int end;
        // 表示该节点之后有无其他节点的通道,有通道则+1,否则设为null
        public TrieNode[] nexts;

        public TrieNode(){
            this.pass = 0;
            this.end = 0;
            // HashMap<Char,Node> nexts也可以
            // TreeMap<Char,Node> nexts 是有序的
            this.nexts = new TrieNode[26];
        }
    }
    public static class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if(--node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;// 只有Java能这么玩
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
        // 查询word这个单词之前加入过几次
        private int search(String word) {
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
        // 所有加入的字符串中,有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
