/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.json;

import java.io.Serializable;

/**
 *
 * @author gerdoc
 */
public class Example implements Serializable
{
    private String usuario;
    private String password;

    public Example() 
    {
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
}
