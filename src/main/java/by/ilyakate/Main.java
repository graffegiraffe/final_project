package by.ilyakate;

import by.ilyakate.model.fileprocessing.FileProcessorService;
import by.ilyakate.model.fileprocessing.description.DocumentStatistics;
import by.ilyakate.model.fileprocessing.service.FileProcessorServiceImpl;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Provided path is not a valid directory: " + directoryPath);
            return;
        }

        FileProcessorService fileProcessorService = new FileProcessorServiceImpl();
        DocumentStatistics statistics = fileProcessorService.processFiles(directory);
        System.out.println("Processing complete.");
        System.out.println("Total Invoices: " + statistics.getTotalInvoices());
        System.out.println("Total Orders: " + statistics.getTotalOrders());
        System.out.println("Total Receipts: " + statistics.getTotalReceipts());
    }
}