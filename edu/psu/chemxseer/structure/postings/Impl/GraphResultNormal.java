package edu.psu.chemxseer.structure.postings.Impl;

import de.parmol.graph.Graph;
import edu.psu.chemxseer.structure.postings.Interface.IGraphResult;

/**
 * The normal implementation of gGraphResults containing one graph and one graph
 * ID.
 * 
 * @author dayuyuan
 * 
 */
public class GraphResultNormal implements IGraphResult {
	protected int gID;
	protected Graph g;

	public GraphResultNormal(int ID, Graph g) {
		this.gID = ID;
		this.g = g;
	}

	public Graph getG() {
		return g;
	}

	public int getID() {
		return gID;
	}

	public int getDocID() {
		return this.gID;
	}

	public String toString() {
		return (new Integer(gID)).toString();
	}

	public int compareTo(IGraphResult o) {
		int id1 = this.getID();
		int id2 = o.getID();
		if (id1 < id2)
			return -1;
		else if (id1 == id2)
			return 0;
		else
			return 1;
	}

}
