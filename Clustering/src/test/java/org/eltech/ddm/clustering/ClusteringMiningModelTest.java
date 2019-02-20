package org.eltech.ddm.clustering;

import org.eltech.ddm.clustering.cdbase.CDBasedClusteringMiningModel;
import org.eltech.ddm.inputdata.MiningArrayStream;
import org.eltech.ddm.inputdata.MiningInputStream;
import org.eltech.ddm.inputdata.file.MiningArffStream;
import org.eltech.ddm.miningcore.MiningException;
import org.eltech.ddm.miningcore.miningdata.ELogicalAttribute;
import org.eltech.ddm.miningcore.miningdata.ELogicalData;
import org.eltech.ddm.miningcore.miningdata.PhysicalAttribute;
import org.eltech.ddm.miningcore.miningdata.assignment.AssignmentManager;
import org.eltech.ddm.miningcore.miningdata.assignment.AttributeAssignmentType;
import org.eltech.ddm.miningcore.miningfunctionsettings.EMiningAlgorithmSettings;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.AttributeType;

import java.util.HashMap;
import java.util.Map;


public class ClusteringMiningModelTest {
	
	protected MiningInputStream inputData;
	protected ELogicalData logicalData;
	protected ClusteringFunctionSettings  miningSettings;
	protected ClusteringMiningModel  model;

	// ==== Methods for data attributes Iris ===============
	protected void setInputData4Iris() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\iris.arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("sepallength");

		PhysicalAttribute physatt_2 = new PhysicalAttribute();
//		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("sepalwidth");

		PhysicalAttribute physatt_3 = new PhysicalAttribute();
//		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("petallength");

