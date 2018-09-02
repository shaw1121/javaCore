package com.siemens.mindsphere.jsonassert;

//import org.json.JSONException;
//import org.json.JSONObject;
//import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author zhangxiao
 * @date 8/31/2018 09:58
 */
public class jsonAssertDemo {

    public static void main(String[] args){

        String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
        String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
//        try {
//            JSONAssert.assertEquals(expected, actual, false);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        Object obj = "absd";
//        System.out.println(obj.asString());
    }
}
