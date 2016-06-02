import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class java_version {
	 
	public static void main(String[] args) throws IOException {
		ClassLoader loader = java_version.class.getClassLoader();
		// C:\\Users\\dt204842\\Desktop\\EnvConstants.Class

		FileInputStream fs = null;
		fs = new FileInputStream("C:\\jBoss\\jboss-eap-6.3\\standalone\\deployments\\nrs.war\\WEB-INF\\classes\\com\\dstoutput\\nrs\\CommonReferences$AccessLevel.class");
		
		InputStream in = loader.getResourceAsStream("java_version.Class");
		
		checkClassJavaVersion( fs );
		checkClassJavaVersion( in );
	
	}

	public static void checkClassJavaVersion(InputStream in) throws IOException{
		try (DataInputStream data = new DataInputStream(in) ) {
			if (0xCAFEBABE != data.readInt()) {
				throw new IOException("invalid header");
			}
			int minor = data.readUnsignedShort();
			int major = data.readUnsignedShort();
			System.out.println(major + "." + minor);
		}
	}
}
