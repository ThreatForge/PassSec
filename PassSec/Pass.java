package PassSec;
import java.lang.ProcessHandle.Info;
import java.util.Objects;

public class Pass implements Cloneable{

	protected String password;
	
	public Pass(String pass) {
		this.password = pass;
	}
	
    /**
     * Sets the password.
     * 
     *  @param pass representing the password that is about to be set.
     */
	public void setPass(String pass) {
		this.password = pass;		
	}

	
    /**
     * Returns a copy of the password.
     *
     * @return the password.
     */
	public String getPass() {
		return password;		
	}
	
	
    /**
     * Returns the length of the password sequence.
     *
     * @return the length of the password.
     */
    public int getLength() {
        return password.length();
    }
    
    
	/**
	  * Returns a textual representation of this Pass.
	  *
	  * @return a String representation of the Pass.
	 */
	 @Override
	public String toString() {
	    return password.toString();
	}


	/**
	 * Creates and returns a copy of this Pass.
	 *
	 * @return a new Pass object that is a copy of this instance.
	 */
	 public Pass clone() {
		    try {
		        return (Pass) super.clone();
		    } catch (CloneNotSupportedException e) {
		        // This shouldn't happen since Pass implements Cloneable
		        throw new AssertionError("Cloning not supported", e);
		    }
		}
    
    
    /**
    * Compares the Code object to the specified object for equality.
    *
    * @param obj the object to compare with this Code instance.
    * @return true if the specified object is equal to this Pass instance,
    *         false otherwise.
    */
    public boolean equals(Object obj) {
    	if (this == obj) {
    		return true;
    	}
    	if (obj == null || !(obj instanceof Pass)) {
    		return false;
    	}
    	Pass other = (Pass) obj;
    	return Objects.equals(this.password, other.password);
    }
    

}

























