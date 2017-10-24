package mandelbrot;

public class MandelbrotParameter {

	protected String name;
	protected double resolution;
	protected double xCenter, yCenter;
	
	public MandelbrotParameter(String name, double res, double x, double y){
		this.name = name;
		this.resolution = res;
		this.xCenter = x;
		this.yCenter = y;
	}
}
