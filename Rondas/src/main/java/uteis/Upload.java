package uteis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

import net.iamvegan.multipartrequest.HttpServletMultipartRequest;
import net.iamvegan.multipartrequest.MultipartFile;

public class Upload {

   public Upload() {
   }

   public static String getDadosDosArquivos(HttpServletMultipartRequest request) {
      String retorno = "";
      try {
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         for (Enumeration e = ((HttpServletMultipartRequest) request).getFileParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(name);
            retorno += "[" + multiFile.getName() + ", " +
                    multiFile.getSize() + "bytes, " +
                    multiFile.getContentType() + "] ";
         }
      } catch (Exception e) {
         return "";
      }

      return retorno;
   }

   public static String getTipoArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getContentType();
   }

   public static long getTamanhoArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getSize();
   }

   public static String getNomeArquivo(HttpServletMultipartRequest request, String campo) {
      MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo);
      return multiFile.getName();
   }

   public static boolean copiarArquivo(HttpServletMultipartRequest request,
           String campo_html,
           String dirDestino,
           String nomeArquivodestino) {
      boolean copiou = false;
      try {
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo_html);
         InputStream in = multiFile.getInputStream();
         copiou = false;
         if (in != null) {
            BufferedInputStream input = new BufferedInputStream(in);
            FileOutputStream file = new FileOutputStream(new File(dirDestino, nomeArquivodestino));
            // Now copy contents of file 
            int read;
            byte[] buffer = new byte[4096];
            while ((read = input.read(buffer)) != -1) {
               file.write(buffer, 0, read);
            }
            file.close();
            input.close();
            copiou = true;
         } else {
            return false;
         }
      } catch (Exception e) {
         return false;
      }

      return copiou;
   }

   public static boolean copiarArquivos(HttpServletMultipartRequest request,
           String dirDestino) {
      boolean copiou = false;
      try {
         //out.println(((HttpServletMultipartRequest)request).toHtmlString());
         File tmpDir = ((HttpServletMultipartRequest) request).getTempDirectory();
         for (Enumeration e = ((HttpServletMultipartRequest) request).getFileParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(name);
            InputStream in = multiFile.getInputStream();
            copiou = false;
            if (in != null) {
               BufferedInputStream input = new BufferedInputStream(in);
               FileOutputStream file = new FileOutputStream(new File(dirDestino, multiFile.getName()));
               // Now copy contents of file 
               int read;
               byte[] buffer = new byte[4096];
               while ((read = input.read(buffer)) != -1) {
                  file.write(buffer, 0, read);
               }
               file.close();
               input.close();
               copiou = true;
            } else {
               return false;
            }
         }
      } catch (Exception e) {
         return false;
      }

      return copiou;
   }
   
   
   public static byte[] getBytesArquivo(HttpServletMultipartRequest request, String campo_html) {
      try {
         MultipartFile multiFile = ((HttpServletMultipartRequest) request).getFileParameter(campo_html);
         InputStream in = multiFile.getInputStream();
         return in.readAllBytes();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }   
   
   
}
