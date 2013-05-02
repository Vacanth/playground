package com.vendertool.log;

import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.stereotype.Service;

@Service("jobIncrementer.sampleIncrementer")
public class SampleJobIncrementer implements JobParametersIncrementer{
	
	public static String RUN_ID = "runId";
	public static String EXECUTION_DATA = "executionDate";

	@Override
	public JobParameters getNext(JobParameters parameters) {
		long id = 0;
		if(parameters == null || parameters.isEmpty()){
			id = 1;
		}else{
			id = parameters.getLong(RUN_ID, 1L)+1;
		}
		
		JobParametersBuilder parameterBuilder = new JobParametersBuilder();
		parameterBuilder.addLong(RUN_ID, id).toJobParameters();
		parameterBuilder.addLong(EXECUTION_DATA, new Date().getTime()).toJobParameters();
		return parameterBuilder.toJobParameters();
	}
}