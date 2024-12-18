package com.solum.aims.msp.util;
public interface JsonViewFilter {
	interface AimsMessage {}
	
	interface EndDeviceView extends AimsMessage {}
	
	interface WhistListView extends AimsMessage{}
	
	interface StationView extends AimsMessage{}
	
	interface AccessPointView  extends AimsMessage {}
	
	interface NewEndDeviceView extends AimsMessage {}
	
	interface ServerView extends AimsMessage {}
}