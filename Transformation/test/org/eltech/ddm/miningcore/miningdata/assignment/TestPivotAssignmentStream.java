package org.eltech.ddm.miningcore.miningdata.assignment;

import java.util.ArrayList;
import java.util.Map;

import javax.datamining.data.AttributeDataType;

import org.eltech.ddm.inputdata.file.MiningArffStream;
import org.eltech.ddm.miningcore.MiningException;
import org.eltech.ddm.miningcore.miningdata.ELogicalAttribute;
import org.eltech.ddm.miningcore.miningdata.PhysicalAttribute;
import org.junit.Test;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.AttributeSelectionFunction;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.ValueSelectionFunction;

public class TestPivotAssignmentStream {
	private String fileName1 = "../data/arff/assignment_test/pivot_pharmacy.arff";
	
	//true/false
	@Test
	public void pivotAssignment() throws MiningException {
		testPivotAssignment(fileName1);
	}
	
	private void testPivotAssignment(String fileName) throws MiningException {
		MiningArffStream miningArffStream = new MiningArffStream(fileName);
	
		//get map to user interface (direct assignment) - for settings
		Map<PhysicalAttribute, ELogicalAttribute> autoGeneratedAttributes = miningArffStream.getMapAttributes();
		
		//pivot assignment settings
		AssignmentManager assignmentManager = new AssignmentManager(AttributeAssignmentType.PivotAttributeAssignment);
		
		PhysicalAttribute physatt_1 = new PhysicalAttribute();
		physatt_1.setDataType(AttributeDataType.stringType);
		physatt_1.setName("transact_id");
		
		PhysicalAttribute physatt_2 = new PhysicalAttribute();
		physatt_2.setDataType(AttributeDataType.stringType);
		physatt_2.setName("date");
		
		PhysicalAttribute physatt_3 = new PhysicalAttribute();
		physatt_3.setDataType(AttributeDataType.stringType);
		physatt_3.setName("art");

		PhysicalAttribute physatt_4 = new PhysicalAttribute();
		physatt_4.setDataType(AttributeDataType.stringType);
		physatt_4.setName("name");
		
		PhysicalAttribute physatt_5 = new PhysicalAttribute();
		physatt_5.setDataType(AttributeDataType.stringType);
		physatt_5.setName("price");
		
		PhysicalAttribute physatt_6 = new PhysicalAttribute();
		physatt_6.setDataType(AttributeDataType.stringType);
		physatt_6.setName("user_card_number");
		
		PhysicalAttribute physatt_7 = new PhysicalAttribute();
		physatt_7.setDataType(AttributeDataType.stringType);
		physatt_7.setName("user_last_name");
		
		PhysicalAttribute physatt_8 = new PhysicalAttribute();
		physatt_8.setDataType(AttributeDataType.stringType);
		physatt_8.setName("user_first_name");
		
		
//		assignmentManager.setAttributeSettings(attributeSelector, 
//				choosen_attributeSelectionFunction,
//				choosen_valueSelectionFunction);
		
		
//		miningArffStream.setAssignmentManager(assignmentManager);
//		
//		startAlgorithm(miningArffStream);
	}
	
}
