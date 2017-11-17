package monarchs;

import java.awt.Color;
import gov.nasa.worldwind.render.SurfacePolygon;
import gov.nasa.worldwind.render.SurfaceShape;
import repast.simphony.visualization.gis3D.style.SurfaceShapeStyle;

public class ZoneStyle implements SurfaceShapeStyle<ZoneAgent>{
	@Override
	public SurfaceShape getSurfaceShape(ZoneAgent object, SurfaceShape shape) {
		return new SurfacePolygon();
	}

	@Override
	public Color getFillColor(ZoneAgent zone) {
		if (zone.getprobEggs() == 0.09){
			return Color.RED;
		}
		if (zone.getprobEggs() == 0.002){
			return Color.YELLOW;
		}
		if (zone.getprobEggs() == 0.01){
			return Color.DARK_GRAY;
		}
		if (zone.getprobEggs() == 0.04){
			return Color.ORANGE;
		}
		if (zone.getprobEggs() == 0.075){
			return Color.GREEN;
		}
		if (zone.getprobEggs() == 0.085){
			return Color.YELLOW;
		}
		if (zone.getprobEggs() == 0){
			return Color.BLACK;
		}else{
			return Color.CYAN;
		}
	}

/**
	//testshapefile1
	@Override
	public Color getFillColor(ZoneAgent zone) {
		if (zone.getprobEggs() == 0.9){
			return Color.RED;
		}
		if (zone.getprobEggs() == 0.02){
			return Color.CYAN;
		}
		if (zone.getprobEggs() == 0.1){
			return Color.DARK_GRAY;
		}
		if (zone.getprobEggs() == 0.05){
			return Color.ORANGE;
		}
		if (zone.getprobEggs() == 0.75){
			return Color.GREEN;
		}
		if (zone.getprobEggs() == 0.85){
			return Color.YELLOW;
		}
		if (zone.getprobEggs() == 0){
			return Color.BLACK;
		}else{
			return Color.CYAN;
		}
	}
**/
	
	
	@Override
	public double getFillOpacity(ZoneAgent obj) {
		return 0.25;
		//return 1;
	}

	@Override
	public Color getLineColor(ZoneAgent zone){
		return Color.black;
	}
		
	@Override
	public double getLineOpacity(ZoneAgent obj) {
		return 1.0;
	}

	@Override
	public double getLineWidth(ZoneAgent obj) {
		return 3;
	}
}
