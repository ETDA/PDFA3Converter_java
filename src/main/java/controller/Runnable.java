package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import pdfa3.EmbedType;
import pdfa3.MetaData;
import pdfa3.PDFA3Converter;
import utility.ParameterController;

public class Runnable {

	public static void main(String[] args) {
		
		// TODO Call with external parameter input
		runWithExternalInput(args);
		
		//System.out.println("Press enter to exit program");
		//Scanner scanner = new Scanner(System.in);
		//scanner.nextLine();
	}

	public static void runWithExternalInput(String[] args) {
		try {
			ParameterController parameterController =  new ParameterController(args);
			PDFA3Converter pdfConverter = new PDFA3Converter();
			pdfConverter.setInputPDFFile(parameterController.getParameterValue("-inputFile"));
			pdfConverter.setOutputPDFFile(parameterController.getParameterValue("-outputFile"));
			pdfConverter.setMetaData(parameterController.getParameterValue("-metaDataFile"));
			pdfConverter.setEmbedFile(parameterController.getParameterValue("-embedFile"), parameterController.getEmdedType());
			pdfConverter.setColorProfile(parameterController.getParameterValue("-colorProfile"));
			pdfConverter.setFontFilePath(parameterController.getParameterValue("-font"));
			
			pdfConverter.convert();
		} catch (Exception ex) {
			//LogController.getInstance().writeErrorLog(ex.getMessage());
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			System.err.println("Program was ended unexpectedly.");
		} finally {
			
			System.out.println("Finish library.");
			System.out.println("Press enter to exit");
			(new Scanner(System.in)).nextLine();
		}
		
	}
}
