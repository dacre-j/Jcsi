package fr.jcsi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt
{	
	private byte[] key;
	private byte[] hash;

	public Encrypt()
	{
		key = null;
		hash = null;
	}
	
	public String encode(String password)
	{
		key = password.getBytes();
		
		try
	    {
	        hash = MessageDigest.getInstance("MD5").digest(key);
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	        throw new Error("No MD5 support.");
	    }
	
	    StringBuilder hashString = new StringBuilder();
	    for (int i = 0; i < hash.length; i++)
	    {
	        String hex = Integer.toHexString(hash[i]);
	        if (hex.length() == 1)
	        {
	            hashString.append('0');
	            hashString.append(hex.charAt(hex.length() - 1));
	        }
	        else
	            hashString.append(hex.substring(hex.length() - 2));
	    }
	    return hashString.toString();
	}
}
