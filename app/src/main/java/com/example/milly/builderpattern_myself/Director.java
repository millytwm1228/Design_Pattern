package com.example.milly.builderpattern_myself;

import com.example.milly.builderpattern_myself.interfaces.Builder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by milly on 2017/8/17.
 */

public class Director {
    //並不需要知道傳進來的是哪一個 ConcreteBuilder
    private Builder builder;
    public Director(Builder builder) {   // 先把Builder的子類別的個體，
        this.builder = builder;          // 儲存在builder欄位
    }
    public Object construct() {                   // 建立文件
        builder.makeTitle("Greeting");            // 標題
        builder.makeString("從早上到白天結束");      // 字串
        builder.makeItems(new String[]{           // 項目
            "早安。",
            "午安。",
        });
        builder.makeString("到了晚上");              // 另一個字串
        builder.makeItems(new String[]{             // 另一個項目
            "晚安。",
            "祝你有個好夢。",
            "再見。",
        });
        return builder.getResult();                 // 完成的文件就是傳回值
    }

    public static class HTMLBuilder extends Builder {

        private String filename;                           // 產生的檔名
        private PrintWriter writer;                        // 寫入到檔案的PrintWriter
        public HTMLBuilder makeTitle(String title) {              // HTML檔的標題
            filename = title + ".html";                    // 根據標題決定檔名
            try {
                writer = new PrintWriter(new FileWriter(filename));  // 建立PrintWriter
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.println("<html><head><title>" + title + "</title></head><body>");
            // 輸出標題
            writer.println("<h1>" + title + "</h1>");
            return this;
        }

        public HTMLBuilder makeString(String str) {               // HTML檔的字串
            writer.println("<p>" + str + "</p>");
            // 以<p>標籤輸出
            return this;
        }

        public HTMLBuilder makeItems(String[] items) {            // HTML檔的項目
            writer.println("<ul>");                        // 以<ul>和<li>輸出
            for (int i = 0; i < items.length; i++) {
                writer.println("<li>" + items[i] + "</li>");
            }
            writer.println("</ul>");
            return this;

        }
        public Object getResult() {                        // 完成的文件
            writer.println("</body></html>");              // 關閉標籤
            writer.close();                                // 關閉檔案
            return filename;                               // 傳回檔名
        }

        public Director build(){
            Director director = new Director(this);

            return director;
        }

    }
}