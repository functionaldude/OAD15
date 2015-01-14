package oad;

public class Coordinate {
	private int x;
	private int y;
	private Boolean onServer;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
		onServer = false;
	}
	
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Boolean isUploaded(){
		return onServer;
	}
	public void setServerStatus(Boolean input){
		onServer = input;
	}
}
