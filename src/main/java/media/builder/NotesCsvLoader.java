package media.builder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import media.Note;
import media.enums.NoteDurationEnum;
import media.major.Major;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NotesCsvLoader {

    public static List<Note> loadNotesFromCsv(String path, Major major) throws IOException, CsvValidationException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).build();
        List<Note> notes = new ArrayList<>();
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            Note note = new Note();
            note.setMidi(major.convert(Integer.parseInt(line[0])));
            note.setDurationEnum(NoteDurationEnum.values()[Integer.parseInt(line[1])]);
            note.setVolume(Integer.parseInt(line[2]));
            note.setOffset(Integer.parseInt(line[3]));
            notes.add(note);
        }
        return notes;
    }

}
