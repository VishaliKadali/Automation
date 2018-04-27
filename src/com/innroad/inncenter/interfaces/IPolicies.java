package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

public interface IPolicies {

	
	
	void NewPolicybutton(WebDriver driver, String Accounttype);
    
	void Enter_Policy_Name(WebDriver driver,String PolicyName);
    
    void verify_Policy_Type(WebDriver driver, String PolicyType);
    
    void Enter_Policy_Desc(WebDriver driver,String PolicyText,String PolicyDesc);
    
    void Associate_Sources(WebDriver driver) throws InterruptedException ;
    
    void Associate_Seasons(WebDriver driver) throws InterruptedException;
    
    void Associate_RoomClasses(WebDriver driver) throws InterruptedException;
    
    void Associate_RatePlans(WebDriver driver) throws InterruptedException;
    
}   
