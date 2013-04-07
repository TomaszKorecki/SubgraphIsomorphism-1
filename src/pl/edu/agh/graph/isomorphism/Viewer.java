package pl.edu.agh.graph.isomorphism;

import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import pl.edu.agh.graph.Vertex;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub Pelc
 * Date: 07.04.13
 */
public class Viewer {

    private GraphsAndSubgraphsGenerator generator;
    private JFrame window;
    private Graph<Vertex, String> graphA;
    private Graph<Vertex, String> graphB;


    public Viewer(int vertexCount) {
        generator = new GraphsAndSubgraphsGenerator();
        graphA = generator.generateGraph((int) (0.7*vertexCount));
        graphB = generator.generateGraph(vertexCount);
        window = new JFrame("Subgraphs Isomorphism");
        init();
    }

    private void init() {
        setLookAndFeel();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelA = new JPanel();
        panelA.setBorder(new TitledBorder("Graf A"));
        JPanel panelB = new JPanel();
        panelB.setBorder(new TitledBorder("Graf B"));
        VisualizationViewer<Vertex, String> vvA =
                new VisualizationViewer<Vertex, String>(new ISOMLayout<Vertex, String>(graphA));
        VisualizationViewer<Vertex, String> vvB =
                new VisualizationViewer<Vertex, String>(new ISOMLayout<Vertex, String>(graphB));
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vvA.setGraphMouse(gm);
        vvB.setGraphMouse(gm);
        panelA.add(vvA);
        panelB.add(vvB);
        window.getContentPane().add(panelA);
        window.getContentPane().add(panelB);
        window.pack();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void show() {
        window.setVisible(true);
        System.out.println(graphA.getEdgeCount());
        System.out.println(graphB.getEdgeCount());
    }

    public static void main(String[] args) {
        Viewer v = new Viewer(30);
        v.show();
    }

}
