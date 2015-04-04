package edu.psu.chemxseer.structure.postings.Impl;

import java.text.ParseException;

import de.parmol.graph.Graph;
import edu.psu.chemxseer.structure.postings.Interface.IGraphs;
import edu.psu.chemxseer.structure.preprocess.MyFactory;
import edu.psu.chemxseer.structure.subsearch.Impl.indexfeature.NoPostingFeatures;
import edu.psu.chemxseer.structure.subsearch.Interfaces.IOneFeature;

public class Graphs implements IGraphs {
	private NoPostingFeatures<IOneFeature> features;

	public Graphs(NoPostingFeatures<IOneFeature> features) {
		this.features = features;
	}

	public int getSupport(int gID) {
		return this.features.getFeature(gID).getFrequency();
	}

	public boolean createGraphs() throws ParseException {
		return this.features.createGraphs();
	}

	public Graph getGraph(int gID) {
		IOneFeature feature = this.features.getFeature(gID);
		if (feature.getFeatureGraph() == null)
			return MyFactory.getDFSCoder().parse(feature.getDFSCode(),
					MyFactory.getGraphFactory());
		else
			return feature.getFeatureGraph();
	}

	public int getGraphNum() {
		return this.features.getfeatureNum();
	}

	public String getLabel(int gID) {
		return this.features.getFeature(gID).getDFSCode();
	}
}
