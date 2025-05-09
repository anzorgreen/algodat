import java.util.Arrays;
import javax.swing.TransferHandler;


public class ConvexPolygon extends Polygon {
    public ConvexPolygon(Vector2D[] vertices) {
        this.vertices = vertices;
    }

    @Override
    public double area() {
        double area = 0;
        for (int i = 1; i < this.vertices.length - 1; i++) {
            area += Triangle.area(
                new Triangle(this.vertices[0], this.vertices[i], this.vertices[i + 1])
            );

        };
        return area;
    };

    public static double totalArea(Polygon[] polygons) {
        double totalArea = 0;
        for(Polygon polygon : polygons) {
            totalArea += polygon.area();
        }
        return totalArea;
    };

    public double perimeter() {
        double perimeter = 0;
        for(int i = 0; i < this.vertices.length - 1; i++) {
            perimeter += new Vector2D(
                this.vertices[i + 1].getX() - this.vertices[i].getX(),
                this.vertices[i + 1].getY() - this.vertices[i].getY()
            ).length();
        };
        perimeter += new Vector2D(
            this.vertices[0].getX() - this.vertices[this.vertices.length - 1].getX(),
            this.vertices[0].getY() - this.vertices[this.vertices.length - 1].getY()
            
        ).length();
        return perimeter;
    };

    public static Polygon[] somePolygons() {
        Triangle triangle = new Triangle(
            new Vector2D(0, 0),
            new Vector2D(10, 0),
            new Vector2D(5, 5)
        );
        Tetragon tetragon = new Tetragon(
            new Vector2D(0, 0),
            new Vector2D(10, -5),
            new Vector2D(12, 2),
            new Vector2D(3, 17)
        );
        RegularPolygon pentagon = new RegularPolygon(5, 1);
        RegularPolygon hexagon = new RegularPolygon(6, 1);
        Polygon[] polygons = {
            triangle, tetragon, pentagon, hexagon
        };
        return polygons;
    }

    protected String getStringOfVertices () {
        String string = "";
        for (int i = 0; i < this.vertices.length - 1; i++) {
            string += this.vertices[i].toString() + ", ";
        }
        string += this.vertices[this.vertices.length - 1].toString();
        return string;
    }

    @Override
    public String toString() {
    String string = "ConvexPolygon([" + this.getStringOfVertices() + "])";
    return string;
    };

}


