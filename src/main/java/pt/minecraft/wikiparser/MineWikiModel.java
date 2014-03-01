/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.minecraft.wikiparser;

import info.bliki.wiki.filter.AbstractParser;
import info.bliki.wiki.filter.WikipediaParser;
import info.bliki.wiki.model.WikiModel;
import java.util.Map;

import info.bliki.wiki.filter.AbstractParser;
import info.bliki.wiki.filter.Encoder;
import info.bliki.wiki.filter.WikipediaParser;
import info.bliki.wiki.filter.WikipediaPreTagParser;


/**
 *
 * @author vxf
 */
public class MineWikiModel extends WikiModel {

    public MineWikiModel(String imageBaseURL, String linkBaseURL) {
        super(imageBaseURL, linkBaseURL);
    }
    
    @Override
    public String getRawWikiContent(String namespace, String articleName, Map<String, String> map) {
            String result = super.getRawWikiContent(namespace, articleName, map);
            if (result != null) {
                    // found magic word template
                    return result;
            }
            // replace SPACES with underscore('_') and first character as uppercase
            String name = encodeTitleToUrl(articleName, true);
            if (isTemplateNamespace(namespace)) {
                    if (name.equals("Navbox")) {
                            return map.toString();
                    }
                    if (name.equals("ItemLink")) {
                        //System.out.println(map.toString());
                        //return null;
                        
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            
                            if (!key.equals("id")) {
                                 //this.appendInternalLink(value, "", value, null, true); 
                                 System.out.println(value);
                            }
                        }
                        
                        return "";
                        //return map.toString();
                    }
            }
            return null;
    }
    


}
