package com.benjholla.elemental.atlas.indexer;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

public class EMFSourceCorrespondence {

	private IFile source = null;
	private int offset = 0;
	private int length = 0;
	private int startLine = 0;
	private int endLine = 0;

	public EMFSourceCorrespondence(IFile source, EObject object) {
		this.source = source;
		this.offset = 0;
		this.length = 0;
		this.startLine = 0;
		this.endLine = 0;
	}
	
	public EMFSourceCorrespondence(IFile source, int offset, int length, int startLine, int endLine) {
		this.source = source;
		this.offset = offset;
		this.length = length;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	public IFile getSource() {
		return source;
	}
	
	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public int getStartLine() {
		return startLine;
	}
	
	public int getEndLine() {
		return endLine;
	}

	@Override
	public String toString() {
		return "EMFSourceCorrespondence [source=" + source + ", offset=" + offset + ", length=" + length
				+ ", startLine=" + startLine + ", endLine=" + endLine + "]";
	}

}
