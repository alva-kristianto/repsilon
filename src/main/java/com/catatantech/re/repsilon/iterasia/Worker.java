/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catatantech.re.repsilon.iterasia;

/**
 *
 * @author Admin
 */
public class Worker {
	private int id = 0;
	private String code = "";
	private String name = "";
	
	private int[] dailySalaries = new int[31];
	private int monthlySalary = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getDailySalaries() {
		return dailySalaries;
	}

	public void setDailySalaries(int[] dailySalaries) {
		this.dailySalaries = dailySalaries;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	
}
