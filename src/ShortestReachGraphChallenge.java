/**
 * Created by Marc on 2016-12-04.
 */
/*
Context & Instructions:
Consider an undirected graph consisting of n nodes where each node is
labeled from 1 to n and the edge between any two nodes is always of
length 6. We define node s to be the starting position for a BFS.

Given q queries in the form of a graph and some starting node, s,
perform each query by calculating the shortest distance from starting
node s to all the other nodes in the graph. Then print a single line of
n-1 space-separated integers listing node s's shortest distance to each
of the n-1 other nodes (ordered sequentially by node number); if s is
disconnected from a node, print n-1 as the distance to that node.

Input Format:
The first line contains an integer, q, denoting the number of queries.
The subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective
values of n(the number of nodes) and  m(the number of edges) in the graph.
Each line i of the m subsequent lines contains two space-separated integers,
u and v, describing an edge connecting node u to node v.
The last line contains a single integer, s, denoting the index of the
starting node.

Output Format:
For each of the q queries, print a single line of n-1 space-separated
integers denoting the shortest distances to each of the n-1 other nodes
from starting position s. These distances should be listed sequentially by
node number (i.e., 1,2,...,n), but should not include node s. If some node
is unreachable from s, print -1 as the distance to that node.

Sample I/O:
2
4 2
1 2
1 3
1
3 1
2 3
2

6 6 -1
-1 6
*/

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.misc.*;

import java.io.*;
import java.util.*;

public class ShortestReachGraphChallenge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        /* Self note: djikstra, but maybe I can do it dynamic. Using an array of size node, first element should be starting node s.
        maybe set everything to -1 initially as they are not reachable yet. Using BFS (queue), go through adjacency list and enter all
        edges directly (s, u) connected to starting node s. Update all indexes 'u' in answer array by min(currentValue, d(s)+d(s,u))

         */
        Scanner sc = new Scanner(System.in);
        int amountOfGraphs = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < amountOfGraphs; i++){
            int numOfNodes = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numOfNodes);
            for(int f = 0; f < numOfNodes; f++){
                graph.add(new ArrayList<Integer>());
            }
            int[] shortestDistances = new int[numOfNodes];
            // initially set everything to unreachable
            Arrays.fill(shortestDistances, Integer.MAX_VALUE);
            int numOfEdges = sc.nextInt();
            for(int j = 0; j < numOfEdges; j++){ // O(|E|)
                int vertex = sc.nextInt() - 1;
                int edgeToVertex = sc.nextInt() - 1;
                sc.nextLine();
                // for this vertex, these are the vertices it connects to via an edge
                graph.get(vertex).add(edgeToVertex);
            }

            // starting edge
            int startingVertex = sc.nextInt() - 1;
            sc.nextLine();
            shortestDistances[startingVertex] = 0;
            Deque<Integer> bfsVertex = new ArrayDeque<>();
            bfsVertex.push(startingVertex);

            // BFS for graph - Only concerned about vertices connected to starting node s in someway
            while(!bfsVertex.isEmpty()){
                int currentVertex = bfsVertex.pop();
                for(int k = 0; k < (graph.get(currentVertex)).size(); k++){
                    int edgeToVertex = (graph.get(currentVertex)).get(k) - 1;
                    shortestDistances[edgeToVertex] = Math.min(shortestDistances[edgeToVertex], shortestDistances[currentVertex] + 6);
                    bfsVertex.push(edgeToVertex);
                }
            }

            for(int h = 0; h < shortestDistances.length; h++){
                if(shortestDistances[h] > 0){
                    if(shortestDistances[h] != Integer.MAX_VALUE){
                        System.out.print(shortestDistances[h] + " ");
                    } else {
                        System.out.print("-1 ");
                    }
                }
            }

        }

    }
}