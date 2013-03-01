package edu.bu.cs673.AwesomeAlphabet.model;

/**
 * This class contains the application version number and related information.
 */

/* 
 * Version numbers are in the form w.x.y.z where:
 * 
 *    w is a major change.
 *    x is a medium-sized change.
 *    y is a minor change or bug fix.
 *    x is the development version (typically zero for a release).
 * 
 * 
 * Modification History:
 * 
 * 2013-02-15  0.0.0.0  M. Grant
 *   (1) Initial version
 *   
 */

public class Version {

	public static final String sAppName = "Awesome Alphabet";
	public static final String sVersionNum = "0.1.0.0";
	public String getVersion()
	{
		return sVersionNum;
	}
	public String getAppName()
	{
		return sAppName;
	}
}
