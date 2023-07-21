package media.builder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import media.Note;
import media.enums.NoteDurationEnum;
import media.scale.Scale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotesCsvLoader {

    public static List<Note> loadFromPath(String path, Scale scale) throws IOException, CsvValidationException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        return loadFromCsv(reader, scale);
    }

    public static List<Note> loadFromResource(String sourcePath, Scale scale) throws CsvValidationException, IOException {
        Reader reader = new InputStreamReader(Objects.requireNonNull(NotesCsvLoader.class.getResourceAsStream(sourcePath)), StandardCharsets.UTF_8);
        return loadFromCsv(reader, scale);
    }

    private static List<Note> loadFromCsv(Reader reader, Scale scale) throws CsvValidationException, IOException {
        CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(reader)).build();
        List<Note> notes = new ArrayList<>();
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            Note note = new Note();
            note.setMidi(scale.convert(Integer.parseInt(line[0])));
            note.setDurationEnum(NoteDurationEnum.values()[Integer.parseInt(line[1])]);
            note.setVolume(Integer.parseInt(line[2]));
            note.setOffset(Integer.parseInt(line[3]));
            notes.add(note);
        }
        return notes;
    }

}
