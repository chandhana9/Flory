
package discord;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.StringUtil;


public class TokenReader {
    
    public static String getToken(){
        String json = "";
        try {
            json = StringUtil.readFileAsString("token.json");
        } catch (Exception ex) {
            Logger.getLogger(TokenReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
        return jsonObj.get("token").getAsString();
    }
    
}
