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
public class Triangle {

    public Triangle() {
    }

    public Response typeTriangle(String lados) {
        String[] edge = new String[3];
        edge = lados.split(",");
        Response obj = new Response(edge);
        String type = "";
        type = "Triangulo ";
        if (edge[0].equals(edge[1]) && edge[1].equals(edge[2])) {
            type += "Equilatero";
            obj.setArea(obj.getAreaEquilatero());
        } else if (!edge[0].equals(edge[1]) && !edge[1].equals(edge[2])) {
            type += "Escaleno";
            obj.setArea(obj.getAreaEscaleno());
        } else {
            type += "Isosceles";
            obj.setArea(obj.getAreaIsoseles());
        }

        obj.setType(type);

        return obj;
    }

}
