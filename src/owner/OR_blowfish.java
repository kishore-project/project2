package owner;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class OR_blowfish
 */
@WebServlet("/OR_blowfish")
public class OR_blowfish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String algorithm = "Blowfish";
	 public static String encrypt(String secret, final String password) throws Exception {
	        byte[] keyData = secret.getBytes();
	        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, algorithm);
	        Cipher cipher = Cipher.getInstance(algorithm);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	        byte[] hasil = cipher.doFinal(password.getBytes());
	        return new BASE64Encoder().encode(hasil);
	    }
	 
	public static String getcode(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
