package org.eltech.ddm.miningcore.miningdata.assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.datamining.data.AttributeDataType;

import org.eltech.ddm.associationrules.AssociationRulesFunctionSettings;
import org.eltech.ddm.associationrules.apriori.AprioriAlgorithm;
import org.eltech.ddm.associationrules.apriori.AprioriAlgorithmSettings;
import org.eltech.ddm.associationrules.apriori.AprioriMiningModel;
import org.eltech.ddm.inputdata.file.MiningArffStream;
import org.eltech.ddm.miningcore.MiningException;
import org.eltech.ddm.miningcore.miningdata.ELogicalAttribute;
import org.eltech.ddm.miningcore.miningdata.ELogicalData;
//import org.eltech.ddm.miningcore.miningdata.PhysicalAttribute;
import org.eltech.ddm.miningcore.miningdata.PhysicalAttribute;
import org.eltech.ddm.miningcore.miningdata.assignment.AssignmentManager;
import org.eltech.ddm.miningcore.miningdata.assignment.AttributeAssignmentType;
import org.junit.Test;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.AttributeSelectionFunction;
//import org.eltech.ddm.transformation.assignments.AssignmentFactory;
//import org.eltech.ddm.transformation.assignments.MiningLogicalArffStream;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.AttributeType;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.ValueSelectionFunction;

public class TestDirectAssignmentStream {
	private String fileSmallTransact1 = "../data/arff/assignment_test/direct_transact_small_test_assignment.arff";
	private String fileSmallTransact2 = "../data/arff/assignment_test/direct_transact_small_2.arff";
	
//	@Test
//	public void testDirectAssignmentSmallTransact1() throws MiningException {
//		directAssignmentSmallTransact(fileSmallTransact1);
//	}
	
	@Test
	public void testDirectAssignmentSmallTransact2() throws MiningException {
		directAssignmentSmallTransact(fileSmallTransact2);
	}
	
	private void directAssignmentSmallTransact(String fileName) throws MiningException {
		MiningArffStream miningArffStream = new MiningArffStream(fileName);
		   
		//get map to user interface (direct) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = miningArffStream.getMapAttributes();
				
		//assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.DirectAttributeAssignment);
		
		PhysicalAttribute physatt_1 = new PhysicalAttribute();
		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("transactId");
		
		PhysicalAttribute physatt_2 = new PhysicalAttribute();
		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("itemId");
	
		PhysicalAttribute physatt_3 = new PhysicalAttribute();
		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("itemName");
			
		PhysicalAttribute physatt_4 = new PhysicalAttribute();
		physatt_4.setDataType(AttributeDataType.doubleType);
		physatt_4.setName("itemPrice");
		
		PhysicalAttribute physatt_5 = new PhysicalAttribute();
		physatt_5.setDataType(AttributeDataType.stringType);
		physatt_5.setName("cat_to_num");
			
		ELogicalAttribute attribute_l_1 = new ELogicalAttribute("transactId_m", AttributeType.categorical);
		ELogicalAttribute attribute_l_2 = new ELogicalAttribute("itemId_m", AttributeType.categorical);
		ELogicalAttribute attribute_l_3 = new ELogicalAttribute("itemName_m", AttributeType.categorical);
		ELogicalAttribute attribute_l_4 = new ELogicalAttribute("itemPrice_m", AttributeType.numerical);
		ELogicalAttribute attribute_l_5 = new ELogicalAttribute("cat_to_num_m", AttributeType.numerical);
		
		Map<PhysicalAttribute, ELogicalAttribute> new_user_map_attributes = new HashMap<PhysicalAttribute, ELogicalAttribute>();
		new_user_map_attributes.put(physatt_1, attribute_l_1);
		new_user_map_attributes.put(physatt_2, attribute_l_2);
		new_user_map_attributes.put(physatt_3, attribute_l_3);
		new_user_map_attributes.put(physatt_4, attribute_l_4);
		new_user_map_attributes.put(physatt_5, attribute_l_5);
		
		//assignmentManager.putLogicalAttributes(new_user_map_attributes);
		assignmentManager.setAttributeSettings(new_user_map_attributes);
		
		miningArffStream.setAssignmentManager(assignmentManager);
		
		startAlgorithm(miningArffStream);
	}
	
	
	private void startAlgorithm(MiningArffStream miningArffStream) throws MiningException{
		Date start = new Date();
		
		ELogicalData logicalData = miningArffStream.getLogicalData(); //old
	
	    AprioriAlgorithmSettings algorithmSettings = new AprioriAlgorithmSettings();
	    algorithmSettings.setNumberOfTransactions(4);
	
	    AssociationRulesFunctionSettings miningSettings = new AssociationRulesFunctionSettings(logicalData);
	    miningSettings.setTransactionIDsArributeName("transactId_m");
	    miningSettings.setItemIDsArributeName("itemId_m");
	    
	    miningSettings.setMinConfidence(0.6);
	    miningSettings.setMinSupport(0.6);
	    miningSettings.setAlgorithmSettings(algorithmSettings);
	
	    AprioriAlgorithm aprioriAlgorithm = new AprioriAlgorithm(miningSettings);
	
	    AprioriMiningModel miningModel = (AprioriMiningModel) aprioriAlgorithm.buildModel(miningArffStream);
	    
		miningModel.getTransactionList().print();		
	   
		Date end = new Date();
		long time = (end.getTime() - start.getTime());
		System.out.println("Total time = " +  time + "�� \nAssociationRuleSet:  \n" + miningModel.getAssociationRuleSet());

	}
	
}
