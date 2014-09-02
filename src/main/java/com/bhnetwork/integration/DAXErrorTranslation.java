package com.bhnetwork.integration;

public enum DAXErrorTranslation {

	DAX_STEP_3PS_CANONICAL("Data_Transformation_3PS_CANONICAL","Data Transformation 3PS-CANONICAL"),
	DAX_STEP1("1","Company Creation"), 
	DAX_STEP2("2","Division Creation"),
	DAX_STEP3("3","Subst group Creation"),
	DAX_STEP4("4","UPC/Invent Creation"),
	DAX_STEP5("5","IID/InventBatch Creation"),
	DAX_STEP6("6","Store/Customer Creation"),
	DAX_STEP7("7","Vendor Creation"),
	DAX_STEP8("8","Setup Complete"),
	DAX_STEP9("9","Cleanup"),
	DAX_STEP_3PS_CALLBACK("3ps-callback","3ps-callback"),
	DAX_STEP_UNKNOWN("Unkonwn","Unknown");
	
	private final String key;
	private final String value;

	DAXErrorTranslation(String key, String value) {
		this.key=key;
		this.value = value;
	}

	public String key() {
		return key;
	}
	
	public String value() {
		return value;
	}

	public static DAXErrorTranslation fromKey(String key) {
		for (DAXErrorTranslation c : DAXErrorTranslation.values()) {
			if (c.key.equals(key)) {
				return c;
			}
		}
		return DAXErrorTranslation.DAX_STEP_UNKNOWN;
	}

}
