package pl.edu.agh.graph.isomorphism;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import pl.edu.agh.graph.Vertex;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub Pelc
 * Date: 26.03.13
 * Time: 11:54
 */
public class GraphsAndSubgraphsGenerator {

    public Graph generateGraph(int vertexCount) {
        Graph<Vertex, String> g = new SparseGraph<Vertex, String>();
        Random random = new Random();
        LinkedList<Vertex> list = new LinkedList<Vertex>();

        for(int i = 1; i <= vertexCount; i++) {
            Vertex v = new Vertex("V[" + i + "]");
            list.add(v);
            g.addVertex(v);
            if(g.getVertexCount() == 1) continue;
            if(g.getVertexCount() == 2) {
                g.addEdge("V[1] <---> V[2]", v, list.get(0));
                continue;
            }

            int howManyTimes = i > 0.5*vertexCount ? 2 : 1;

            for (int j = 0; j < howManyTimes; j++) {
                int whichOne = 0;
                do {
                    whichOne = random.nextInt(g.getVertexCount()) + 1;
                } while(whichOne == i);
                System.out.println("wierzcholkow: " + g.getVertexCount());
                System.out.println("wierzcholek: " + i + "  dolaczam do: " + whichOne);
                g.addEdge(v.toString() + "<--->" + list.get(whichOne-1).toString(), v, list.get(whichOne-1));
            }

        }
        return g;
    }

}
