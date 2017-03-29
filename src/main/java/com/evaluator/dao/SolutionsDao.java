package com.evaluator.dao;

import com.evaluator.service.model.Solution;


/**
 * Interface to perform Solution data layer abstraction
 * 
 * @author Jagan
 * @version 1.0
 */
public interface SolutionsDao {

	String writeSolution(Solution sol);
	Solution readSoluiton(String _id);
	
}
