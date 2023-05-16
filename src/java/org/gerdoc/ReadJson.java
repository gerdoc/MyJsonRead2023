/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.gerdoc;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.gerdoc.json.Example;
import org.gerdoc.json.ResponseNotOk;
import org.gerdoc.json.ResponseOk;

/**
 *
 * @author gerdoc
 */
@WebServlet(name = "ReadJson", urlPatterns = {"/ReadJson"})
public class ReadJson extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=UTF-8");
        String json = null;
        String jsonRes = null;
        Example example = null;
        try
        {
            json = readJson( request.getReader() );
            example = json2Example( json );
            if( example == null )
            {
               jsonRes = writeJsonError( "No es un json" ); 
            }
            if( example != null )
            {
                jsonRes = writeJsonOk( "Es un json" ); 
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            writeResponse( response.getWriter( ) , jsonRes );
        }
        catch(IOException ex )
        {
            ex.printStackTrace();
        }
    }
    
    public String readJson( BufferedReader bufferedReader )
    {
        StringBuilder stringBuilder = null;
        String line = null;
        
        if( bufferedReader == null )
        {
            return null;
        }
        try 
        {
            stringBuilder = new StringBuilder( );
            while ((line = bufferedReader.readLine( ) ) != null )
            {
                stringBuilder.append(line);
            }
            return stringBuilder.toString( );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Example json2Example(String json) 
    {
        Gson gson = null;
        if( json == null )
        {
            return null;
        }
        if( json.length() <= 0 )
        {
            return null;
        }
        gson = new Gson();
        return gson.fromJson( json , Example.class );
    }

    private String writeJsonError( String error ) 
    {
        Gson gson = null;
        ResponseNotOk responseNotOk = null;
        
        if( error == null )
        {
            return null;
        }
        if( error.length() <= 0 )
        {
            return null;
        }
        gson = new Gson();
        responseNotOk = new ResponseNotOk();
        responseNotOk.setError(error);
        return gson.toJson(responseNotOk);
    }
    
    private String writeJsonOk( String mensaje ) 
    {
        Gson gson = null;
        ResponseOk responseOk = null;
        
        if( mensaje == null )
        {
            return null;
        }
        if( mensaje.length() <= 0 )
        {
            return null;
        }
        gson = new Gson();
        responseOk = new ResponseOk();
        responseOk.setMensaje(mensaje);
        return gson.toJson(responseOk);
    }

    private void writeResponse(PrintWriter printWriter, String json ) 
    {
        if( printWriter == null || json == null )
        {
            return;
        }
        if( json.length() <= 0 )
        {
            return;
        }
        printWriter.write(json);
    }

}
