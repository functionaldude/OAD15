package oad;
import java.lang.Exception;

public class game {
	//initial data
	private String name;
	private int rating[];
	
	public game(String input_name){
		this.name = input_name;
		this.rating = new int[] {0,0};
	}
	public String getName(){
		return name;
	}
	public float getRating() throws Exception{
		if (this.rating[1] > 5){
			return this.rating[0] / this.rating[1];
		} else {
			throw new Exception("NotEnoughRating");
		}
	}
	public void addRating(int input_rating) throws Exception{
		if (input_rating > 5 || input_rating < 1){
			throw new Exception("Invalid_Rating");
		} else {
			this.rating[0] += input_rating;
			this.rating[1]++;
		}
	}
}
