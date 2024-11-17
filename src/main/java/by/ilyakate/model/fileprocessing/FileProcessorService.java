package by.ilyakate.model.fileprocessing;

import by.ilyakate.model.fileprocessing.description.DocumentStatistics;

import java.io.File;

public interface FileProcessorService {
    DocumentStatistics processFiles(File directory);

}
