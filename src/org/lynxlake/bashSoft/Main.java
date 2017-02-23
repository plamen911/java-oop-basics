package org.lynxlake.bashSoft;

import org.lynxlake.bashSoft.io.CommandInterpreter;
import org.lynxlake.bashSoft.io.IOManager;
import org.lynxlake.bashSoft.io.InputReader;
import org.lynxlake.bashSoft.io.OutputWriter;
import org.lynxlake.bashSoft.judge.Tester;
import org.lynxlake.bashSoft.network.DownloadManager;
import org.lynxlake.bashSoft.repository.RepositoryFilter;
import org.lynxlake.bashSoft.repository.RepositorySorter;
import org.lynxlake.bashSoft.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter sorter = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        StudentsRepository repository = new StudentsRepository(filter, sorter);
        CommandInterpreter currentInterpreter = new CommandInterpreter(tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}
