package emojivacation;

import edu.macalester.graphics.*;

import java.awt.Color;

@SuppressWarnings("WeakerAccess")  // This stops Java from giving you warnings about your code that are not helpful here
public class Emojis {
    private static final Color
        HEAD_COLOR = new Color(0xFFDE30),
        EYE_COLOR = new Color(0x000000),
        IRIS_COLOR = new Color(0x964B00),
        HIGHLIGHT_COLOR = new Color(0xffffff),
        HEAD_OUTLINE_COLOR = new Color(0xAC9620),
        MOUTH_COLOR = new Color(0xE45B5B);

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Emojis", 800, 600);

        GraphicsGroup littleSmiley = createSmileyFace(100);
        littleSmiley.setPosition(50, 400);
        canvas.add(littleSmiley);

        GraphicsGroup mediumSmiley = createSmileyFace(200);
        mediumSmiley.setPosition(150, 300);
        canvas.add(mediumSmiley);

        GraphicsGroup bigSmiley = createSmileyFace(300);
        bigSmiley.setPosition(350, 200);
        canvas.add(bigSmiley);
    }

    /**
     * Creates a smiley face emoji.
     *
     * @param size The overall width and height of the emoji.
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createSmileyFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        GraphicsGroup leftEye = createEye(size, size);
        GraphicsGroup rightEye = createEye(size, size);

        leftEye.setCenter(size * 0.35, size * 0.4);
        rightEye.setCenter(size * 0.65, size * 0.4);

        group.add(leftEye);
        group.add(rightEye);

        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        return group;
    }

    /**
     * Creates an empty emoji head. The head fits inside the box from (0,0)
     * to (width,height).
     */
    private static Ellipse createHead(double height, double width) {
        Ellipse head = new Ellipse(0, 0, width, height);
        head.setFillColor(HEAD_COLOR);
        head.setStrokeColor(HEAD_OUTLINE_COLOR);
        head.setStrokeWidth(2);
        return head;
    }

    private static GraphicsGroup createEye(double height, double width) {
        GraphicsGroup group = new GraphicsGroup();

        Ellipse eye = new Ellipse(0, 0, 0.1 * height, 0.1 * width);
        Ellipse iris = new Ellipse(10, 10, 0.03 * height, 0.03 * width);

        eye.setFillColor(EYE_COLOR);
        eye.setStrokeColor(IRIS_COLOR);
        eye.setStrokeWidth(3);
        eye.setCenter(height, width);
        group.add(eye);

        iris.setFillColor(HIGHLIGHT_COLOR);
        iris.setCenter(height * 1.01, width * 0.99);
        group.add(iris);
        
        return group;
    }

    /**
     * Creates a smile-shaped arc. The arc is measured relative to its “implied ellipse,” which is
     * the shape that would be formed if the arc were extend all the way around. The size of the
     * resulting arc will be smaller than the implied ellipse’s size.
     *
     * @param ellipseWidth  The width of the implied ellipse from which the smile’s arc is cut.
     * @param ellipseHeight The width of the implied ellipse from which the smile’s arc is cut.
     */
    private static Arc createSmile(double ellipseWidth, double ellipseHeight) {
        Arc mouth = new Arc(0, 0, ellipseWidth, ellipseHeight, 200, 140);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }
}
