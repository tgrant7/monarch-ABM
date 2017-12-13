# monarch-ABM
Code for the model described in Grant et al. (in review).  A spatially-explicit landscape-scale agent-based model of monarch butterfly movement and egg-laying implemented in Java in Repast Simphony 2.5.

For those unfamiliar with Eclipse and Repast Simphony, here is one way to get the model running:

Install Repast Simphony and Java SE Development Kit.  

Copy files from GitHub to C:\RepastSimphony-2.5\models\

In Repast Simphony, select File -> Import.  Choose General -> Projects from Folder or Archive.  Set the import source as:  C:\RepastSimphony-2.5\models\Monarchs.  Select the box for the Monarchs folder and hit Finish.  

Click on Java perspective in the upper right corner (the ReLogo perspective is the default)

Right click on "Monarchs" in the package explorer to bring up context menu, go down to Repast Simphony and select Add Repast Simphony Nature.  From the same menu, select Source -> Organize Imports

Select "Run Configurations..." from the context menu or green play button drop down menu.  In the left pane, find Java Application and click the down arrow next to it.  A submenu will open showing the Monarchs model.  Click on the Monarchs Model and hit Run.  

From this point, consult the Repast Simphony help files.  

The shapefile stored here is for Story Co, Iowa, USA.  To run the model with a different shapefile, several changes have to be made to the code to define the boundaries of the shapefile and place the agents at their initial location.  Contact the authors with questions.  


