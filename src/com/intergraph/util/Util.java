package com.intergraph.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Util {
    public void partitionPdfFile(String pdfFile,
                                 String newFile, int from, int end) {
        Document document = null;
        PdfCopy copy = null;
        try {
            PdfReader reader = new PdfReader(pdfFile);
            int n = reader.getNumberOfPages();
            if(end==0){
                end = n;
            }
            ArrayList<String> savepaths = new ArrayList<String>();
            String staticpath = pdfFile.substring(0, pdfFile.lastIndexOf("\\")+1);
            String savepath = staticpath+ newFile;
            savepaths.add(savepath);
            document = new Document(reader.getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(0)));
            document.open();
            for(int j=from; j<=end; j++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, j);
                copy.addPage(page);
            }
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch(DocumentException e) {
            e.printStackTrace();
        }
    }

    public void mergePdfFiles(String[] files, String savepath)
    {
        try
        {
            Document document = new Document(new PdfReader(files[0]).getPageSize(1));

            PdfCopy copy = new PdfCopy(document, new FileOutputStream(savepath));

            document.open();

            for(int i=0; i<files.length; i++)
            {
                PdfReader reader = new PdfReader(files[i]);

                int n = reader.getNumberOfPages();

                for(int j=1; j<=n; j++)
                {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }

            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch(DocumentException e) {
            e.printStackTrace();
        }
    }
}
