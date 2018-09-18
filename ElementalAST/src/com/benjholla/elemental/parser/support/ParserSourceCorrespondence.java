package com.benjholla.elemental.parser.support;

import java.io.File;

public class ParserSourceCorrespondence {

	private File source = null;
	private int offset = 0;
	private int length = 0;
	private int startLine = 0;
	private int endLine = 0;

	public ParserSourceCorrespondence(File source, int offset, int length, int startLine, int endLine) {
		this.source = source;
		this.offset = offset;
		this.length = length;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	public File getSource() {
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
		return "ParserSourceCorrespondence [source=" + source + ", offset=" + offset + ", length=" + length
				+ ", startLine=" + startLine + ", endLine=" + endLine + "]";
	}

}
