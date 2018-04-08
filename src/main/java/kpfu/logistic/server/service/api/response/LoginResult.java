/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.service.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author rz
 */
public class LoginResult {
    
    @JsonProperty(value = "user_id")
    private String userId;

    @JsonProperty(value = "role")
    private String role;
    
    @JsonProperty(value = "token")
    private String token;

    public LoginResult() {
    }

    public LoginResult(String userId, String role, String token) {
        this.userId = userId;
        this.role = role;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
