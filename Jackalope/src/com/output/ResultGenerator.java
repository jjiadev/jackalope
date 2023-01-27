package com.output;

import java.io.File;
import java.util.List;

import com.io.FileReader;
import com.io.FileWriter;
import com.io.FileWriterInterface;
import com.parsing.PersonLoader;
import com.people.BirthdateSorter;
import com.people.GenderAndLastNameSorter;
import com.people.LastNameSorter;
import com.people.OutputGenerator;
import com.people.OutputGeneratorInterface;
import com.people.PersonCompiler;
import com.people.PersonCompilerInterface;
import com.people.PersonFormatter;
import com.people.PersonInterface;

public class ResultGenerator {
    public static void main(String[] args) {
        ResultGenerator resultGenerator = new ResultGenerator(
                new OutputGenerator(new PersonFormatter()), new FileWriter(),
                new PersonCompiler(new PersonLoader(new FileReader()), null));
        String outputPath = args[0];
        String inputFolderPath = args[1];
        System.out.println(new File(inputFolderPath).getAbsolutePath());
        resultGenerator.writeOutput(outputPath, inputFolderPath);
    }

    private OutputGeneratorInterface outputGenerator;
    private FileWriterInterface fileWriter;
    private PersonCompilerInterface personCompiler;

    public ResultGenerator(OutputGeneratorInterface outputGenerator,
                           FileWriterInterface fileWriter,
                           PersonCompilerInterface personCompiler) {
        this.outputGenerator = outputGenerator;
        this.fileWriter = fileWriter;
        this.personCompiler = personCompiler;
    }

    public PersonCompilerInterface getPersonCompiler() {
        return personCompiler;
    }

    public FileWriterInterface getFileWriter() {
        return fileWriter;
    }

    public OutputGeneratorInterface getOutputGenerator() {
        return outputGenerator;
    }

    public void writeOutput(String outputPath, String inputFolderPath) {
        List<PersonInterface> allPeople = personCompiler
                .getAllPeople(inputFolderPath);
        String output1 = outputGenerator.createOutput(1, allPeople,
                new GenderAndLastNameSorter());
        String output2 = outputGenerator.createOutput(2, allPeople,
                new BirthdateSorter());
        String output3 = outputGenerator.createOutput(3, allPeople,
                new LastNameSorter());
        this.fileWriter.write(outputPath, output1 + output2 + output3);

    }

}
