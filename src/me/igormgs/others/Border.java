package me.igormgs.others;

public class Border
{
    public int radiusSq;
    public int definiteSq;
    public double centerX;
    public double centerZ;
    public double radius;
    
    public Border(final double X, final double Z, final double Radius) {
        this.centerX = X;
        this.centerZ = Z;
        this.radius = Radius;
    }
    
    @Override
    public String toString() {
        return "X: " + this.centerX + " Z: " + this.centerZ + " Radius: " + this.radius;
    }
}
