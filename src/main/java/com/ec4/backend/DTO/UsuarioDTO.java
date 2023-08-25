package com.ec4.backend.DTO;

public class UsuarioDTO {
    private int id;
    private String user;
    private String password;
    public UsuarioDTO() {
    }
    public UsuarioDTO(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

}
