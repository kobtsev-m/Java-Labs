package utils;

public class Size {
    public int w, h;
    public Size(int w, int h) {
        this.w = w;
        this.h = h;
    }
    public void validate() throws CustomException {
        if (w <= 0 || h <= 0) {
            throw new CustomException("Invalid field size");
        }
    }
}
