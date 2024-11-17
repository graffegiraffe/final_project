package by.ilyakate.model.fileprocessing.service;

import by.ilyakate.model.fileprocessing.FileProcessorService;
import by.ilyakate.model.fileprocessing.description.DocumentStatistics;
import by.ilyakate.model.exception.InvalidFileTypeException;
import by.ilyakate.model.fileprocessing.parser.FileParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileProcessorServiceImpl implements FileProcessorService {
    private static final Logger LOGGER = Logger.getLogger(FileProcessorServiceImpl.class.getName());

    @Override
    public DocumentStatistics processFiles(File directory) {
        DocumentStatistics statistics = new DocumentStatistics();
        FileParser fileParser = new FileParser();
        List<String> unsupportedFiles = new ArrayList<>();

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try { //подумать над логгерами
                    fileParser.parse(file, statistics);
                } catch (InvalidFileTypeException e) {
                    LOGGER.log(Level.SEVERE, "Error: " + e.getMessage(), e);
                    unsupportedFiles.add(file.getName());
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Error: " + e.getMessage(), e);
                }
            }
        }

        if (!unsupportedFiles.isEmpty()) {
            System.out.println("Unsupported file types detected:");
            unsupportedFiles.forEach(System.out::println);
        }

        return statistics;
    }
}