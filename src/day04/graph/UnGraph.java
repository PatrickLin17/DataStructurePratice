package day04.graph;

import java.util.LinkedList;
import java.util.Queue;

public class UnGraph {
    //标识图中顶点个数
    private int points;

    private boolean found = false;

    private LinkedList<Integer> adjacencyList[];

    public UnGraph(int points) {
        this.points = points;
        adjacencyList = new LinkedList[this.points];
        for (int i = 0; i < points; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void insert(int s, int p) {
        adjacencyList[s].add(p);
        adjacencyList[p].add(s);
    }


    /**
     * 打印从start - target线路的方法
     */
    public void print(int[] prev, int start, int target) {
        if (prev[target] != -1 && start != target) {
            print(prev, start, prev[target]);
        }
        System.out.print(target + ">>");
    }


    /**
     * bfs 广度优先搜索算法
     *
     * @param start  起始顶点
     * @param target 目标
     */
    public void bfs(int start, int target) {
        if (start == target) {
            return;
        }


        /**
         * 定义一个布尔数组来记录访问过的顶点
         */
        boolean[] visited = new boolean[this.points];
        //起始顶点已被访问过
        visited[start] = true;


        /**
         * 定义一个队列，存储已经访问过的，但还有相邻顶点没被访问过的顶点
         */
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        /**
         * 定义一个数组来存start - target的线路
         */

        int[] prevs = new int[this.points];
        //初始化线路为-1
        for (int i = 0; i < prevs.length; i++) {
            prevs[i] = -1;
        }

        /**
         * 循环访问队列中没有被访问的顶点
         */
        while (!queue.isEmpty()) {
            //取出已经访问过的，但还有相邻顶点没被访问过的顶点
            Integer poll = queue.poll();
            //遍历这个顶点的相邻顶点
            for (int i = 0; i < adjacencyList[poll].size(); i++) {
                //取出相邻顶点
                Integer p_edge = adjacencyList[poll].get(i);
                if (!visited[p_edge]) {
                    //记录访问路线
                    prevs[p_edge] = poll;
                    //如果该顶点与target相等时就打印访问路线
                    if (p_edge == target) {
                        print(prevs, start, target);
                        return;
                    }
                }
                //否则标记poll为已经访问过的顶点
                visited[poll] = true;
                //相邻顶点存入队列
                queue.add(p_edge);
            }
        }
    }


    public void dfs(int start, int target) {
        if (start == target) {
            return;
        }
        //标记某元素是否被访问
        boolean[] visted = new boolean[this.points];

        visted[start] = true;
        //创建一个数组，记录从原顶点到目标顶点的路线
        int[] prv = new int[this.points];
        for (int i = 0; i < prv.length; i++) {
            prv[i]=-1;
        }
        //递归调用
        returnDFS(start,target,visted,prv);
        //打印线路
        print(prv,start,target);
    }

    /**
     * 查找顶点point到目标顶点的线路
     * @param point 顶点
     * @param target 目标顶点
     * @param visited 已经被访问过的顶点数组
     * @param prev 顶点线路数组
     */
    private void returnDFS(int point, int target, boolean[] visited, int[] prev) {
        if (found){
            return;
        }
        //标记当前顶点已经被访问过
        visited[point] = true;
        //如果当前顶点就是目标顶点
        if (point==target){
            found=true;
            return;
        }
//        获取与当前顶点相连接的所有顶点
        for (int i = 0; i < adjacencyList[point].size(); i++) {
            //        获取与point相连接的顶点
            Integer p_connected = adjacencyList[point].get(i);
            if (!visited[p_connected]){
                //记录p_connected之前的顶点是point
                prev[p_connected]=point;
                //递归
                returnDFS(p_connected,target,visited,prev);
            }

        }
    }

    public static void main(String[] args) {
        UnGraph unGraph = new UnGraph(8);
        unGraph.insert(0, 1);
        unGraph.insert(0, 3);
        unGraph.insert(1, 2);
        unGraph.insert(1, 4);
        unGraph.insert(2, 5);
        unGraph.insert(3, 4);
        unGraph.insert(4, 5);
        unGraph.insert(4, 6);
        unGraph.insert(6, 7);
        unGraph.insert(5, 7);
        unGraph.bfs(0, 6);
    }
}
