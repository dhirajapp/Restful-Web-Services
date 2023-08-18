package com.dhirajapp.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		MappingJacksonValue mappingJacksonVale = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter fillter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", fillter);
		mappingJacksonVale.setFilters(filters);

		return mappingJacksonVale;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringlist() {
	List<SomeBean> list=Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
	MappingJacksonValue mappingJacksonVale = new MappingJacksonValue(list);
	SimpleBeanPropertyFilter fillter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", fillter);
	mappingJacksonVale.setFilters(filters);

	
	return mappingJacksonVale;
	}

}
