package info.xiantang.algorithm.book.algs4;

/**
 * @创建人:xiantang
 * @创建时间:15/08/18
 * @email:zhujingdi1998@gmail.com
 * @github:github.com/xiantang
 * @blog:zhanshengpipidi.cn/blog
 * @描述:
 **/
public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i <N ; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i <N ; i++) {
            sz[i] = i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p ,int q){
        return find(p) == find(q);
    }
    public int find(int p ){
        while (p!=id[p])p = id[p];
        return p;
    }
    public  void  union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i==j){
            return;
        }
        if(sz[i]<sz[j]){
            id[i] = j;sz[j] +=sz[i];
        }
        else {
            id[j] = i;sz[i] += sz[j];
        }
        count--;
    }

}