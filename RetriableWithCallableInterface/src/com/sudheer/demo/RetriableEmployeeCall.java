package com.sudheer.demo;

import java.util.concurrent.Callable;

public class RetriableEmployeeCall<T> implements Callable<EmployeeResponse> {

	
	private Callable<EmployeeResponse> employeeService;
	public static final int DEFAULT_NUMBER_OF_RETRIES = 3;
	public static final long DEFAULT_INITIAL_WAIT_TIME_MS = 2000;
	
	private int numberOfTriesLeft; // number left
	private long timeToWait; // wait interval
	
	public RetriableEmployeeCall(Callable<EmployeeResponse> employeeApiCall) {
		this(DEFAULT_NUMBER_OF_RETRIES, DEFAULT_INITIAL_WAIT_TIME_MS,employeeApiCall);
	}

	public RetriableEmployeeCall(int numberOfRetries, long timeToWait,
			Callable<EmployeeResponse> employeeApiCall) {
		this.numberOfTriesLeft = numberOfRetries;
		this.timeToWait = timeToWait;
		this.employeeService = employeeApiCall;
	}

	@Override
	public EmployeeResponse call() throws Exception {
		EmployeeResponse employee = null;
		while (numberOfTriesLeft > 0) {
			try {
				employee = employeeService.call();
				if(employee != null ){
					return employee;
				}else {
					throw new Exception("Not OK");
				}
			} catch (Exception e) {
				numberOfTriesLeft--;
				if (!isRetriable(employee)) {
					throw new Exception("Not Retriable error");
				}
				if (numberOfTriesLeft <= 0) {
					System.out.println("No more retries.");
					throw new Exception("No more retries.");
				}
				Thread.sleep(timeToWait);
				timeToWait *= 2;
			}
		}
		return null;
	}
	
	protected Boolean isRetriable(EmployeeResponse employee ) {
	    Boolean isRetriable = false;
	    return isRetriable;
	  }
		
}
