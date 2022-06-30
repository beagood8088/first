package com.example.first.utils;

import com.example.first.consumingrest.Manager;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.regex.Pattern;

@Service
public class Utils {
    private final Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return numericPattern.matcher(strNum).matches();
    }

    public Comparator<Manager> supervisorComparator() {
        Comparator<Manager> compareByJurisdiction = Comparator.comparing( Manager::getJurisdiction );
        Comparator<Manager> compareByFirstName = Comparator.comparing( Manager::getFirstName );
        Comparator<Manager> compareByLastName = Comparator.comparing( Manager::getLastName );
        return compareByJurisdiction.thenComparing(compareByLastName).thenComparing(compareByFirstName);
    }
}
