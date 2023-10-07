import packagePerson.person;

import java.io.*;
import java.util.*;

public class principal {

    /**
     * The main entry point of the program.
     *
     * @param args Command-line arguments passed to the program. This should be a file name (including its relative/absolute path).
     * @throws IOException If an I/O error occurs during program execution.
     */
    public static void main (String[] args) throws IOException {


        // == FILE VALIDATION PHASE ==

        // The reserved variable is initialized to store the file name
        String nameOfFile = "0";

        // Verifies that the inserted argument contains a valid format
        if (args.length != 1) {

            System.out.println("Please provide the file name as an argument" +
                               "\nRemember that if the file name contains spaces it must be added between quotes: \" \"");
            System.exit(1);

        } else {

            // Capture the file name and remove all spaces at the beginning and end
            nameOfFile = args[0].trim();

        }

        // Check if the file does not exist
        File ifile = new File(nameOfFile);
        if (!ifile.exists()) {

            System.out.println("The file '" + nameOfFile + "' does not exist.");
            System.exit(1);

        }


        // == FILE DATA READING PHASE ==

        // A list of Strings is loaded with the data from the target file. Each row in the file is stored in a string list row.
        List<String> data1 = readDataFromFile(nameOfFile);

        // One person instance is generated per row read from the file
        person[] ipeople = new person[data1.size()];
        for (int i = 0; i < data1.size(); i++) {

            // The groups of strings delimited by the character "*" are divided by rows into a new array. These contain the name, surname and date of birth.
            String[] partsOfData = data1.get(i).split("\\*");
            // A new person instance is constructed
            ipeople[i]  = new person (partsOfData[0].trim(), partsOfData[1].trim(), partsOfData[2].trim());

        }


        // == DATA SORTING PHASE ==

        // The array is passed to list type to be able to order its elements with the instruction: Collections.sort();
        List<person> ilistaPerson = new ArrayList<>();

        for (person aperson : ipeople) {
            ilistaPerson.add(aperson);
        }

        Collections.sort(ilistaPerson);

        // The ordered list is printed
        for (person bperson : ilistaPerson) {
            System.out.println("Name: " + bperson.name + ", Last name: " + bperson.lastName + ", Date of birth: " + bperson.dateOfBirth);
        }


        // == DATA OVERWRITING PHASE ==

        List<String> data2 = new ArrayList<>();

        for (person yperson : ilistaPerson) {

            data2.add(yperson.name + " " + yperson.lastName + " " + yperson.dateOfBirth);

        }

        writeDataToFile(nameOfFile, data2);


    } // end of main


    /**
     * This method is takes care of read data of existing file.
     *
     * The file to be reading must have an ISO-8859-1 character set.
     *
     * @param fileName - File name (including its relative/absolute path).
     * @return A list of strings containing the data read from the file. Where each read file row represents an element of list of strings.
     * @throws IOException - If an I/O error occurs while writing the file.
     */
    public static List<String> readDataFromFile(String fileName) throws IOException {

        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "ISO-8859-1"))) {

            String row;
            while ((row = br.readLine()) != null) {
                data.add(row);
            }

        }

        return data;

    }


    /**
     * This method is takes care of write data, overwriting an existing file.
     *
     * The file to be overwritten must have an ISO-8859-1 character set.
     *
     * @param fileName - File name (including its relative/absolute path).
     * @param data - Contains an array with the data of each row to fill the file.
     * @return Nothing.
     * @throws IOException - If an I/O error occurs while writing the file.
     */
    public static void writeDataToFile (String fileName, List<String> data) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "ISO-8859-1"))) {

            for (String row : data) {
                bw.write(row);
                bw.newLine();
            }

        }

    }

} // end of class