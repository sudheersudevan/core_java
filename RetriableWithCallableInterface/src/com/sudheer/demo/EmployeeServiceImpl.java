package com.sudheer.demo;

public class EmployeeServiceImpl {

	public EmployeeResponse getEmployee(EmployeeRequest employeeRequest){
		System.out.println("return getEmployee");
		return new EmployeeResponse();
	}
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
		System.out.println("return addEmployee");
		return new EmployeeResponse();
	}
	public EmployeeResponse deleteEmployee(EmployeeRequest employeeRequest){
		System.out.println("return DeleteEmployee");
		return new EmployeeResponse();
	}
}
