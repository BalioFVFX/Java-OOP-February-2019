public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }


    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }


    public boolean contains(Point point) {
        boolean xValid = point.getX() >= this.topLeft.getX() && point.getX() <= this.bottomRight.getX();
        boolean yValid = point.getY() >= this.topLeft.getY() && point.getY() <= this.bottomRight.getY();

        return xValid && yValid;
    }

    public static Rectangle create(int[] args) {
        return new Rectangle(new Point(args[0], args[1]), new Point(args[2], args[3]));
    }
}
