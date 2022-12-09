package com.parsing;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;

import java.text.ParseException;
import java.util.GregorianCalendar;

public class TrickyPipeParser implements PersonParser {
    public PersonInterface parsePerson(String input) {

        String[] splitInput = input.split("\\|");
        if (splitInput.length == 5) {

            String name = splitInput[0];

            String[] splitName = name.split(",");
            if (splitName.length == 2) {
                String lastName = splitName[0].trim();
                String firstName = splitName[1].trim();
                String middleInitial = splitInput[1].trim();
                Gender gender = ParseHelper.parseSingleLetterGender(splitInput[2].trim());
                String color = splitInput[3].trim();
                try {
                    GregorianCalendar
                            birthDate = ParseHelper.parseDate(splitInput[4].trim(),
                            "MM-dd-yyyy");
                    return new Person(lastName, firstName, middleInitial, gender, color, birthDate);

                } catch (ParseException e) {
                    return NullPerson.NULL;
                }
            }
        }
        return NullPerson.NULL;
    }
}
