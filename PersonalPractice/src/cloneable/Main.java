package cloneable;

class Box implements Cloneable {
    private int width, height;
    public Box(int w, int h) {
        width = w;
        height = h;
    }

    public void setWidth(int w) {
        width = w;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int h) {
        height = h;
    }
    public int getHeight() {
        return height;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Box b1 = new Box(20, 30);
        Box b2 = (Box) b1.clone();
        b1.setWidth(10);
        System.out.println(b2.getWidth());
    }
}