		PhysicalAttribute physatt_4 = new PhysicalAttribute();
//		physatt_4.setDataType(AttributeDataType.doubleType);
		physatt_4.setName("petalwidth");

		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("sepallength", AttributeType.numerical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("sepalwidth", AttributeType.numerical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("petallength", AttributeType.numerical);
		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("petalwidth", AttributeType.numerical);

		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
		new_user_map_attributes.put(physatt_4, attribute_l_4);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}


	protected void setMiningSettings4Iris(EMiningAlgorithmSettings algorithmSettings) throws MiningException {

		ELogicalData logicalData = inputData.getLogicalData();

		//Create settings for classification
		miningSettings = new ClusteringFunctionSettings(logicalData);
		miningSettings.setAlgorithmSettings(algorithmSettings);
		miningSettings.verify();

	}


	// ==== Methods for data attributes Azure Iris ===============
	protected void setInputData4AzureIris() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Iris Two Class Data(V100A5).arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("sepal-length");

		PhysicalAttribute physatt_2 = new PhysicalAttribute();
//		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("sepal-width");

		PhysicalAttribute physatt_3 = new PhysicalAttribute();
//		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("petal-length");

		PhysicalAttribute physatt_4 = new PhysicalAttribute();
//		physatt_4.setDataType(AttributeDataType.doubleType);
		physatt_4.setName("petal-width");

		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("sepallength", AttributeType.numerical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("sepalwidth", AttributeType.numerical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("petallength", AttributeType.numerical);
		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("petalwidth", AttributeType.numerical);

		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
		new_user_map_attributes.put(physatt_4, attribute_l_4);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}

	// ==== Methods for data attributes Azure Weather ===============
	protected void setInputData4AzureWeather() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Weather Dataset(V406516A26).arff");

//		//get map to user interface (direct) - for settings
//		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();
//
//		//assignment settings
//		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);
//
//		PhysicalAttribute physatt_1 = new PhysicalAttribute();
////		physatt_1.setDataType(AttributeDataType.stringType);
//		physatt_1.setName("sepal-length");
//
//		PhysicalAttribute physatt_2 = new PhysicalAttribute();
////		physatt_2.setDataType(AttributeDataType.stringType);
//		physatt_2.setName("sepal-width");
//
//		PhysicalAttribute physatt_3 = new PhysicalAttribute();
////		physatt_3.setDataType(AttributeDataType.stringType);
//		physatt_3.setName("petal-length");
//
//		PhysicalAttribute physatt_4 = new PhysicalAttribute();
////		physatt_4.setDataType(AttributeDataType.doubleType);
//		physatt_4.setName("petal-width");
//
//		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("sepallength", AttributeType.numerical);
//		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("sepalwidth", AttributeType.numerical);
//		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("petallength", AttributeType.numerical);
//		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("petalwidth", AttributeType.numerical);
//
//		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
//		new_user_map_attributes.put(physatt_1, attribute_l_1);
//		new_user_map_attributes.put(physatt_2, attribute_l_2);
//		new_user_map_attributes.put(physatt_3, attribute_l_3);
//		new_user_map_attributes.put(physatt_4, attribute_l_4);
//
//		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
//		assignmentManager.setAttributeSettings(new_user_map_attributes);
//
//		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}



	// ==== Methods for data attributes Iris ===============
	protected void setInputData4TimeSeries() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Time series(V126A1).arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("N1725");


		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("N1725", AttributeType.numerical);

		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}


	// ==== Methods for data attributes Telescope Data ===============
	protected void setInputData4TelescopeData() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Telescope data(V19020A11).arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("fLength");

		PhysicalAttribute physatt_2 = new PhysicalAttribute();
//		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("fWidth");

		PhysicalAttribute physatt_3 = new PhysicalAttribute();
//		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("fSize");

		PhysicalAttribute physatt_4 = new PhysicalAttribute();
//		physatt_4.setDataType(AttributeDataType.doubleType);
		physatt_4.setName("fConc");
		
		PhysicalAttribute physatt_5 = new PhysicalAttribute();
//		physatt_5.setDataType(AttributeDataType.doubleType);
		physatt_5.setName("fConcl");
		
		PhysicalAttribute physatt_6 = new PhysicalAttribute();
//		physatt_6.setDataType(AttributeDataType.doubleType);
		physatt_6.setName("fAsym");
		
		PhysicalAttribute physatt_7 = new PhysicalAttribute();
//		physatt_7.setDataType(AttributeDataType.doubleType);
		physatt_7.setName("fM3Long");
		
		PhysicalAttribute physatt_8 = new PhysicalAttribute();
//		physatt_8.setDataType(AttributeDataType.doubleType);
		physatt_8.setName("fM3Trans");
		
		PhysicalAttribute physatt_9 = new PhysicalAttribute();
//		physatt_9.setDataType(AttributeDataType.doubleType);
		physatt_9.setName("fAlpha");
		
		PhysicalAttribute physatt_10 = new PhysicalAttribute();
//		physatt_10.setDataType(AttributeDataType.doubleType);
		physatt_10.setName("fDist");

		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("fLength", AttributeType.numerical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("fWidth", AttributeType.numerical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("fSize", AttributeType.numerical);
		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("fConc", AttributeType.numerical);
		ELogicalAttribute attribute_l_5 = new ELogicalAttribute("fConcl", AttributeType.numerical);
		ELogicalAttribute attribute_l_6 = new ELogicalAttribute("fAsym", AttributeType.numerical);
		ELogicalAttribute attribute_l_7 = new ELogicalAttribute("fM3Long", AttributeType.numerical);
		ELogicalAttribute attribute_l_8 = new ELogicalAttribute("fM3Trans", AttributeType.numerical);
		ELogicalAttribute attribute_l_9 = new ELogicalAttribute("fAlpha", AttributeType.numerical);
		ELogicalAttribute attribute_l_10 = new ELogicalAttribute("fDist", AttributeType.numerical);

		
		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
		new_user_map_attributes.put(physatt_4, attribute_l_4);
		new_user_map_attributes.put(physatt_5, attribute_l_5);
		new_user_map_attributes.put(physatt_6, attribute_l_6);
		new_user_map_attributes.put(physatt_7, attribute_l_7);
		new_user_map_attributes.put(physatt_8, attribute_l_8);
		new_user_map_attributes.put(physatt_9, attribute_l_9);
		new_user_map_attributes.put(physatt_10, attribute_l_10);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}

	// ==== Methods for data attributes Iris ===============
	protected void setInputData4BreastCancerInfo() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Breast Cancer Info (V102294A12).arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("Col5");

		PhysicalAttribute physatt_2 = new PhysicalAttribute();
//		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("Col8");

		PhysicalAttribute physatt_3 = new PhysicalAttribute();
//		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("Col9");

		PhysicalAttribute physatt_4 = new PhysicalAttribute();
//		physatt_4.setDataType(AttributeDataType.doubleType);
		physatt_4.setName("Col10");
		
		PhysicalAttribute physatt_5 = new PhysicalAttribute();
//		physatt_5.setDataType(AttributeDataType.doubleType);
		physatt_5.setName("Col11");


		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("Col5", AttributeType.numerical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("Col8", AttributeType.numerical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("Col9", AttributeType.numerical);
		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("Col10", AttributeType.numerical);
		ELogicalAttribute attribute_l_5 = new ELogicalAttribute("Col11", AttributeType.numerical);
		
		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
		new_user_map_attributes.put(physatt_4, attribute_l_4);
		new_user_map_attributes.put(physatt_5, attribute_l_5);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}

	// ==== Methods for data attributes Iris ===============
	protected void setInputData4BreastCancerFeatures() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Breast Cancer Features (V102294A118).arff");

		inputData = new MiningArrayStream(inputData);
	}
	
	// ==== Methods for data attributes Iris ===============
	protected void setInputData4MovieRatings() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Movie Ratings(V227472A4).arff");

//		//get map to user interface (direct) - for settings
//		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();
//
//		//assignment settings
//		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);
//
//		PhysicalAttribute physatt_1 = new PhysicalAttribute();
////		physatt_1.setDataType(AttributeDataType.stringType);
//		physatt_1.setName("sepal-length");
//
//		PhysicalAttribute physatt_2 = new PhysicalAttribute();
////		physatt_2.setDataType(AttributeDataType.stringType);
//		physatt_2.setName("sepal-width");
//
//		PhysicalAttribute physatt_3 = new PhysicalAttribute();
////		physatt_3.setDataType(AttributeDataType.stringType);
//		physatt_3.setName("petal-length");
//
//		PhysicalAttribute physatt_4 = new PhysicalAttribute();
////		physatt_4.setDataType(AttributeDataType.doubleType);
//		physatt_4.setName("petal-width");
//
//		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("sepallength", AttributeType.numerical);
//		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("sepalwidth", AttributeType.numerical);
//		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("petallength", AttributeType.numerical);
//		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("petalwidth", AttributeType.numerical);
//
//		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
//		new_user_map_attributes.put(physatt_1, attribute_l_1);
//		new_user_map_attributes.put(physatt_2, attribute_l_2);
//		new_user_map_attributes.put(physatt_3, attribute_l_3);
//		new_user_map_attributes.put(physatt_4, attribute_l_4);
//
//		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
//		assignmentManager.setAttributeSettings(new_user_map_attributes);
//
//		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}


	// ==== Methods for data attributes Iris ===============
	protected void setInputData4FlightDelaysData() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Flight Delays Data(V2719418A14).arff");

		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();

		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);

		PhysicalAttribute physatt_1 = new PhysicalAttribute();
//		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("OriginAirportID");

		PhysicalAttribute physatt_2 = new PhysicalAttribute();
//		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("DestAirportID");

		PhysicalAttribute physatt_3 = new PhysicalAttribute();
//		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("CRSDepTime");

//		PhysicalAttribute physatt_4 = new PhysicalAttribute();
////		physatt_4.setDataType(AttributeDataType.doubleType);
//		physatt_4.setName("DepDelay");
		
		PhysicalAttribute physatt_5 = new PhysicalAttribute();
//		physatt_5.setDataType(AttributeDataType.doubleType);
		physatt_5.setName("CRSArrTime");

		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("OriginAirportID", AttributeType.numerical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("DestAirportID", AttributeType.numerical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("CRSDepTime", AttributeType.numerical);
//		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("DepDelay", AttributeType.numerical);
		ELogicalAttribute attribute_l_5 = new ELogicalAttribute("CRSArrTime", AttributeType.numerical);

		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
//		new_user_map_attributes.put(physatt_4, attribute_l_4);
		new_user_map_attributes.put(physatt_5, attribute_l_5);

		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);

		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}

	
	protected void setInputData4FlightOnTimePerformance() throws MiningException {
		// Load input data
		inputData = new MiningArffStream("..\\data\\arff\\Azure\\Flight on-time performance (Raw)(V504397A18).arff");

//		//get map to user interface (direct) - for settings
//		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();
//
//		//assignment settings
//		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);
//
//		PhysicalAttribute physatt_1 = new PhysicalAttribute();
////		physatt_1.setDataType(AttributeDataType.stringType);
//		physatt_1.setName("OriginAirportID");
//
//		PhysicalAttribute physatt_2 = new PhysicalAttribute();
////		physatt_2.setDataType(AttributeDataType.stringType);
//		physatt_2.setName("DestAirportID");
//
//		PhysicalAttribute physatt_3 = new PhysicalAttribute();
////		physatt_3.setDataType(AttributeDataType.stringType);
//		physatt_3.setName("CRSDepTime");
//
////		PhysicalAttribute physatt_4 = new PhysicalAttribute();
//////		physatt_4.setDataType(AttributeDataType.doubleType);
////		physatt_4.setName("DepDelay");
//		
//		PhysicalAttribute physatt_5 = new PhysicalAttribute();
////		physatt_5.setDataType(AttributeDataType.doubleType);
//		physatt_5.setName("CRSArrTime");
//
//		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("OriginAirportID", AttributeType.numerical);
//		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("DestAirportID", AttributeType.numerical);
//		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("CRSDepTime", AttributeType.numerical);
////		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("DepDelay", AttributeType.numerical);
//		ELogicalAttribute attribute_l_5 = new ELogicalAttribute("CRSArrTime", AttributeType.numerical);
//
//		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
//		new_user_map_attributes.put(physatt_1, attribute_l_1);
//		new_user_map_attributes.put(physatt_2, attribute_l_2);
//		new_user_map_attributes.put(physatt_3, attribute_l_3);
////		new_user_map_attributes.put(physatt_4, attribute_l_4);
//		new_user_map_attributes.put(physatt_5, attribute_l_5);
//
//		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
//		assignmentManager.setAttributeSettings(new_user_map_attributes);
//
//		inputData.setAssignmentManager(assignmentManager);
		inputData = new MiningArrayStream(inputData);
	}



	/**
	 * Shows clusters.
	 *
	 * @param clustModel
	 *            clustering model to show
	 * @throws MiningException
	 *             cannot show clusters
	 */
	public void showClusters(ClusteringMiningModel clustModel)
			throws MiningException {

		System.out.println("number of clusters: " + clustModel.getElement(CDBasedClusteringMiningModel.INDEX_CLUSTERS).size());
		System.out.println("cluster model: " + clustModel);

	}


}
