/**
 * 
 */
package unsw.graphics.examples;
import unsw.graphics.CoordFrame2D;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.jogamp.newt.event.MouseAdapter;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.opengl.GL3;

import unsw.graphics.Application2D;
import unsw.graphics.geometry.Line2D;
import unsw.graphics.geometry.LineStrip2D;
import unsw.graphics.geometry.Point2D;
import unsw.graphics.geometry.Triangle2D;

/**
 * Use the mouse to draw triangles
 * 
 * Left-click to place a point. For every 3 points placed, a triangle is drawn.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class TwoTriangles extends Application2D {
    
    private LineStrip2D currentStrip;
    
    private Point2D currentPoint;
    
    private List<Triangle2D> triangles;

    public TwoTriangles() {
        super("Two triangles", 600, 600);
        currentStrip = new LineStrip2D();
        currentPoint = new Point2D(0,0);
        triangles = new ArrayList<Triangle2D>();
        this.setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        TriangleDrawing example = new TriangleDrawing();
        example.start();
    }
    
    @Override
    public void init(GL3 gl) {
        super.init(gl);
        
        Triangle2D tri1 = new Triangle2D(0,0, 1,1, -1,1);
        triangles.add(tri1);
    }
    
    @Override
    public void display(GL3 gl) {
        super.display(gl);              
        
        for (Triangle2D tri : triangles) 
            tri.draw(gl, CoordFrame2D.identity());        
    }
}
