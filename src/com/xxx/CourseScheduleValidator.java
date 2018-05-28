package com.xxx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleValidator {
	public static boolean isValidSchedule(List<String> pickedCourses, Map<String, List<String>> relations) {

		Map<String, Integer> inDegree = new HashMap<>();

		for (String courseId : relations.keySet()) {
			List<String> denpendency = relations.get(courseId);
			inDegree.put(courseId, denpendency.size());
		}

		List<String> result = new ArrayList<>();

		LinkedList<String> queue = new LinkedList<>();
		for (String key : inDegree.keySet()) {
			if (inDegree.get(key).intValue() == 0) {
				queue.add(key);
			}
		}

		while (!queue.isEmpty()) {
			String dependant = queue.poll();
			result.add(dependant);

			for (String courseId : relations.keySet()) {
				List<String> dependency = relations.get(courseId);
				if (dependency.contains(dependant)) {
					inDegree.put(courseId, inDegree.get(courseId) - 1);
				}
			}

			for (String key : inDegree.keySet()) {
				if (!result.contains(key) && inDegree.get(key).intValue() == 0) {
					queue.add(key);
				}
			}

		}

		return result.size() == pickedCourses.size();
	}
}
