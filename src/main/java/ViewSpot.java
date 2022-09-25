public class ViewSpot {

    private final int elementId;
    private final float height;

    public ViewSpot(int elementId, float height) {
        this.elementId = elementId;
        this.height = height;
    }

    public int getElementId() {
        return elementId;
    }

    public float getHeight() {
        return height;
    }
}
