package org.eltech.ddm.miningcore.miningdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.datamining.JDMErrorCodes;
import javax.datamining.JDMException;
import javax.datamining.NamedObject;
import javax.datamining.data.Taxonomy;
import javax.datamining.data.TaxonomyObject;

import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.CategoryMapObject;
import org.omg.java.cwm.analysis.datamining.miningcore.miningdata.CategoryMapObjectEntry;

/**
 * CWM Class
 *
 * This is the object representation of the taxonomy. Each object references a attributes of
 * CategoryMapObjectEntries.
 *
 * @author Ivan Holod
 *
 */
public class ECategoryMapObject extends CategoryMapObject //implements TaxonomyObject
{


	ECategoryMapObject(){
		entry = new ArrayList<CategoryMapObjectEntry>();
	}

	/**
	 * Returns a collection of the children of the specified category.
	 * Parent object must not be null.
	 */
	public Collection getChildren(ECategory parent) throws JDMException {
		ArrayList<Object> children = new ArrayList<Object>();
		for (CategoryMapObjectEntry e : entry) {
			if(e.getParent().equals(parent))
				children.add(e.getChild());
		}

		return children;
	}


	public Collection getLeaves() throws JDMException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a collection of the parent categories of the specified category.
	 * The child object must not be null.
	 */
	public Collection getParents(Object child) throws JDMException {
		ArrayList<Object> parents = new ArrayList<Object>();
		for (CategoryMapObjectEntry e : entry) {
			if(e.getChild().equals(child))
				parents.add(e.getParent());
		}

		return parents;
	}


	public Collection getRoots() throws JDMException {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Establishes parent-child relationships between the specified parent and the specified children.
	 * Neither the parameter parent nor childArray may be null. However, childArray may be empty.
	 * @param parent - parent category
	 * @param childArray - child categories
	 * @throws JDMException
	 */
	public void addChildren(ECategory parent, ECategory[] childArray) throws JDMException {
		if(parent == null)
			throw new JDMException(JDMErrorCodes.JDMR_INVALID_ARGUMENT, "Argument parent not may be null.");

		if(childArray == null)
			throw new JDMException(JDMErrorCodes.JDMR_INVALID_ARGUMENT, "ArgumentchildArray not may be null.");

		for (ECategory category : childArray) {
			CategoryMapObjectEntry entry = new CategoryMapObjectEntry(null, parent, category);
			this.entry.add(entry);
		}
	}


	/**
	 * Removes recursively the parent-child relationships between the specified parent category and its direct children, and so on.
	 * The parameter parent must not be null.
	 * @param parent - The parent category whose decendants are to be removed.
	 * @throws JDMException
	 */
	public void removeDescendants(ECategory parent) throws JDMException {


	}



	public void removeRelationship(Object arg0, Object[] arg1)
			throws JDMException {
		// TODO Auto-generated method stub

	}



}