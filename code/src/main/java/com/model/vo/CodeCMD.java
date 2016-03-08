package com.model.vo;

public class CodeCMD extends CMDResult{
	public enum TYPE{
		COMPILEERROR, MEMORYLIMITEXCEEDED, TIMELIMITEXCEEDED, RUNTIMEERROR,
		WRONGANSWER, OUTPUTLIMITEXCEEDED, PRESENTATIONERROR, ACCEPTED
	}
	private int type;
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
