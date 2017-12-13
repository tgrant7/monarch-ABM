package monarchs;

import java.awt.Color;
import gov.nasa.worldwind.render.SurfacePolygon;
import gov.nasa.worldwind.render.SurfacePolyline;
import gov.nasa.worldwind.render.SurfaceShape;
import repast.simphony.visualization.gis3D.style.SurfaceShapeStyle;

public class PathStyle implements SurfaceShapeStyle<MonarchPath>{
	@Override
	public SurfaceShape getSurfaceShape(MonarchPath object, SurfaceShape shape) {
		return new SurfacePolyline();
	}

	@Override
	public Color getFillColor(MonarchPath zone) {
		return Color.CYAN;
	}

	@Override
	public double getFillOpacity(MonarchPath obj) {
		return 0.25;
	}

	@Override
	public Color getLineColor(MonarchPath zone){
		return Color.yellow;
	}
		
	@Override
	public double getLineOpacity(MonarchPath obj) {
		return 1.0;
	}

	@Override
	public double getLineWidth(MonarchPath obj) {
		return 3;
	}
}
