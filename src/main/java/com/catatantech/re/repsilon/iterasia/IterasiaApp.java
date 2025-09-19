/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catatantech.re.repsilon.iterasia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.drools.model.codegen.ExecutableModelProject;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author Admin
 */
public class IterasiaApp {
	
	public static void main(String[] args) {
		IterasiaApp app = new IterasiaApp();
		app.doWork();
	}
	
	private void doWork() {
		System.out.println("START");
		
		KieContainer kieContainer = createKieContainer();
		KieBase kieBase = kieContainer.getKieBase();
		
		for (KiePackage kp : kieBase.getKiePackages()) {
			System.out.println("package : " + kp.getName());
			for (Rule rule : kp.getRules()) {
				System.out.println("    rule: " + rule.getName());
			}
		}
		
		KieSession session = kieBase.newKieSession();
		
		calculateResult(session);
		
		session.dispose();
		
		System.out.println("END");
	}
	
	
	
	private void calculateResult(KieSession session) {
		try {
			String url = "jdbc:postgresql://localhost:3432/dblab";
			String user = "zblab";
			String password = "Oos0Ahbee0zishetheethoh7";
			
			String sql = "select * from kebun.hasil_panen;";
			
			int counter = 0;
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				WorkerResult wr = new WorkerResult(
						rs.getString("worker_code"),
						rs.getInt("raw_material"),
						rs.getInt("quality"),
						rs.getInt("processed_mat")
					);
				
				session.insert(wr);
				session.fireAllRules();
				
				System.out.println(
						"workerCode: " + wr.getWorkerCode() + 
						" --- result: " + wr.getResult() +
								" --- resultPoint: " + wr.getResultPoint()
				);
				
				counter++;
				System.out.println("counter: " + counter);
				
			}
			
			rs.close();
			stmt.close();
			con.close();
		} 
		catch (SQLException ex) {
			System.getLogger(IterasiaApp.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		}
		catch (Exception exc) {
			System.out.println("exc :" + exc.getMessage());
		}
		
		
		
	}
	
	
	private KieContainer createKieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieFileSystem kfs = ks.newKieFileSystem();
		String packagePath = "com.catatantech.re.repsilon".replace(".", "/");
		kfs.write("src/main/resources/" + packagePath + "/rulesa.drl", 
				ks.getResources().newInputStreamResource(
				this.getClass().getClassLoader().getResourceAsStream(packagePath + "/rulesa.drl")));
		ReleaseId releaseId = ks.newReleaseId("com.catatantech.com.re", "repsilon", "1.0-SNAPSHOT");
		kfs.generateAndWritePomXML(releaseId);
		ks.newKieBuilder(kfs).buildAll(ExecutableModelProject.class);
		return ks.newKieContainer(releaseId);
	}
	
}
