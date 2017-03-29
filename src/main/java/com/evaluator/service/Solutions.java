package com.evaluator.service;

import com.evaluator.service.model.Solution;

/**
 * Interface to perform Solution service layer abstraction
 * 
 * @author Jagan
 * @version 1.0
 */
public interface Solutions {

	String writeSolution(Solution sol);
	Solution readSoluiton(String _id);
	
}
