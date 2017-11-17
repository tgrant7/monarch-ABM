package monarchs;

import java.awt.geom.GeneralPath;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.graph.RepastEdge;
import repast.simphony.util.ContextUtils;

import com.vividsolutions.jts.geom.Coordinate;

/**
 * Represents Monarch path objects.  Needed to visualize the bat paths 
 * as the network needs to visualize as objects in the GIS.
 * 
 */
public class MonarchPath {

		// The NetworkEdge which represents this Path in the bat path network
		public RepastEdge edge;
		GeneralPath path;
		
		public MonarchPath(RepastEdge e, Coordinate c1, Coordinate c2) {
			this.edge = e;
			setPath(c1,c2);	           
 		}
				
		public void setPath(Coordinate c1, Coordinate c2){
            //Create a general path which will go through all our vertices.
            path = new GeneralPath();
            
            //Move to the first vertex.
            path.moveTo(c1.x, c1.y);
            path.lineTo(c2.x,c2.y);           

            //Close the path.
            path.closePath();
            
		}
		
		public GeneralPath getPath(){
			return path;
		}
		
		/**
		 * Get the RepastEdge which represents this path object
		 * 
		 * @return the edge
		 */
		public RepastEdge getEdge() {
			return edge;
		}

		/**
		 * @param edge
		 *            the edge to set
		 */
		public void setEdge(RepastEdge edge) {
			this.edge = edge;
		}
}
