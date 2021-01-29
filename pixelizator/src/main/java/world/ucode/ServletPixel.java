package world.ucode;

import world.ucode.logic.PixelizateImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.nio.file.Paths;

@MultipartConfig
public class ServletPixel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        PixelizateImage pix = new PixelizateImage();
        int pixSize = inputStreamToInt(request.getPart("size").getInputStream());
        InputStream fileContent = pix.toPixel(filePart.getInputStream(), pixSize);
        //System.out.println("Hey");

        if (fileContent != null) {
            //OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[2400];
            int count = 0;
            while ((count = fileContent.read(buffer)) >= 0) {
                response.getOutputStream().write(buffer);
            }
        }
        else {
            response.getWriter().println("Your use bad img");
        }
        //System.out.println("Ok");
    }

    private static int inputStreamToInt(InputStream is) {
        return Integer.parseInt(inputStringToString(is));
    }

    private static String inputStringToString(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ( (line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pixelJSP.jsp").forward(request, response);
    }
}
