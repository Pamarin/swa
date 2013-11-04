import static org.jboss.resteasy.api.validation.ConstraintType.Type.RETURN_VALUE;

public class Lieferant {
	private Integer pID;
	private String pName;
	
	public Lieferant(Integer aID, String aName) {
		//Check if ID argument is empty.
		if (aID.equals(null) || aID < 0) {
			throw new NullPointerException();
		}
		//Check if Name argument is empty.
		if (aName.equals(null) || aName.equals("")) {
			throw new NullPointerException();
		}
		
		//Set parameters.
		this.pID = aID;
		this.pName = aName;
	}
	
	public Integer getID() {
		return this.pID;
	}
	
	public void setID(Integer aID) {
		//Check if ID argument is empty.
		if (aID.equals(null) || aID < 0) {
			throw new NullPointerException();
		}
		
		//Set ID.
		this.pID = aID;
	}
	
	public String getName() {
		return this.pName;
	}
	
	public void setName(String aName) {
		//Check if Name argument is empty.
		if (aName.equals(null) || aName.equals("")) {
			throw new NullPointerException();
		}
		
		//Set Name.
		this.pName = aName;
	}
}
