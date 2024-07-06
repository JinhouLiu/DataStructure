package org.example;

import java.util.*;

public class DFSSearch {

    public  static  void main(String[] args){
        DFSGraph  dfsGraph=new DFSGraph();
        dfsGraph.addVertex("A");
        dfsGraph.addVertex("B");
        dfsGraph.addVertex("C");
        dfsGraph.addVertex("D");
        dfsGraph.addVertex("F");
        DFSEdge  A=new DFSEdge("A","B");
        DFSEdge  B=new DFSEdge("B","C");
        DFSEdge  C=new DFSEdge("C","D");
        DFSEdge  D=new DFSEdge("D","F");
        dfsGraph.addEdge(A);
        dfsGraph.addEdge(B);
        dfsGraph.addEdge(C);
        dfsGraph.addEdge(D);
        dfsGraph.DFSSearch("A");
    }

}


/**
 *深度优先搜索构造
 */
class  DFSGraph{

    private Map<String, List<DFSEdge>> adjVertices=new HashMap<>();

    void addVertex(String label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    void addEdge(DFSEdge edge) {
        adjVertices.get(edge.getFrom()).add(edge);  // 从from到to
        adjVertices.get(edge.getTo()).add(new DFSEdge(edge.getTo(), edge.getFrom())); // 从to到from
    }

    List<DFSEdge> getEdges(String label) {
        return adjVertices.get(label);
    }

    Set<String> getVertices() {
        return adjVertices.keySet();
    }

    void DFSSearch(String start){
        Set<String>  visites=new HashSet<>();
        Stack<String>  stack=new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            String  vertex=stack.pop();
            if(!visites.contains(vertex)){
                visites.add(vertex);
                System.out.print(vertex + " ");
                List<DFSEdge> edgeList=adjVertices.get(vertex);
                for(DFSEdge edge: edgeList){
                 if(!visites.contains(edge.getTo())){
                     stack.push(edge.getTo());
                 }

                }
            }
        }
    }
}
class DFSEdge{


    private   String from;

    private String  to;

    public DFSEdge(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


}