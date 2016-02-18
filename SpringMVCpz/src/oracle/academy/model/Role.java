package oracle.academy.model;

public enum Role {

	USER("user"), ADMIN("admin"), SUPER_ADMIN("Super admin");
	
	private String displayName;
	
	Role(String displayName){
		
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
