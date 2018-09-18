package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public abstract class ASTNode {
	
	/**
	 * The corresponding source code
	 */
	protected ParserSourceCorrespondence psc;
	
	/**
	 * Builds a new tree node
	 *
	 * @param lineNumber
	 *            the line in the source file from which this node came.
	 */
	protected ASTNode(ParserSourceCorrespondence sc) {
		this.psc = sc;
	}
	
	/**
	 * Sets the values of this node object to the values of a given node.
	 *
	 * @param other
	 *            the other node
	 * @return this node
	 */
	public ASTNode set(ASTNode other) {
		this.psc = other.psc;
		return this;
	}

	/**
	 * Returns the corresponding source code this ASTNode represents
	 *
	 * @return the line number
	 */
	public ParserSourceCorrespondence getParserSourceCorrespondence() {
		return psc;
	}
	
	public String toString(){
		return "ASTNode " + this.getClass().getSimpleName() + " [" + psc.toString() + "]";
	}

}