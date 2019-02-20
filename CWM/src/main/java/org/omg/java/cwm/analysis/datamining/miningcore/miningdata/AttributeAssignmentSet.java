package org.omg.java.cwm.analysis.datamining.miningcore.miningdata;

import java.util.ArrayList;

import org.omg.java.cwm.objectmodel.core.*;

/**
 * CWM Class
 *
 * This object contains a set of AttributeAssignment objects and completes attribute
 * assignment for a mining operation.
 *
 * @author Ivan Holod
 *
 */
public class AttributeAssignmentSet extends ModelElement {

	/**
	 * This reference points to one or more AttributeAssignment objects contained in the assignment
	 * set.
	 */
	protected ArrayList<AttributeAssignment> assignment;


}