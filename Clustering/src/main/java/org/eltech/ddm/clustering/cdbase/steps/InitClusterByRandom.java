package org.eltech.ddm.clustering.cdbase.steps;

import java.util.Random;

import org.eltech.ddm.clustering.ClusteringMiningModel;
import org.eltech.ddm.clustering.cdbase.Coordinate;
import org.eltech.ddm.inputdata.MiningInputStream;
import org.eltech.ddm.inputdata.MiningVector;
import org.eltech.ddm.miningcore.MiningException;
import org.eltech.ddm.miningcore.algorithms.DataMiningBlock;
import org.eltech.ddm.miningcore.algorithms.MiningBlock;
import org.eltech.ddm.miningcore.miningfunctionsettings.EMiningFunctionSettings;
import org.eltech.ddm.miningcore.miningmodel.EMiningModel;
import org.eltech.ddm.miningcore.miningmodel.LogicalAttributeElement;

public class InitClusterByRandom extends DataMiningBlock {
	final private Random rand;

	public InitClusterByRandom(EMiningFunctionSettings settings)
			throws MiningException {
		super(settings);
		rand = new Random(10);
	}

	@Override
	protected EMiningModel execute(MiningInputStream data, EMiningModel model) throws MiningException {
		int iAttr = model.getCurrentAttributeIndex();
		int iCluster = ((ClusteringMiningModel)model).getCurrentClusterIndex();

		Coordinate c = ((ClusteringMiningModel)model).getClusterCenterCoordinate(iCluster, iAttr);

		int countVectors = data.getVectorsNumber();

		int indexVector = Math.abs(rand.nextInt(countVectors));
		MiningVector vector =  data.getVector(indexVector);
		c.setValue(vector.getValue(iAttr));

		return model;
	}
}
