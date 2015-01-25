package oad;

import java.awt.Point;

public class Connection {
	
	private Point begin, end;
	
	public Connection(Point begin, Point end){
		this.begin = begin;
		this.end = end;
	}

	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	
}
