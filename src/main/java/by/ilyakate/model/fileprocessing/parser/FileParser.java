package by.ilyakate.model.fileprocessing.parser;

import by.ilyakate.model.fileprocessing.description.DocumentStatistics;
import by.ilyakate.model.exception.InvalidFileTypeException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {
    private Charset charset = Charset.forName("ISO-8859-1"); // Используем определенную кодировку винды
    public void parse(File file, DocumentStatistics statistics) throws IOException, InvalidFileTypeException {
        if (file.getName().endsWith(".pdf")) {
            throw new InvalidFileTypeException("File format not supported: " + file.getName());
        }

        List<String> lines; //без листа сделать
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            lines = reader.lines().collect(Collectors.toList());
        }

        if (file.getName().contains("Electric_Bill")) {
            parseElectricBill(lines, statistics);
        } else {
            throw new InvalidFileTypeException("Unknown file type: " + file.getName());
        }
    }

    private void parseElectricBill(List<String> lines, DocumentStatistics statistics) {
        statistics.setTotalInvoices(statistics.getTotalInvoices() + 1);
    }
}