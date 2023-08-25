package solid.srp.sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Book {

    public static final String BOOK_DIRECTORY_PATH = "/tmp";

    private final String title;
    private final String author;
    private final List<Page> pages;
    private Page currentPage;

    public Book(String title, String author, List<Page> pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.currentPage = this.pages.get(0);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Page getCurrentPage() {
        return currentPage;
    }


    /**
     * 決定下一頁還上一頁
     *
     * @param command command
     */
    public void doTurnPageOrBack(String command) {
        boolean canDoTurnPageOrBack;

        String NEXT_PAGE = "next";
        if (command.equalsIgnoreCase(NEXT_PAGE)) {
            canDoTurnPageOrBack = validateTurnNextPageLimit();
        } else {
            canDoTurnPageOrBack = validateTurnBackPageLimit();
        }

        if (canDoTurnPageOrBack) {
            turnPage(getCurrentPageIndex());
        }
    }

    /**
     * 驗證可不可已翻下一頁
     *
     * @return boolean
     */
    public boolean validateTurnNextPageLimit() {
        return getCurrentPageIndex() <= pages.size();
    }

    /**
     * 驗證可不可已翻上一頁
     *
     * @return boolean
     */
    public boolean validateTurnBackPageLimit() {
        return getCurrentPageIndex() - 2 >= 0;
    }

    /**
     * 取得當前頁數
     *
     * @return 當前頁數
     */
    public Integer getCurrentPageIndex() {
        return currentPage.getNumber();
    }

    /**
     * 翻頁
     *
     * @param turnPageIndex 要翻到哪頁
     */
    public void turnPage(Integer turnPageIndex) {
        currentPage = pages.get(turnPageIndex);
    }


    /**
     * 讀取書的內容
     *
     * @return BufferedWriter
     *
     * @throws IOException IOException
     */
    private BufferedWriter getPageContent() throws IOException {
        String bookFilePath = Book.BOOK_DIRECTORY_PATH + "/" + this.title + "_" + new Date().getTime();
        BufferedWriter writer = new BufferedWriter(new FileWriter(bookFilePath));
        return writer;
    }

    public void readPageContent() throws IOException {
        try (BufferedWriter writer = getPageContent()) {
            for (Page page : pages) {
                writer.write("---- Page " + page.getNumber() + " ----");
                writer.newLine();
                writer.write(page.getContent());
                writer.newLine();
            }
        }
    }


//    public void turnPage() {
//        Integer nextPageIndex = currentPage.getNumber();
//        if (nextPageIndex <= pages.size()) {
//            currentPage = pages.get(nextPageIndex);
//        }
//    }
//
//    public void turnPageBack() {
//        Integer previousPageIndex = currentPage.getNumber() - 2;
//        if (previousPageIndex >= 0) {
//            currentPage = pages.get(previousPageIndex);
//        }
//    }

}
