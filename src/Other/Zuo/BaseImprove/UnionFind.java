package Other.Zuo.BaseImprove;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @title: UnionFind
 * @Author: Lux_er
 * @Date: 2021/4/26 0026 上午 11:00
 * @Description:
 */
public class UnionFind {
    // 样本进来会包一层,叫做元素
    public static class Element<V>{
        public V value;
        public Element(V value){
            this.value = value;
        }
    }

    public static class UnionFindSet<V>{
        public HashMap<V,Element<V>> elementMap;
        // key:某个元素; value:该元素的父
        public HashMap<Element<V> , Element<V>> fatherMap;
        // key:某个集合的代表元素; value:该集合的大小
        public HashMap<Element<V> , Integer> sizeMap;
        // 初始化并查集
        public UnionFindSet(List<V> list){
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element,element);
                sizeMap.put(element, 1);
            }
        }
        public boolean isSameSet(V a,V b){
            // 并查集要求查询是否是相同集合前,需要先初始化
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){
               // 看两个代表元素是否相等,返回他们的结果
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a,V b){
            // 并查集要求并集前,需要先初始化
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                // 并集要求,集合数小的接在集合数大的后面
                if(aF != bF){
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    // 将小的集合的代表节点设置为大集合的
                    fatherMap.put(small, big);
                    // 修改大集合的集合数
                    sizeMap.put(big, sizeMap.get(aF)+sizeMap.get(bF));
                    // 移除小集合
                    sizeMap.remove(small);
                }
            }
        }
        // 寻找代表节点
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while(element != fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(), element);
            }
            return element;
        }
    }
}
