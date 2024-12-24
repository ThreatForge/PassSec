package PassSec;

import java.util.Random;
public class PassSec extends Pass{
	
	public String strength;
	int level;
	
	public PassSec(String password) {
		super(password);
	}
	public int getLevel() {
		return level;
	}
	public String getStrength() {
		return this.strength;
	}
    public int isGreat(String password, int[] count) {
    	int isGreat = 0;
    	
    	if(count[1] >= 1) {
    		isGreat++;    		
    	}
    	
    	if(count[2] >= 2) {
    		isGreat++;
    	}
    	
    	if(password.length() >= 12) {
    		isGreat++;
    	}
    	
    	return isGreat;    	
    }
    
    public int isIncredible(String password, int[] count) {
    	int isIncredible = 0;
    	
    	if(count[1] >= 2) {
    		isIncredible++;    		
    	}
    	
    	if(count[2] >= 4) {
    		isIncredible++;
    	}
    	
    	
    	if(password.length() >= 15) {
    		isIncredible++;
    	}
    	
    	return isIncredible;    	
    }
    
    public String verify() {
        int[] count = this.howMany(password);
        int length = this.getLength();
        
        // Basic checks for "bad" password
        if (length < 8 || count[0] < 1 || count[2] < 1) {
            this.strength = "bad";
            this.level = 0; // Directly set the level
            return this.strength;
        }

        // Evaluate greatness and incredibility
        int greatnessScore = isGreat(password, count);
        int incredibilityScore = isIncredible(password, count);

        // Determine the password strength and level
        if (greatnessScore == 0) {
            this.strength = "good";
            this.level = 1;
        } else if (greatnessScore <= 2) {
            this.strength = "good+";
            this.level = 2;
        } else if (greatnessScore == 3 && incredibilityScore == 1) {
            this.strength = "great+";
            this.level = 4;
        } else if (incredibilityScore <= 2) {
            this.strength = "incredible-";
            this.level = 5;
        } else if (incredibilityScore == 3) {
            this.strength = "incredible";
            this.level = 6;
        } else if (greatnessScore == 3) {
            this.strength = "great";
            this.level = 3;
        } else {
            this.strength = "unknown";
            this.level = -1; // Fallback level for unknown strength
        }

        return this.strength;
    }


	
	public int[] howMany(String password){
		int[] count = new int[3];// 0-> upperCase | 1-> special | 2-> numbers
		
		
		for(char c : password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				count[0] += 1;
			}else if(Character.isDigit(c)) {
				count[2] += 1;
			}else if(Character.isLetter(c)){
				continue;
			}else {
				count[1] += 1;
			}
		}
		return count;		
	}
	public Pass regenPass() {
	    Random random = new Random();
	    StringBuilder newPassword = new StringBuilder();
	    
	    // Add 2 special characters
	    String specialChars = "!@#$%^&*()_+{}[]|:;<>,.?/~`";
	    for (int i = 0; i < 2; i++) {
	        newPassword.append(specialChars.charAt(random.nextInt(specialChars.length())));
	    }
	    
	    // Add 4 numbers
	    for (int i = 0; i < 4; i++) {
	        newPassword.append(random.nextInt(10)); // Random number between 0-9
	    }
	    
	    // Add at least 3 uppercase letters
	    for (int i = 0; i < 3; i++) {
	        newPassword.append((char) ('A' + random.nextInt(26))); // Random uppercase letter
	    }
	    
	    // Add lowercase letters to meet the minimum length of 17
	    while (newPassword.length() < 17) {
	        newPassword.append((char) ('a' + random.nextInt(26))); // Random lowercase letter
	    }
	    
	    // Shuffle the characters to make the password unpredictable
	    char[] passwordArray = newPassword.toString().toCharArray();
	    for (int i = passwordArray.length - 1; i > 0; i--) {
	        int j = random.nextInt(i + 1);
	        char temp = passwordArray[i];
	        passwordArray[i] = passwordArray[j];
	        passwordArray[j] = temp;
	    }
	    this.password = new String(passwordArray);
	    // Convert back to string and return as a new Pass object
	    return new Pass(new String(passwordArray));
	}


}
