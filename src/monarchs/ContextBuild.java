package monarchs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import repast.simphony.context.Context;
import repast.simphony.context.space.gis.GeographyFactoryFinder;
import repast.simphony.context.space.graph.NetworkBuilder;
import repast.simphony.context.space.graph.NetworkFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.query.space.gis.GeographyWithin;
import repast.simphony.space.gis.Geography;
import repast.simphony.space.gis.GeographyParameters;
import repast.simphony.space.graph.Network;
import repast.simphony.util.ContextUtils;

/**
 * ContextBuilder for a Monarch movement and egg-laying model
 * Monarchs move around a GIS landscape in a correlated random walk
 * 
 * @author Tyler Grant
 *
 */

public class ContextBuild implements ContextBuilder{
	
	static int numAgents;
	static int steplength;
	static int eggsperlay;
	static double mindir;
	static double maxdir;
	static double probMoveRange;
	static int perception;
	static int remembered;
	static boolean savecoords;
	
	public Context build(Context context) {
		System.out.println("Monarchs ContextBuild.build()");
		
		//tells batch run to end at tick 10 - TODO set up as input variable
		RunEnvironment.getInstance().endAt(10);
		
		Parameters parm = RunEnvironment.getInstance().getParameters();
		numAgents = (Integer)parm.getValue("numAgents");
		steplength = (Integer)parm.getValue("steplength");
		eggsperlay = (Integer)parm.getValue("eggsperlay");
		mindir = (Double)parm.getValue("mindir");
		maxdir = (Double)parm.getValue("maxdir");
		probMoveRange = (Double)parm.getValue("probMoveRange");
		perception = (Integer)parm.getValue("perception");
		remembered = (Integer)parm.getValue("remembered");
		savecoords = (Boolean)parm.getValue("savecoords");
		
		
		//set up GIS projection
		GeographyParameters geoParams = new GeographyParameters();
		Geography geography = GeographyFactoryFinder.createGeographyFactory(null).
				createGeography("Monarchs", context, geoParams);
		
		
		
		/**** Add Travel Network  - Hazel's code*/
		Network network = NetworkFactoryFinder.createNetworkFactory(null)
				.createNetwork("travel", context, true);

		GeometryFactory fac = new GeometryFactory(); 
		
		//shapefile has to be loaded first now, so initial random monarch locations can be tested
		//Teresa's 2017 data
		//loadFeatures("data/TeresaTestData2.shp", context, geography);
		//Des Moines Lobe model - Scen1 first time
		//loadFeatures("data/DMLModel4LL.shp", context, geography);
		//Des Moines Lobe model - Scen2
		//loadFeatures("data/Spatial_Join_DML4_Counties5_UTMS2LL.shp", context, geography);
		//Des Moines Lobe model - Scen3
		//loadFeatures("data/Spatial_Join_DML4_Counties5_UTMS3LL.shp", context, geography);
		//Des Moines Lobe model - Scen1 again with new improved shapefile
		loadFeatures("data/Spatial_Join_DML4_Counties5_UTMLL.shp", context, geography);
				
		/**
		//init coords are in a field in middle of test shapefile

		//for first shapefile
		Coordinate c = new Coordinate(-93.49, 42.065);
		Coordinate c1 = new Coordinate(-93.490000001, 42.065);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.49, 42.065);
		carray[1]= new Coordinate(-93.490000001, 42.065);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for second shapefile and St Co shapefile
		Coordinate c = new Coordinate(-93.61, 42.04);
		Coordinate c1 = new Coordinate(-93.610000001, 42.04);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.61, 42.04);
		carray[1]= new Coordinate(-93.610000001, 42.04);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for MS figure shapefile
		Coordinate c = new Coordinate(-93.35, 42.1);
		Coordinate c1 = new Coordinate(-93.350000001, 42.1);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.35, 42.1);
		carray[1]= new Coordinate(-93.350000001, 42.1);
		LineString ls = fac.createLineString(carray);
		**/

		/**
		//for MS figure2 shapefile
		Coordinate c = new Coordinate(-93.45, 42.18);
		Coordinate c1 = new Coordinate(-93.450000001, 42.18);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.45, 42.18);
		carray[1]= new Coordinate(-93.450000001, 42.18);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for ToxSims shapefiles 
		Coordinate c = new Coordinate(-93.43, 42.17);
		Coordinate c1 = new Coordinate(-93.430000001, 42.17);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.43, 42.17);
		carray[1]= new Coordinate(-93.430000001, 42.17);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Teresa 2017 data shapefiles (99% sure)
		Coordinate c = new Coordinate(-92.72, 42.03);
		Coordinate c1 = new Coordinate(-93.720000001, 42.03);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.72, 42.03);
		carray[1]= new Coordinate(-93.720000001, 42.03);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Cory1_FINAL2.shp
		Coordinate c = new Coordinate(-94.7, 42.9);
		Coordinate c1 = new Coordinate(-94.70000001, 42.9);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-94.7, 42.9);
		carray[1]= new Coordinate(-94.70000001, 42.9);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Jackie_FINAL2.shp
		Coordinate c = new Coordinate(-94.3, 40.85);
		Coordinate c1 = new Coordinate(-94.30000001, 40.85);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-94.3, 40.85);
		carray[1]= new Coordinate(-94.30000001, 40.85);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Juliasffinalmap.shp
		Coordinate c = new Coordinate(-94.5, 41.7);
		Coordinate c1 = new Coordinate(-94.50000001, 41.7);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-94.5, 41.7);
		carray[1]= new Coordinate(-94.50000001, 41.7);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Alec_Counties_1_Final.shp
		Coordinate c = new Coordinate(-93.3, 42.9);
		Coordinate c1 = new Coordinate(-93.30000001, 42.9);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.3, 42.9);
		carray[1]= new Coordinate(-93.30000001, 42.9);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Brookes_Counties_1_Final.shp
		Coordinate c = new Coordinate(-93.0, 41.7);
		Coordinate c1 = new Coordinate(-93.00000001, 41.7);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.0, 41.7);
		carray[1]= new Coordinate(-93.00000001, 41.7);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//for Farm Progress Show
		Coordinate c = new Coordinate(-93.8, 42.04);
		Coordinate c1 = new Coordinate(-93.80000001, 42.04);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-93.8, 42.04);
		carray[1]= new Coordinate(-93.8000001, 42.04);
		LineString ls = fac.createLineString(carray);
		**/
			
		/**
		//for NW Iowa clip
		Coordinate c = new Coordinate(-95.00, 42.5);
		Coordinate c1 = new Coordinate(-95.0000001, 42.5);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-95.00, 42.5);
		carray[1]= new Coordinate(-95.0000001, 42.5);
		LineString ls = fac.createLineString(carray);
		**/
		
		/**
		//West Lyon Co
		Coordinate c = new Coordinate(-96.5, 43.4);
		Coordinate c1 = new Coordinate(-96.5000001, 43.4);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-96.5, 43.4);
		carray[1]= new Coordinate(-96.50000001, 43.4);
		LineString ls = fac.createLineString(carray);
		**/
		
		//Des Moines Lobe
		Coordinate c = new Coordinate(-94.0, 42.5);
		Coordinate c1 = new Coordinate(-94.0000001, 42.5);
		Network <Object> net = (Network <Object>) context.getProjection("travel");
		net.addEdge(c, c1);
		Coordinate carray[] = new Coordinate[2]; 
		carray[0]= new Coordinate(-94.0, 42.5);
		carray[1]= new Coordinate(-94.0000001, 42.5);
		LineString ls = fac.createLineString(carray);
		
				
		MonarchPath mp = new MonarchPath(net.getEdge(c, c1),c,c1); 	
		context.add(mp);
		geography.move(mp, ls);
		
		
		
		//  Generate agents at random initial location
		for (int i = 0; i < numAgents; i++){
			Monarch monarch = new Monarch("M" + i);//, Monarch.initeggstolay);
			context.add(monarch);
			
			//these random numbers should use a random number stream from RS library so sims can be replicated
			
			//first test shapefile
			//Coordinate coord = new Coordinate(-93.50925 + 0.0515* Math.random(),
			//		42.04425 + 0.05215 * Math.random());
			//second test shapefile
			//Coordinate coord = new Coordinate(-93.5490 - 0.1043* Math.random(),
			//		42.0030 + 0.0794 * Math.random());
			//Story County
			//Coordinate coord = new Coordinate(-93.2319 - 0.4661* Math.random(),
			//		41.8634 + 0.3457 * Math.random());
			//MS figure shapefile
			//Coordinate coord = new Coordinate(-93.327 - 0.042* Math.random(),
			//		42.09 + 0.0347 * Math.random());
			//MS figure2 shapefile
			//Coordinate coord = new Coordinate(-93.4234 - 0.0412* Math.random(),
			//		42.165 + 0.033 * Math.random());
			//Tox Sims shapefiles
			//Coordinate coord = new Coordinate(-93.3819 - 0.0871* Math.random(),
			//		42.1328 + 0.0649 * Math.random());
			//Teresa's 2017 data
			//Coordinate coord = new Coordinate(-93.607 - 0.2175*Math.random(),
			//		41.9312 + 0.21*Math.random());
			//NW IA Clip
			//Coordinate coord = new Coordinate(-93.754 - 2.333* Math.random(),
			//		41.916 + 1.524 * Math.random());
			//West Lyon Co
			//Coordinate coord = new Coordinate(-96.44 - 0.08* Math.random(),
			//		43.26 + 0.24 * Math.random());
			//Farm Progress Show
			//Coordinate coord = new Coordinate(-93.7755 - 0.0605* Math.random(),
			//		42.024 + 0.0323 * Math.random());
			//Cory1_FINAL2.shp
			//Coordinate coord = new Coordinate(-93.98 - 1.32* Math.random(),
			//		42.22 + 1.275 * Math.random());
			//Jackie_FINAL2.shp
			//Coordinate coord = new Coordinate(-93.56 - 1.35* Math.random(),
			//		40.58 + 0.575 * Math.random());
			//Juliasffinalmap.shp
			//Coordinate coord = new Coordinate(-93.82 - 1.21* Math.random(),
			//		41.17 + 1.03 * Math.random());
			//Alec_Counties_1_Final.shp
			//Coordinate coord = new Coordinate(-92.78 - 1.14 * Math.random(),
			//		42.3 + 1.195 * Math.random());
			//Brookes_Counties_1_Final.shp
			//Coordinate coord = new Coordinate(-92.415 - 1.275 * Math.random(),
			//		41.17 + 1.035 * Math.random());

			
			
			//code random population of irregular shaped shapefiles
			boolean goodp = false;
			Coordinate coord = null;
			int pointcount = -1;
			
			while (!goodp) {
				//coordinates for random locations in a box around the shapefile 
				//Teresa's Data
				//coord = new Coordinate(-93.607 - 0.2175 * Math.random(),
				//	41.9312 + 0.21 * Math.random());
				//Des Moines Lobe
				coord = new Coordinate(-93.0510 - 2.7661 * Math.random(),
						41.5258 + 2.0136 * Math.random());
				//cast coordinate as a JTS point
				Point p = fac.createPoint(coord);
				//query location around p to see if any polygons
				GeographyWithin withinp = new GeographyWithin(geography, 0.01, p);
				//boolean iterable checks if there is anything in withinp
				goodp = withinp.query().iterator().hasNext();
				pointcount++;
			}
			
			//System.out.println("Discarded Points for :  " + pointcount);
			
			Point geom = fac.createPoint(coord);
			geography.move(monarch, geom);
			
			
		}
		
		//Load features from a shapefile - this section now occurs above, but these are saved for reference
		
		//first shapefile with original probEggs that are too high
		//loadFeatures( "data/Testshapefile3.shp", context, geography);
		//shapefile with 50% of original probEggs
		//loadFeatures( "data/Testshapefile50percent.shp", context, geography);
		//shapefile with 10% of original probEggs
		//loadFeatures( "data/Testshapefile10percent.shp", context, geography);
		//shapefile with 10% of original probEggs and area in m^2, but doesn't load up because its in NAD83
		//loadFeatures( "data/Testshapefile10percentArea3.shp", context, geography);
		//shapefile with a lot of fake good habitat - loads up crappy
		//loadFeatures( "data/TestShapefileRndGoodhabitat3.shp", context, geography);
		//2nd test shapefile
		//loadFeatures("data/TestShapefile2latlon_sp.shp", context, geography);
		//Full Story Co
		//loadFeatures("data/StoryCoB19_sp.shp", context, geography);
		//Full Story Co with new probMove parameter - test case 1
		//loadFeatures("data/StoryCo_probMove.shp", context, geography);
		//Full Story Co with new probMove parameter - test case 2
		//loadFeatures("data/StoryCo_probMove-testcase2.shp", context, geography);
		//St Co subset for MS figure
		//loadFeatures("data/MSfigure_FINAL.shp", context, geography);
		//St Co subset for MS figure
		//loadFeatures("data/MSfigure2_FINAL.shp", context, geography);
		//Grid landscape, same place as MS figure 2
		//loadFeatures("data/GridLL.shp", context, geography);
		//Tox Sims Scen 1
		//loadFeatures("data/ToxScen1B.shp", context, geography);
		//Tox Sims Scen 2
		//loadFeatures("data/ToxScen2B.shp", context, geography);
		//MCSP7
		//loadFeatures("data/StoryCo_MCSP7_FINAL2.shp", context, geography);
		//MCSP8
		//loadFeatures("data/StoryCo_MCSP8_FINAL.shp", context, geography);
		//NW IA Clip
		//loadFeatures("data/reclass_usgs_nwia_poly3_clip_sp_GCS.shp", context, geography);
		//Test shapefile West Lyon Co
		//loadFeatures("data/WestLyonCo_CDL_GCS_sp.shp", context, geography);
		//Test shapefile with all probEggs = 0.1 of full Story Co
		//loadFeatures("data/StoryCoB19_sp_testprob.shp", context, geography);
		//Farm Progress Show - Current Conditions
		//loadFeatures("data/FarmProgressShow5.shp", context, geography);
		//Farm Progress Show - improved habitat
		//loadFeatures("data/FarmProgressShow14.shp", context, geography);
		//Cory1_FINAL2.shp test
		//loadFeatures("data/Cory1_FINAL2.shp", context, geography);
		//Jackie_FINAL2.shp test
		//loadFeatures("data/Jackie_FINAL2.shp", context, geography);
		//Juliasffinalmap.shp test
		//loadFeatures("data/Juliasffinalmap.shp", context, geography);
		//Alec_Counties_1_final.shp
		//loadFeatures("data/Alec_Counties_1_Final.shp", context, geography);
		//Brookes_Counties_1_Final.shp
		//loadFeatures("data/Brookes_Counties_1_Final.shp", context, geography);
		//First Landscape Toxicology Sim
		//loadFeatures("data/StoryCoToxFieldBuffer_Eli10IntLL.shp", context, geography);
		//Second Landscape Toxicology Scenario with maximum augmentation
		//loadFeatures("data/StoryCoToxFieldBufferMaxAugLL.shp", context, geography);
		//Third Landscape Toxicology Scenario with medium augmentation
		//loadFeatures("data/StoryCoToxFieldBufferMedAugLL.shp", context, geography);
		//Fourth Landscape Toxicology Scenario with augmentation outside buffer
		//loadFeatures("data/StoryCoToxFieldBufferAugOutsideLL.shp", context, geography);
		return context;
	}

