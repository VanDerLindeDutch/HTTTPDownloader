package BitumURL;

import WR.File_Reader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadLinkList {
    private final String path;

    public ReadLinkList(String path) {
        this.path = path;
    }

    public void readAndDownload(int NoT, String dir) throws FileIsNotDirException {  // NoT  - Number of threads
        HashMap<String, List<String>> hashMap = new HashMap<>();

        if (!new File(dir).isDirectory()) throw new FileIsNotDirException("Path points not to directory");
        File_Reader fileReader = new File_Reader(path);
        List<String> list = fileReader.getFile();
        for (String i : list) {
            String[] links = i.split(" ");
            if (!hashMap.containsKey(links[0])) {
                hashMap.put(links[0], new ArrayList<>());
            }
            hashMap.get(links[0]).add(links[1]);
        }

        List<Map.Entry<String, List<String>>> listEntry = new ArrayList<>(hashMap.entrySet());
        System.out.println(listEntry);
        for (int i = 0; i < NoT && i < list.size(); i++) {
            new Thread(new DownloadThread(listEntry, dir, i, NoT), "Thread " + i).start();
        }
    }
}

