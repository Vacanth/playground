package com.vendertool.log;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

@Service("jobIncrementer.sampleReader")
public class SampleReader implements ItemReader<String>{

	static String[] array = new String[100];
	static{
		for(int i = 0 ; i < 100; i++){
			array[i] = "Name"+i;
		}
	}
			
	static int readIndex = -1;
	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		readIndex ++;
		if(readIndex >= array.length){
			readIndex = -1;
			return null;
		}
		return array[readIndex];
	}
}