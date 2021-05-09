import java.util.LinkedList;
class Graph {
    int[][] graphMatrix = new int[10][10];
    int length = 0;
    LinkedList<Integer> returnList = new LinkedList<>();
    public void addNode(int num) {
        if(num < graphMatrix.length - 1) {
            graphMatrix[num][num] = 1;
            length++;
        } else {
            expandMatrix();
            this.addNode(num);
        }
    }
    public void addConnection(int node1, int node2, boolean bothWays) {
        if(bothWays) {
            graphMatrix[node1][node2] = 1;
            graphMatrix[node2][node1] = 1;
        } else {
            graphMatrix[node1][node2] = 1;
        }
    }
    public void changeWeight (int node1, int node2,int weight) {
        graphMatrix[node1][node2] = weight;
    }
    public void expandMatrix() {
        int[][] copyMatrix = new int[graphMatrix.length * 10][graphMatrix.length * 10];
        for(int i = 0; i < graphMatrix.length; i++) {
            for(int j = 0; j < graphMatrix[i].length; j++) {
                copyMatrix[i][j] = graphMatrix[i][j];
            }
        }
        graphMatrix = copyMatrix;
    }
    public LinkedList<Integer> BFSRecursive(int startNode) {
        this.BFSRecurs(startNode,new boolean[graphMatrix[startNode].length]);
        return returnList;
    }
    public LinkedList<Integer> BFS(int startNode) {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> returnlist = new LinkedList<>();
        boolean [] visited = new boolean[graphMatrix.length];
        while(true) {
            boolean goneIn = false;
           for(int i = 0 ; i < graphMatrix[startNode].length; i++) {
               if(graphMatrix[startNode][i] != 0) {
                  if(!visited[i]) {
                      stack.add(0,startNode);
                      startNode = i;
                      goneIn = true;
                      returnList.add(i);
                      break;
                  }
               }
           }

        }
    }
    public void BFSRecurs(int startNode, boolean [] visited) {
        for(int i = 0; i < visited.length;i++){
            //System.out.print(visited[i] + " ");
        }
        System.out.println("");
        returnList.add(startNode);
        visited[startNode] = true;
        for(int i = 0; i < graphMatrix[startNode].length; i++) {
            System.out.print(graphMatrix[startNode][i]);
            if(graphMatrix[startNode][i] > 0) {
                if (!visited[i]) {
                    this.BFSRecurs(i, visited);
                }
            }
        }
        return;
    }
    public int Djikstras(int node1, int node2) {
        int[] values = new int[length];
        boolean[] done = new boolean[length];
        for(int i = 0; i < length; i++) {
            values[i] = Integer.MAX_VALUE;
            done[i] = false;
        }
        values[0] = 0;
        for(int i = 0; i > -1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = Integer.MAX_VALUE;
            for(int j = 0; j < values.length; j++) {
                if(!done[j]) {
                    if(values[j] < min) {
                        min = values[j];
                        pos = j;
                    }
                }
            }
            done[pos] = true;
            for(int k = 0; k < values.length; k++) {
                System.out.print(values[k] + " ");
            }
            System.out.println();
            for(int k = 0; k < values.length; k++) {
                System.out.print(done[k] + " ");
            }
            System.out.println();
            int[] connections = graphMatrix[pos];
            for(int j = 0; j < connections.length; j++) {
                if(connections[j] != 0) {
                    if(values[j] > (connections[j] + values[pos])&& !done[j]) {
                        values[j] = connections[j] + values[pos];
                    }
                }
            }
            if(done[node2] == true) {
                break;
            }
        }
        return values[node2];
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addConnection(0,1,false);
        graph.addConnection(0,2,false);
        graph.addConnection(1,2,false);
        graph.addConnection(2,0,false);
        graph.addConnection(2,3,false);
        graph.addConnection(3,3,false);
        System.out.println(graph.BFS(1) + " ans");
    }
}