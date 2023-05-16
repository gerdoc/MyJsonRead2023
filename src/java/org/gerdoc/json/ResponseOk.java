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
public class ResponseOk implements Serializable
{
    private String mensaje;

    public ResponseOk()
    {
    }

    public String getMensaje() 
    {
        return mensaje;
    }

    public void setMensaje(String mensaje) 
    {
        this.mensaje = mensaje;
    }
    
}
