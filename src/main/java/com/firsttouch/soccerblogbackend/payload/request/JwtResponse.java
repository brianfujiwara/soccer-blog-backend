package com.firsttouch.soccerblogbackend.payload.request;

public class JwtResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String jk = "klsjflkdsjflkdsj";
    private String gk = "ioouoiu";
    private String jt = "34234324";
    private String rt = "sdfsdfs";

    public JwtResponse(String accessToken){

        this.accessToken = accessToken;
    }

    public String getAccessToken(){
        return accessToken;

    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getTokenType(){
        return tokenType;
    }

    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }
}
