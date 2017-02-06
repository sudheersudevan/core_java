package com.sudheer.demo;

import java.util.concurrent.Callable;

public class MainClass {
	
	private EmployeeServiceImpl employeeServiceImpl= new EmployeeServiceImpl();;
	private EmployeeRequest employeeRequest= new EmployeeRequest();;
	
	public static void main(String[] args) {
		new MainClass().executeGetEmp();
		new MainClass().executeAddEmp();
		new MainClass().executeDeleteEmp();
	}

	public EmployeeResponse executeGetEmp(){
	class ExecuteEmployeeService implements Callable<EmployeeResponse> {
		
		private EmployeeServiceImpl employeeServiceImpl;
		private EmployeeRequest employeeRequest;
		
		public ExecuteEmployeeService(EmployeeServiceImpl employeeServiceImpl,EmployeeRequest employeeRequest) {
			this.employeeServiceImpl = employeeServiceImpl;
			this.employeeRequest = employeeRequest;
		}
		@Override
		public EmployeeResponse call() throws Exception {
			EmployeeResponse employeeResponse = employeeServiceImpl.getEmployee(employeeRequest);
			return employeeResponse;
		}
	}
	// Wrap the call in a RetriableCall.
	RetriableEmployeeCall<EmployeeRequest> r = new RetriableEmployeeCall<EmployeeRequest>(
			new ExecuteEmployeeService(employeeServiceImpl,employeeRequest));
	// Perform the retriable call.
	try {
		return r.call();
	}catch (Exception e) {
		
	}
	return null;
	}
	
	public EmployeeResponse executeAddEmp(){
		class ExecuteEmployeeService implements Callable<EmployeeResponse> {
			
			private EmployeeServiceImpl employeeServiceImpl;
			private EmployeeRequest employeeRequest;
			
			public ExecuteEmployeeService(EmployeeServiceImpl employeeServiceImpl,EmployeeRequest employeeRequest) {
				this.employeeServiceImpl = employeeServiceImpl;
				this.employeeRequest = employeeRequest;
			}
			@Override
			public EmployeeResponse call() throws Exception {
				EmployeeResponse employeeResponse = employeeServiceImpl.addEmployee(employeeRequest);
				return employeeResponse;
			}
		}
		// Wrap the call in a RetriableCall.
		RetriableEmployeeCall<EmployeeRequest> r = new RetriableEmployeeCall<EmployeeRequest>(
				new ExecuteEmployeeService(employeeServiceImpl,employeeRequest));
		// Perform the retriable call.
		try {
			return r.call();
		}catch (Exception e) {
			
		}
		return null;
		}
	
	public EmployeeResponse executeDeleteEmp(){
		class ExecuteEmployeeService implements Callable<EmployeeResponse> {
			
			private EmployeeServiceImpl employeeServiceImpl;
			private EmployeeRequest employeeRequest;
			
			public ExecuteEmployeeService(EmployeeServiceImpl employeeServiceImpl,EmployeeRequest employeeRequest) {
				this.employeeServiceImpl = employeeServiceImpl;
				this.employeeRequest = employeeRequest;
			}
			@Override
			public EmployeeResponse call() throws Exception {
				EmployeeResponse employeeResponse = employeeServiceImpl.deleteEmployee(employeeRequest);
				return employeeResponse;
			}
		}
		// Wrap the call in a RetriableCall.
		RetriableEmployeeCall<EmployeeRequest> r = new RetriableEmployeeCall<EmployeeRequest>(
				new ExecuteEmployeeService(employeeServiceImpl,employeeRequest));
		// Perform the retriable call.
		try {
			return r.call();
		}catch (Exception e) {
			
		}
		return null;
		}
	
}
