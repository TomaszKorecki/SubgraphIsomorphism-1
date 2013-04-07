package pl.edu.agh.graph;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub Pelc
 * Date: 26.03.13
 * Time: 12:24
 */
public class Vertex {

    private String name;
    private int inDegree;
    private int outDegree;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    public String toString() {
        return name;
    }
}
