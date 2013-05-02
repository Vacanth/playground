package com.vendertool.log;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service("jobIncrementer.sampleProcessor")
public class SampleProcessor implements ItemProcessor<String, Sample>{

	@Override
	public Sample process(String arg0) throws Exception {
		Sample sample = new Sample();
		sample.setData(arg0);
		sample.setType(1);
		return sample;
	}
}