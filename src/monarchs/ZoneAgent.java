package monarchs;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameters;
import repast.simphony.query.space.gis.GeographyWithin;
import repast.simphony.space.gis.Geography;
import repast.simphony.util.ContextUtils;

/**
 * 
 * Each polygon in the shapefile is a zone agent.  The number of eggs accumulates in 
 * each polygon.  
 * 
 * @author Tyler Grant
 *
 */

public class ZoneAgent {
	public double ID;
	//public long OBJECTID_1;
	public String name;
	public double cumulativeeggs;
	private double probEggs;
	private double probMove;
	private double zonearea;
	private long GISPolyID;
	
	public ZoneAgent(double ID, String name, int cumulativeeggs, 
			double probEggs, double probMove, double zonearea, long GISPolyID){
		this.ID = ID;
		//this.OBJECTID_1 = OBJECTID_1;
		this.name = name;
		this.cumulativeeggs = cumulativeeggs;
		this.probEggs = probEggs;
		this.probMove = probMove;
		this.zonearea = zonearea;
		//I don't know why this is not like the others
		this.GISPolyID = GISPolyID;
	}
	
//	@ScheduledMethod(start = 1, interval = 1)
//	public void step() {
//		collEggs();
//	}
	
//	private void collEggs(){
//		Context context = ContextUtils.getContext(this);
//		Geography geography = (Geography)context.getProjection("Monarchs");
		
		//Checks if any monarchs in polygon and if so has probability to collect 4 eggs
		//that contribute to total cumulative eggs in that polygon
		//Parameters parm = RunEnvironment.getInstance().getParameters();
		
//		GeographyWithin within = new GeographyWithin(geography, 0, this);
//		for (Object obj : within.query()) {
//			if (obj instanceof Monarch) {
//				Monarch monarch = (Monarch)obj;
//				if (this.probEggs > Math.random()){
				//need to account for the fact that sometimes don't have 4 eggs left to lay
//				if(monarch.dailyeggstolay > 3){
//					cumulativeeggs = cumulativeeggs + Monarch.eggsperlay;
//				} else{
//					cumulativeeggs = cumulativeeggs + monarch.dailyeggstolay;
//				}
//				monarch.eggsleft();
//				monarch.laideggs();
//				}
//			}
//		}
//	}
	
	public double getID(){
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public double getEggs() {
		return cumulativeeggs;
	}
	
	public double getprobEggs() {
		return probEggs;
	}
	
	public double getprobMove() {
		return probMove;
	}
	
	public double getArea(){
		return zonearea;
	}
	
	public long getGISPolyID() {
		return GISPolyID;
	}
}
