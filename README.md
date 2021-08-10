# monarch-ABM
This GitHub repository contains the code for the agent-based model described in:  

<i>Grant, T.J., Parry, H.R., Zalucki, M.P. and Bradbury, S.P., 2018. Predicting monarch butterfly (Danaus plexippus) movement and egg-laying with a spatially-explicit agent-based model: the role of monarch perceptual range and spatial memory. Ecological Modelling, 374, pp.37-50.</i> https://doi.org/10.1016/j.ecolmodel.2018.02.011

This model is implemented in Repast Simphony: https://repast.github.io/. Repast Simphony runs within the Eclipse IDE, a platform for coding in the Java programming language. 

For those unfamiliar with Eclipse and Repast Simphony, here is one way to get the model running:

Install Repast Simphony (https://repast.github.io/download.html) and the recommended Java SE Development Kit (https://repast.github.io/requirements.html).  

For Repast Simphony 2.7, released Sept 30, 2019, loading the monarch model is slightly different than in previous versions.  Download the monarch-ABM files from Github to somewhere on your computer and extract them.  In Repast, go to File>New>Other. Scroll down to Repast Simphony folder and select Repast Simphony Project.  This creates the project in Repast with the Repast nature.  Right click on the Monarchs folder in the Package Explorer and choose Import.  Select the File System option and navigate to the extracted Monarchs model.  Click Finish and it is now ready to run.  

You will need a shapefile for the monarch agents to fly around in. The data folder in this repository has the shapefile for Story County, so if you wish that to initially test the model with that you can do so. 

Run the model using the green button or select the Monarchs Model to run. A new window will pop up that says "Monarchs - Repast Simphony." On the lower left, select the tab labeled "Parameters." These are user-specified parameters for the model. Most or all should be familiar from the paper. "Range from max to min probMove" is the range between min and max probMove/probEggs values in the GIS shapefile. To test run the model on a desktop PC, set the number of agents to 3 or something similarly small. Then you hit initialize and then the model can be run. 

To run substantial numbers of monarchs, the model needs to be run on High-Performance Computing systems. Exactly how they will be run on those systems will vary, but typically a model .jar file is created, transferred to the HPC system, and run from there. I have uploaded my personal notes on how I run the model at ISU (Workflow for Running Monarch Model using Slurm on ISU HPC machines.docx), in case they are helpful. Also you can ask questions in the Repast Simphony listserv: https://repast.github.io/support.html. 
