import java.io.Serializable;


public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId;
	private String reviewId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHelpfulNess() {
		return helpfulNess;
	}
	public void setHelpfulNess(String helpfulNess) {
		this.helpfulNess = helpfulNess;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	private String name;
	private String helpfulNess;
	private String score;
	private String time;
	private String summary;
	private String reviewText;
	
	
	public String toString(){
		return productId+","+reviewId+","+name+","+helpfulNess+","+score+","+time+","+summary+","+reviewText;
	}

}
