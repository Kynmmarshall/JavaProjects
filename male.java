public class male {

    private double penisLength;
    private double testicleSize;
    private boolean isErected;
    private boolean isCircumcised;

    // Constructor
    public male(double penisLength, double testicleSize) {
        this.penisLength = penisLength;
        this.testicleSize = testicleSize;
        this.isErected = false;
        this.isCircumcised = false;
    }

    // Getters
    public double getPenisLength() {
        return penisLength;
    }

    public double getTesticleSize() {
        return testicleSize;
    }

    public boolean isErected() {
        return isErected;
    }

    public boolean isCircumcised() {
        return isCircumcised;
    }

    // Setters
    public void setPenisLength(double penisLength) {
        this.penisLength = penisLength;
    }

    public void setTesticleSize(double testicleSize) {
        this.testicleSize = testicleSize;
    }

    // Methods
    public void erect() {
        if (!isErected) {
            isErected = true;
            System.out.println("State changed: Erect.");
        } else {
            System.out.println("Already erect.");
        }
    }

    public void flaccid() {
        if (isErected) {
            isErected = false;
            System.out.println("State changed: Flaccid.");
        } else {
            System.out.println("Already flaccid.");
        }
    }

    public void ejaculate() {
        if (isErected) {
            System.out.println("Ejaculation occurred.");
            isErected = false; // typically returns to flaccid state
        } else {
            System.out.println("Cannot ejaculate while flaccid.");
        }
    }

    public void circumcise() {
        if (!isCircumcised) {
            isCircumcised = true;
            System.out.println("Circumcision completed.");
        } else {
            System.out.println("Already circumcised.");
        }
    }
}