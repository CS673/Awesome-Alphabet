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
 * 2013-04-09  0.3.0.0  M. Grant
 *   (2) Updated version number for iteration 3.
 */

public class Version {

	public static final String sAppName = "Awesome Alphabet";
	public static final String sVersionNum = "0.3.0.0";
	public String getVersion()
	{
		return sVersionNum;
	}
	public String getAppName()
	{
		return sAppName;
	}
}
