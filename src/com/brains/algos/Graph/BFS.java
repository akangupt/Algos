package com.brains.algos.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS {

    private List<Integer> adj[];
    private int V;
    private BFS(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0 ; i < v ; ++i ) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    private void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    private void BFS(int src) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        visited[src] = true;
        while(!q.isEmpty()) {
            int vert = q.poll();
            System.out.println(vert);

            for (int i = 0; i < adj[vert].size(); ++i) {
                int next = adj[vert].get(i);
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }

            /* OR
            Iterator<Integer> it = adj[vert].listIterator();
            while(it.hasNext()) {
                int next1 = it.next();
                if(!visited[next1]) {
                    q.add(next1);
                    visited[next1] = true;
                }
            }
            */

            /* OR
            for (Integer next1 : adj[vert]) {
                if (!visited[next1]) {
                    q.add(next1);
                    visited[next1] = true;
                }
            }
            */
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(5);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
    }

}
