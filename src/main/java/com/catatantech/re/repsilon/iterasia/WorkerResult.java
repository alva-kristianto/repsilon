/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catatantech.re.repsilon.iterasia;

/**
 *
 * @author Admin
 */
public class WorkerResult {

	private String workerCode = "";
	private int rawMaterial = 0;
	private int quality = 0;
	private int processedMat = 0;
	private int resultPoint = 0;
	private String result = "z result";
	
	
	public WorkerResult() {
		System.out.println("default constructor being called");
	}
	
	public WorkerResult(String workerCode, int rawMaterial, int quality, int processedMat) {
		System.out.println("init constructor being called");
		this.workerCode = workerCode;
		this.rawMaterial = rawMaterial;
		this.quality = quality;
		this.processedMat = processedMat;
	}

	
	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public int getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(int rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getProcessedMat() {
		return processedMat;
	}

	public void setProcessedMat(int processedMat) {
		this.processedMat = processedMat;
	}

	public int getResultPoint() {
		return resultPoint;
	}

	public void setResultPoint(int resultPoint) {
		this.resultPoint = resultPoint;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
