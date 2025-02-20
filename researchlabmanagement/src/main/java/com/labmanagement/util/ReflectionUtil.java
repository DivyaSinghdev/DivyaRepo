package com.labmanagement.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

public class ReflectionUtil {

    private static boolean headerPrinted = false;

    private static final Map<String, String> headerMapping = new HashMap<>();

    static {
        // Initialize header mappings
        headerMapping.put("equipmentId", "Equipment ID");
        headerMapping.put("equipmentName", "Equipment Name");
        headerMapping.put("manufacturerName", "Manufacturer Name");
        headerMapping.put("manufacturingDate", "Manufacturing Date");
        headerMapping.put("status", "Status");
        headerMapping.put("discardDate", "Discard Date");
        headerMapping.put("labId", "Lab ID");
        headerMapping.put("laboratoryName", "Laboratory Name");
        headerMapping.put("researchId", "Research ID");
        headerMapping.put("researchName", "Research Name");
        headerMapping.put("scientistId", "Scientist ID");
        headerMapping.put("leadScientistName", "Lead Scientist Name");
        headerMapping.put("startDate", "Start Date");
        headerMapping.put("endDate", "End Date");
        headerMapping.put("age", "Age");
        headerMapping.put("gender", "Gender");
        headerMapping.put("reportingScientistId", "Reporting Scientist ID");
    }

    public static <T> void printObjectDetails(T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        // Print header only once
        if (!headerPrinted) {
            for (Field field : fields) {
                String header = headerMapping.getOrDefault(field.getName(), field.getName());
                sb.append(String.format("%-28s", header));
            }
            sb.append("\n");

            // Print separator
            for (Field field : fields) {
                sb.append(String.format("%-28s", "----"));
            }
            sb.append("\n");

            headerPrinted = true;
        }

        // Print values
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(String.format("%-28s", field.get(obj)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public static void resetHeaderPrinted() {
        headerPrinted = false;
    }
}