public class Element {

    private final float height;
    private final int id;
    private boolean isViewSpot;

    public Element(float height, int id) {
        this.height = height;
        this.id = id;
        isViewSpot = false;
    }

    public float getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public boolean isViewSpot() {
        return isViewSpot;
    }

    public void setViewSpot(boolean viewSpot) {
        isViewSpot = viewSpot;
    }
}
