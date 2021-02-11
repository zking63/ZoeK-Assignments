import java.util.HashMap;
import java.util.Set;
public class Hashmatique{
    public void Hashmatique(){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Dear Mama", "When I was young, me and my mama had beef \n  Seventeen years old, kicked out on the streets");
        trackList.put("California Love", "California knows how to party \n  In the city of L.A \n  In the city of good ol' Watts");
        trackList.put("Keep Ya Head Up", "Some say the blacker the berry, the sweeter the juice");
        trackList.put("All Bout U", "Ahh yeah \n  Yeauhh! \n  It's all about you, one time! \n  I'ma say it's all about you baby, yeah");
        for(String key : trackList.keySet()) {
            System.out.println((String.format("Track: %s Lyrics: %s", key, trackList.get(key))));
        }
        System.out.println("Some of the lyrics to Dear Mama: "+trackList.get("Dear Mama"));
    }
}