	private void loadFeatures (String filename, Context context, Geography geography){
		URL url = null;
		try {
			url = new File(filename).toURL();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		List<SimpleFeature> features = new ArrayList<SimpleFeature>();
		
		SimpleFeatureIterator fiter = null;
		ShapefileDataStore store = null;
		store = new ShapefileDataStore(url);
		
		try {
			fiter = store.getFeatureSource().getFeatures().features();
			
			while(fiter.hasNext()){
				features.add(fiter.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			fiter.close();
			store.dispose();
		}
		
		double ind = 0;
		// For each features in the file
		for (SimpleFeature feature : features){
			Geometry geom = (Geometry)feature.getDefaultGeometry();
			Object agent = null;
			
			// For Polygons, create ZoneAgents
			if (geom instanceof MultiPolygon){
				MultiPolygon mp = (MultiPolygon)feature.getDefaultGeometry();
				geom = (Polygon)mp.getGeometryN(0);
				ind = ind + 1;
				
				// Read the feature attributes an assign to the ZoneAgent
				double ID = ind;
				//long FID = (long)feature.getAttribute("FID"); //won't get FID for some reason
				//long OBJECTID_1 = (long)feature.getAttribute("OBJECTID_1"); //for St Co shapefile
				//double Shape_Leng = (double)feature.getAttribute("Shape_Leng");
				String name = (String)feature.getAttribute("CLASS_NAME");
				double zonearea = (double)feature.getAttribute("Shape_Area");
				double probEggs = (double)feature.getAttribute("ProbEggs");
				double probMove = (double)feature.getAttribute("probMove");
				long GISPolyID = (long)feature.getAttribute("GISPolyID");
				int cumulativeeggs = 0;
				
				//agent = new ZoneAgent(ID,Shape_Leng,name,cumulativeeggs,probEggs,zonearea);
				agent = new ZoneAgent(ID,name,cumulativeeggs,probEggs,probMove,zonearea,GISPolyID);
				
				//if (!geom.isValid()) System.out.println("Invalid geometry: " + feature.getID() + agent.OBJECTID_1);
				
				// I didn't create buffer like GIS example
				// also didn't have else's for this if statement
			}
		
			if (agent != null){
				context.add(agent);
				geography.move(agent, geom);
			}
			else{
				System.out.println("Error creating agent for " + geom);
			}
		}
	}
}
