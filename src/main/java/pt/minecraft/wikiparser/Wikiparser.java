package pt.minecraft.wikiparser;

import info.bliki.api.Page;
import info.bliki.api.User;
import info.bliki.wiki.model.Configuration;
import info.bliki.wiki.model.WikiModel;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


/**
 * Hello world!
 *
 */
public class Wikiparser 
{
    private static String wikisite = "http://minecraft.gamepedia.com/index.php?";
    
    public static void main( String[] args ) throws IOException
    {
        /*
        Configuration.DEFAULT_CONFIGURATION.addTemplateFunction("ItemLink", ItemLink.CONST); 

        URL url = new URL(wikisite + "title=Template:Items/content&action=raw");
        HttpURLConnection c = (HttpURLConnection)url.openConnection();
        c.setRequestProperty("User-Agent", "curl/7.35.0"); // Wikiparser/0.1 (minecraft.pt) Inquisitor/2.18
        c.setRequestMethod("GET");
        c.connect();

        try {
          InputStream in = new BufferedInputStream(c.getInputStream());
          
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            System.out.print(baos.toString());

        }
         finally {
          c.disconnect();
        }
*/
        
        //System.out.println(br.toString());

        //HtmlToPlainText formatter = new HtmlToPlainText();
        //String plainText = formatter.getPlainText(doc);
        //System.out.println(plainText);
        
        String[] listOfTitleStrings = { "Template:Items/content" };
        User user = new User("", "", "http://minecraft.gamepedia.com/api.php");
        user.login();
        List<Page> listOfPages = user.queryContent(listOfTitleStrings);
        for (Page page : listOfPages) {
          MineWikiModel wikiModel = new MineWikiModel("${image}", "${title}");
          String html = wikiModel.render(page.toString());
          System.out.println(html);
        }
    }
}
