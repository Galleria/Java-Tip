package com.test.resourceManagement;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseResource {

	// Resources such as Connections, Files, Input/OutStreams, etc. 
	public static void main(String[] args) {
		AutoCloseResource a = new AutoCloseResource();
		a.oldTry();
		a.newTry();
	}
	
	// java 7 below.
	public void oldTry() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {

			fos = new FileOutputStream("movies.txt");
			dos = new DataOutputStream(fos);
			dos.writeUTF("Java 7 Block Buster");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				fos.close();
				dos.close();
			} catch (IOException e) {}
		}
	}

	// java 7 above.
	public void newTry() {

        try(
        		FileOutputStream fos = new FileOutputStream("movies.txt");
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
              dos.writeUTF("Java 7 Block Buster");
        } catch(IOException e) {}

  }
}
