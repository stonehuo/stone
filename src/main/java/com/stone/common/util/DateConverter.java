package com.kpap.common.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	
	public Date convert(String source){
		try {
			if(StringUtils.isBlank(source)){
				return null;
			}
			return DateUtils.parseDate(source, CommonUtil.date_formatSecode,CommonUtil.date_formatDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
