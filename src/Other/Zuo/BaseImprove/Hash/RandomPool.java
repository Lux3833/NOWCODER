package Other.Zuo.BaseImprove.Hash;

import java.util.HashMap;

/**
 * @title: RandomPool
 * @Author: Lux_er
 * @Date: 2021/4/25 0025 上午 11:47
 * @Description:
 * 设计一种结构,在该结构中有三个功能:
 * insert(Key):将某个Key加入到该结构中,做到不重复加入
 * delete(Key):将原本在结构中的某个Key移除
 * getRandom(Key):等概率随机返回结构中的任何一个Key
 * 要求Insert,delete和getRandom方法的时间复杂度都是O(1)
 */
public class RandomPool {
    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<K,Integer>();
            this.indexKeyMap = new HashMap<Integer,K>();
            this.size = 0;
        }

        public void insert(K key){
            if(!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public void delete(K key){
            if(this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom(){
            if(this.size == 0){
                return null;
            }
            int randomIndex = (int)(Math.random() * this.size);
            return  this.indexKeyMap.get(randomIndex);
        }
    }
}
