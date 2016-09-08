/**
 * Data acquisition (DAQ)
 * 
 * This class constantly reads the given interface and stores
 * the MAVLink message.
 * 
 * Contact: Swee Balachandran (swee.balachandran@nianet.org)
 * 
 * 
 * Copyright (c) 2011-2016 United States Government as represented by
 * the National Aeronautics and Space Administration.  No copyright
 * is claimed in the United States under Title 17, U.S.Code. All Other
 * Rights Reserved.
 */
package gov.nasa.larcfm.ICAROUS;

import com.MAVLink.*;
import gov.nasa.larcfm.Util.ParameterData;

public class DAQ implements Runnable{

    public Thread t;
    public String threadName;
    public AircraftData FlightData;
    public Interface icarousAP;
    private ParameterData pData;
    
    public DAQ(String name,Aircraft UAS,ParameterData pdata){
	threadName   = name;
	FlightData   = UAS.FlightData;
	icarousAP    = UAS.apIntf;
	pData        = pdata;
    }

    public void run(){
	while(true){

	    if(!FlightData.pauseDAQ){
		icarousAP.SetTimeout(1);
		icarousAP.Read();
		icarousAP.SetTimeout(0);
	    }
	}
    }

    public void start(){
	System.out.println("Starting "+threadName);
	t = new Thread(this,threadName);
	t.start();
    }



}
