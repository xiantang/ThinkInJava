package ThreadSafety;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;
    public FileCrawler(BlockingQueue<File> fileQueue,
                       final FileFilter fileFilter,
                       File root) {
        this.fileQueue = fileQueue;
        this.root = root;
        this.fileFilter = new FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory() || fileFilter.accept(f);
            }
        };
    }
    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private boolean alreadyIndexed(File f) {
        return false;
    }
    private void crawl(File root) throws InterruptedException{
        File[] ebtires = root.listFiles();

        if (ebtires != null) {
            for (File entry : ebtires
            ) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    fileQueue.put(entry);

                }
            }
        }
    }

    static class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }
        public void indexFile(File file) {
            System.out.println(file.getAbsoluteFile());
            // Index the file...
        };
        @Override

        public void run() {
            try {
                while (true) {
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };
        File file = new File("C:\\Users\\xiantang\\OneDrive");
        new Thread(new FileCrawler(queue, fileFilter, file)).start();
        new Thread(new Indexer(queue)).start();
//        for (File root :
//                ) {
//
//        }

    }
}
