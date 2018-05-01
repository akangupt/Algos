package com.brains.algos.Graph;

import java.util.ArrayList;
import java.util.List;

class DFS {

    private List<Integer> adj[];
    private int V;
    private DFS(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0 ; i < v ; ++i ) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    private void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    private void DFS(int src) {
        boolean visited[] = new boolean[V];
        DFSUtil(src, visited);
    }

    private void DFSUtil(int src, boolean[] visited) {
        visited[src] = true;
        System.out.println(src);
        for (int next : adj[src]) {
            if(!visited[next]) DFSUtil(next, visited);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        DFS g = new DFS(5);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(1);
    }

}

