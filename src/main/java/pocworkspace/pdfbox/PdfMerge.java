package pocworkspace.pdfbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PdfMerge {

  public static void main(String[] args) throws FileNotFoundException {
    // 定義兩個要合併的PDF文件
    String sourcePDF1 = "src/test/resources/pdf/First.pdf";
    String sourcePDF2 = "src/test/resources/pdf/Second.pdf";
    String destinationPDF = "src/test/resources/pdf/Merged.pdf";

    // 建立PDFMergerUtility物件
    PDFMergerUtility pdfMerger = new PDFMergerUtility();

    // 設定合併後的PDF檔案位置
    pdfMerger.setDestinationFileName(destinationPDF);

    // 增加要合併的PDF檔案
    pdfMerger.addSource(new File(sourcePDF1));
    pdfMerger.addSource(new File(sourcePDF2));

    try {
      // 執行合併
      pdfMerger.mergeDocuments(null);
      System.out.println("PDF文件合併完成: " + destinationPDF);
    } catch (IOException e) {
      System.err.println("合併PDF文件時發生錯誤: " + e.getMessage());
    }
  }
}
