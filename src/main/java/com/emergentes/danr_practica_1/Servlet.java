package com.emergentes.danr_practica_1;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author ALEX
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tip_doc = request.getParameter("tip_doc");

        if ("HTML".equals(tip_doc)) {
            PrintWriter out = response.getWriter();

            response.setContentType("text/html");
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>HTML</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>DOCUMENTO HTML</h1>");
                out.println("<a href='index.jsp'>VOLVER AL INICIO</a>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        } else if ("XLS".equals(tip_doc)) {
            PrintWriter out = response.getWriter();
            response.setContentType("application/vn.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=archivo.xls");
            try {
                out.println("RESPUESTA GENERADA DESDE EXCEL");
                out.println("100");
                out.println("200");
                out.println("LA SUMA ES :\t");
                out.println("=suma(a2:a3)");

            } finally {
                out.close();
            }

        } else if ("JSON".equals(tip_doc)) {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");

            try {
                out.println("{\"empleados\":[");
                out.println("{\"nombre\":\"Bruno\",\"apellidos\":\"Diaz\"},");
                out.println("{\"nombre\":\"Alex\",\"apellidos\":\"Wellick\"},");
                out.println("{\"nombre\":\"David\",\"apellidos\":\"Nina\"},");
                out.println("]}");

            } finally {
                out.close();
            }

        } else if ("CSV".equals(tip_doc)) {
            PrintWriter out = response.getWriter();
            response.setContentType("application/csv");
            response.setHeader("Content-Disposition", "attachment;filename=archivo.csv");
            try {
                out.println("id;tnombre;apellidos;edad");
                out.println("1;ALEX;WELLICK;18");
                out.println("2;DAVID;NINA;21");
                out.println("3;ARMIN;TANZARIAN;26");

            } finally {
                out.close();
            }

        } else if ("XML".equals(tip_doc)) {
            PrintWriter out = response.getWriter();

            response.setContentType("text/xml;charset=UTF-8");
            try {
                out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                out.println("<CATALOGO>");
                out.println("<CD>");
                out.println("<TITULO>TINTA ROJA </TITULO>");
                out.println("<ARTISTA>DESCONOCIDO </ARTISTA>");
                out.println("</CD>");

                out.println("<CD>");
                out.println("<TITULO> RANDOM </TITULO>");
                out.println("<ARTISTA> UNKNOW </ARTISTA>");
                out.println("</CD>");

                out.println("</CATALOGO>");
            } finally {
                out.close();
            }

        } else if ("PDF".equals(tip_doc)) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=archivo.pdf");

            try {
                // Crear un nuevo documento PDF
                Document document = new Document();
                PdfWriter.getInstance(document, response.getOutputStream());
                document.open();

                // Agregar contenido al documento PDF
                Paragraph paragraph1 = new Paragraph("Título adicional en el PDF");
                Paragraph paragraph2 = new Paragraph("Este es un párrafo adicional en el PDF.");

                document.add(paragraph1);
                document.add(paragraph2);

                // Cerrar el documento PDF
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/plain");
            response.getWriter().println("FORMATO NO VALIDO !!!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
