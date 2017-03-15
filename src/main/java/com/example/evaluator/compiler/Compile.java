package com.example.evaluator.compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Compile {
	@RequestMapping("/compile")
    String home(@RequestParam("code") String code) {
		StringBuffer output = new StringBuffer();
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new java.io.File("C:/Users/user/Solution.java")));
			writer.write(code);
			writer.flush();
			Process p = Runtime.getRuntime().exec("cmd /c javac \"C:/Users/user/Solution.java\"");
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));
			String line = reader.readLine();
			while (line != null) {
				output.append(line);
				line = reader.readLine();
			}
			
			if(output.toString().isEmpty()){
				p = Runtime.getRuntime().exec("cmd /c java -classpath C:/Users/user Solution");
				p.waitFor();
				reader = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				String line2 = reader.readLine();
				while (line2 != null) {
					output.append(line2).append("<br />");
					line2 = reader.readLine();
				}
			}
		} catch (IOException e1) {
			return e1.getMessage();
		} catch (InterruptedException e2) {
			return e2.getMessage();
		}finally{
			try{
				if(null != writer)
					writer.close();
			}catch(Exception e){
				return e.getMessage();
			}
		}
        return output.toString();
    }
}
