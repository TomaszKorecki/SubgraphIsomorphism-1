package pl.edu.agh.graph.isomorphism;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import pl.edu.agh.graph.Vertex;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub Pelc
 * Date: 26.03.13
 * Time: 11:54
 */
public class GraphsAndSubgraphsGenerator {

    private int vertexCount;

    public GraphsAndSubgraphsGenerator(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public Graph generateGraph() {
        Graph<Vertex, String> g = new SparseGraph<Vertex, String>();

        Random random = new Random();

        Integer edgeName = 1;
        for(int i = 1; i <= vertexCount; i++) {
            Vertex v = new Vertex("V[" + i + "]");
            g.addVertex(v);
            if(g.getVertexCount() == 1) continue;
            if(g.getVertexCount() == 2) {
                g.addEdge("V[2] <---> V[1]", v, g.getE);
                edgeName++;
                continue;
            }
            Integer whichOne;
            do {
                whichOne= random.nextInt(g.getVertexCount());
            } while(whichOne.intValue() == i.intValue() || (whichOne.intValue() == 0));

            System.out.println("wierzcholkow: " + g.getVertexCount());
            System.out.println("wierzcholek: " + i + "  dolaczam do: " + whichOne);

            g.addEdge(edgeName.toString(), i, whichOne);
            edgeName++;

            if(i >= 0.6*numVer){
                Integer whichOne2;
                do {
                    whichOne2 = random.nextInt(g.getVertexCount());
                } while (whichOne2.intValue() == i.intValue() || (whichOne2.intValue() == 0)
                        || whichOne2.intValue() == whichOne.intValue());

                g.addEdge(edgeName.toString(), i, whichOne2);
                edgeName++;
            }
        }
        return g;
    }

}
