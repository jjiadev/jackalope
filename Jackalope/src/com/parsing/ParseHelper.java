package com.parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.people.Gender;

public class ParseHelper {

	public static Gender parseSingleLetterGender(String genderString) {

		if (genderString.toUpperCase().equals("M")) {
			return Gender.Male;
		}
		if (genderString.toUpperCase().equals("F")) {
			return Gender.Female;
		}
		return Gender.Undetermined;
	}

	public static GregorianCalendar parseDate(String dateString,
			String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date parsedDate = simpleDateFormat.parse(dateString);

		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime(parsedDate);
		return birthDate;
	}

}
