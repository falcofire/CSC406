
public enum GraphTypes {
	AMWDG("AMWDG"),AMDG("AMDG"),AMWG("AMWG"),ALWDG("ALWDG"),ALDG("ALDG"),ALWG("ALWG");
	private String value;
	private GraphTypes(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}
