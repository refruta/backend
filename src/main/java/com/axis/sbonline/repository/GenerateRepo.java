package com.axis.sbonline.repository;

import java.util.List;

import com.axis.sbonline.model.Report;

public interface GenerateRepo {
	public List<Integer> getMarksById(int id );
	public void addReport(Report repo);
	public Report getReport(int reportId);
	public List<Report> getAllReportsByUser(int userId);
}
