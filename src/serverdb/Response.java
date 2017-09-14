/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdb;

/**
 *
 * @author Jorke11
 */
public class Response {

    public String data;
    

    public Response() {
    }

    public Response(String data) {
        this.data = data;
        
    }
   

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
