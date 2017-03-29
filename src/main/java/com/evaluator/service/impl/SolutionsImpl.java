/**
 * 
 */
package com.evaluator.service.impl;

import com.evaluator.dao.SolutionsDao;
import com.evaluator.service.Solutions;
import com.evaluator.service.model.Solution;

/**
 * This class is concrete implementation of Solutions abstraction
 * @author Jagan
 * @version	1.0
 */
public class SolutionsImpl implements Solutions {

	private SolutionsDao dao;
	
	public SolutionsImpl(SolutionsDao dao){
		this.dao = dao;
	}
	
	public String writeSolution(Solution sol) {
		return dao.writeSolution(sol);
	}

	public Solution readSoluiton(String _id) {
		return dao.readSoluiton(_id);
	}

}
