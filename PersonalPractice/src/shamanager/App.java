package shamanager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {
	public static String getHash(String password) {
		StringBuffer hexString = new StringBuffer();
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("utf-8"));

			
			for(int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);

				if(hex.length() == 1) {
					hexString.append("0");
				}
				hexString.append(hex);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

    public static void main(String[] args) throws Exception{
        String hex = Integer.toHexString(0xff & 6512);
        System.out.println(hex);
    }
}
