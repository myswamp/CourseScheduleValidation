package com.xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class CourseScheduleValidatorTest {

	@Test
	public void validCourseFlow() {
		Course a = new Course("A", Arrays.asList("B"));
		Course b = new Course("B", Arrays.asList("C"));
		Course c = new Course("C", Collections.<String>emptyList());

		Map<String, List<String>> relations = new HashMap<>();
		relations.put(a.getId(), a.getDependencies());
		relations.put(b.getId(), b.getDependencies());
		relations.put(c.getId(), c.getDependencies());

		List<String> pickedCourses = new ArrayList<>();
		pickedCourses.add(a.getId());
		pickedCourses.add(b.getId());
		pickedCourses.add(c.getId());
		
		
		Assertions.assertTrue(CourseScheduleValidator.isValidSchedule(pickedCourses, relations));
	}
	
	@Test
	public void invalidCourseFlow() {
		Course a = new Course("A", Arrays.asList("B"));
		Course b = new Course("B", Arrays.asList("C"));
		Course c = new Course("C", Arrays.asList("A"));

		Map<String, List<String>> relations = new HashMap<>();
		relations.put(a.getId(), a.getDependencies());
		relations.put(b.getId(), b.getDependencies());
		relations.put(c.getId(), c.getDependencies());

		List<String> pickedCourses = new ArrayList<>();
		pickedCourses.add(a.getId());
		pickedCourses.add(b.getId());
		pickedCourses.add(c.getId());
		
		
		Assertions.assertFalse(CourseScheduleValidator.isValidSchedule(pickedCourses, relations));
	}
}
