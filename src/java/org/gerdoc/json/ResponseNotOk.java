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
public class ResponseNotOk implements Serializable
{
    private String error;

    public ResponseNotOk()
    {
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error) 
    {
        this.error = error;
    }

    
    
}
