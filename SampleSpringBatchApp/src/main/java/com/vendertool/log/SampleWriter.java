package com.vendertool.log;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

@Service("jobIncrementer.sampleWriter")
public class SampleWriter implements ItemWriter<Sample>{

	@Override
	public void write(List<? extends Sample> arg0) throws Exception {
		for(Sample sample : arg0){
			SampleDaoImpl.addData(sample);
		}
	}
}	