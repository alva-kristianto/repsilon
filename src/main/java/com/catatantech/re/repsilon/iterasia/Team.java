/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catatantech.re.repsilon.iterasia;

/**
 *
 * @author Admin
 */
public class Team {
	private int id = 0;
	private String code = "";
	private String name = "";
	private Worker leader = null;
	private Worker assistant = null;

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

	public Worker getLeader() {
		return leader;
	}

	public void setLeader(Worker leader) {
		this.leader = leader;
	}

	public Worker getAssistant() {
		return assistant;
	}

	public void setAssistant(Worker assistant) {
		this.assistant = assistant;
	}
	
	
}
