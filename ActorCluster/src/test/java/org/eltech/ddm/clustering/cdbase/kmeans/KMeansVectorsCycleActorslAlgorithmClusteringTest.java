package org.eltech.ddm.clustering.cdbase.kmeans;

import org.eltech.ddm.clustering.AggregationFunction;
import org.eltech.ddm.clustering.ClusteringFunctionSettings;
import org.eltech.ddm.clustering.ClusteringMiningModel;
import org.eltech.ddm.clustering.cdbase.CDBasedClusteringMiningModel;
import org.eltech.ddm.environment.DataDistribution;
import org.eltech.ddm.environment.NodeSettings;
import org.eltech.ddm.frotend.environment.ActorsExecutionEnvironment;
import org.eltech.ddm.frotend.environment.ActorsExecutionEnvironmentSettings;
import org.eltech.ddm.inputdata.file.MiningArffStream;
import org.eltech.ddm.miningcore.algorithms.MiningAlgorithm;
import org.eltech.ddm.miningcore.miningdata.ELogicalData;
import org.eltech.ddm.miningcore.miningtask.EMiningBuildTask;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;


public class KMeansVectorsCycleActorslAlgorithmClusteringTest {

    private final int NUMBER_HANDLERS = 8;

    protected KMeansAlgorithmSettings miningAlgorithmSettings;
    protected MiningAlgorithm algorithm;

    @Before
    public void setUp() throws Exception {
        // Create mining algorithm settings
        miningAlgorithmSettings = new KMeansAlgorithmSettings();
        miningAlgorithmSettings.setAlgorithm("KMeans");
        miningAlgorithmSettings.setMaxNumberOfIterations(50);
        miningAlgorithmSettings.setEps(0.5);
    }


    /**
     * Cluster nodes must be launched before the test starts.
     * Example ServiceMain.exe 127.0.0.1 2551 8 4 127.0.0.1:2551
     */
    @Test
    public void test4ActorsIrisSingleNode() {

        try {
            // Load input data
            MiningArffStream inputData1 = new MiningArffStream("..\\data\\arff\\iris1-2.arff");
            MiningArffStream inputData2 = new MiningArffStream("..\\data\\arff\\iris2-2.arff");


//            //get map to user interface (direct) - for settings
//            Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = inputData.getMapAttributes();
//
//            //assignment settings
//            AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);
//
//            PhysicalAttribute physatt_1 = new PhysicalAttribute();
////		physatt_1.setDataType(AttributeDataType.stringType);
//            physatt_1.setName("sepallength");
//
//            PhysicalAttribute physatt_2 = new PhysicalAttribute();
////		physatt_2.setDataType(AttributeDataType.stringType);
//            physatt_2.setName("sepalwidth");
//
//            PhysicalAttribute physatt_3 = new PhysicalAttribute();
////		physatt_3.setDataType(AttributeDataType.stringType);
//            physatt_3.setName("petallength");
//
//            PhysicalAttribute physatt_4 = new PhysicalAttribute();
////		physatt_4.setDataType(AttributeDataType.doubleType);
//            physatt_4.setName("petalwidth");
//
//            ELogicalAttribute attribute_l_1 = new ELogicalAttribute("sepallength", AttributeType.numerical);
//            ELogicalAttribute attribute_l_2 = new ELogicalAttribute("sepalwidth", AttributeType.numerical);
//            ELogicalAttribute attribute_l_3 = new ELogicalAttribute("petallength", AttributeType.numerical);
//            ELogicalAttribute attribute_l_4 = new ELogicalAttribute("petalwidth", AttributeType.numerical);
//
//            Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
//            new_user_map_attributes.put(physatt_1, attribute_l_1);
//            new_user_map_attributes.put(physatt_2, attribute_l_2);
//            new_user_map_attributes.put(physatt_3, attribute_l_3);
//            new_user_map_attributes.put(physatt_4, attribute_l_4);
//
//            //assignmentManager.putLogicalAttributes(new_user_map_attributes);
//            assignmentManager.setAttributeSettings(new_user_map_attributes);
//
//            inputData.setAssignmentManager(assignmentManager);

            ELogicalData logicalData = inputData1.getLogicalData();

            //Create settings for classification
            ClusteringFunctionSettings miningSettings = new ClusteringFunctionSettings(logicalData);
            miningSettings.setAlgorithmSettings(miningAlgorithmSettings);
            miningSettings.verify();

            // Assign settings:
            miningSettings.setMaxNumberOfClusters(3);
            miningSettings.setAggregationFunction(AggregationFunction.euclidian);
            miningSettings.verify();

            ActorsExecutionEnvironmentSettings executionSettings = new ActorsExecutionEnvironmentSettings(
                    new NodeSettings("127.0.0.1",2551, 4,inputData1),
                    new NodeSettings("127.0.0.1",2551, 4,inputData2),
                    new NodeSettings("127.0.0.1",2551, 4)
            );
            executionSettings.setDataDistribution(DataDistribution.HORIZONTAL_DISTRIBUTION);

            ActorsExecutionEnvironment environment = new ActorsExecutionEnvironment(executionSettings);

            MiningAlgorithm algorithm = new KMeansAlgorithm(miningSettings);

            EMiningBuildTask buildTask = new EMiningBuildTask();
            buildTask.setMiningAlgorithm(algorithm);
            buildTask.setMiningSettings(miningSettings);
            buildTask.setExecutionEnvironment(environment);
            ClusteringMiningModel model = (ClusteringMiningModel) buildTask.execute();

            System.out.println("number of clusters: " + model.getElement(CDBasedClusteringMiningModel.INDEX_CLUSTERS).size());
            System.out.println("cluster model: " + model);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


}
