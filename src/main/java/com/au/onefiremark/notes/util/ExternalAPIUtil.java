package com.au.onefiremark.notes.util;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Subbu Baravani
 * Calls external APIs and creates a CHuck Norris joke with a random user name
 */
public class ExternalAPIUtil {
    private static Logger LOG = LoggerFactory.getLogger(ExternalAPIUtil.class);

    /**
     * Get a chuck norris joke
     * @return
     */
    public static String getChuckNorrisJoke(){
        LOG.info("getChuckNorrisJoke");
        String joke ;
        String[] user = getARandomUser();
        String norrisAPI = "http://api.icndb.com/jokes/random?firstName="+user[0]+"&lastName="+user[1];
        RestTemplate  restTemplate = new RestTemplate();
        joke = restTemplate.getForObject(norrisAPI, String.class);
        try {
            JSONObject jsonObject = new  JSONObject(joke);
            joke = jsonObject.getJSONObject("value").getString("joke");
        } catch (JSONException e) {
            LOG.error(e.getMessage());
        }

        return joke.replaceAll("&quot;" ,"\"");
    }

    /**
     * Get a random user name
     * @return
     */
    public static String[] getARandomUser(){
        LOG.info("getRandomUser");
        String randomUserAPI = "https://randomuser.me/api/";
        RestTemplate  restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(randomUserAPI, String.class);
        JSONObject jsonObject ;
        try {
            jsonObject = new  JSONObject(result);
            JSONObject personDetails =  jsonObject.getJSONArray("results").getJSONObject(0);
            JSONObject  name  = personDetails.getJSONObject("name");

            return new String[]{name.getString("first"), name.getString("last")};

        } catch (JSONException e) {
            LOG.error(e.getMessage());
        }

        return null;
    }
}
