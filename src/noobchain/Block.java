package noobchain;

import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data; //simple message
	private long timeStamp; //number of milliseconds
	
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedHash = StringUtil.applysha256(
						previousHash +
						Long.toString(timeStamp) +
						data
						);
		return calculatedHash;
	}

}
