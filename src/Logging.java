import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;


public class Logging {

	private static java.lang.String strFilename = "nrs2axia.log";
    private final static long FILESIZE = 1000000;
    private java.lang.String strBackupFileName = "nrs2axia.bak";
    public String SEVERE = "SEVERE ";
    public String WARNING = "WARNING ";
    public String INFO = "INFO ";
    private java.io.File fleFileName;
    public java.io.File fleBackup;
    private int intStatus = 0;
    
    private final static String ENV_LOCAL = "local";
    private final static String ENV_DEV = "dev";
    private final static String ENV_TEST = "test";
    private final static String ENV_UAT = "uat";
    private final static String ENV_PROD = "prod";
    /**
     * MCSLogging constructor comment.
     */
    public Logging()
    {
        try
        {
            java.util.Properties prop = System.getProperties();
            String s = prop.getProperty( "user.dir" );
        	s = "local";
        	
            switch( s ){
            case ENV_LOCAL:
            	strFilename = "beadev/wls10/logs/dstDev10/nrs2Axia.log";
                strBackupFileName = "beadev/wls10/logs/dstDev10/nrs2Axia.bak";
            	break;
            case ENV_DEV:
            	strFilename = "/beadev/wls10/logs/dstDev10/nrs2Axia.log";
                strBackupFileName = "/beadev/wls10/logs/dstDev10/nrs2Axia.bak";
            	break;
            case ENV_TEST:
            	strFilename = "/beatest/wls10/logs/dstTest10/nrs2Axia.log";
                strBackupFileName = "/beatest/wls10/logs/dstTest10/nrs2Axia.bak";
            	break;
            case ENV_UAT:
            	break;
            case ENV_PROD:
            	strFilename = "/beaprod/wls10/logs/dstProd10/nrs2Axia.log";
                strBackupFileName = "/beaprod/wls10/logs/dstProd10/nrs2Axia.bak";
            	break;
            default :
            	break;
            }
            
            fleFileName = new File( strFilename );
            if ( fleFileName.exists() )
            {
                if ( fleFileName.length() > FILESIZE )
                    createBackup();
            }
            else{
            	String subFolderTmp = strFilename.substring(0, strFilename.lastIndexOf("/") ) ;
            	System.out.println( "Create folder "+ subFolderTmp ) ;
            	new File(subFolderTmp).mkdirs();
            }

            // Create file if it does not exist
            System.out.println( "Create file "+ fleFileName ) ;
            fleFileName.createNewFile();

        }
        catch ( IOException e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );

        }
        setStatus( 0 );
    }

    /**
     * MCSLogging constructor comment.
     */
    public Logging( String strFilename, String strBackupFile )
    {
        try
        {
            this.strBackupFileName = strBackupFile;
            this.strFilename = strFilename;
            fleFileName = new File( strFilename );
            if ( fleFileName.exists() )
            {
                if ( fleFileName.length() > FILESIZE )
                    createBackup();
            }
            else{
            	String subFolderTmp = strFilename.substring(0, strFilename.lastIndexOf("/") ) ;
            	System.out.println( "Create folder "+ subFolderTmp ) ;
            	new File(subFolderTmp).mkdirs();
            }

            fleFileName.createNewFile();

        }
        catch ( IOException e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );
        }
        catch ( SecurityException e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );

        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );
        }

    }

    public Logging( String strFilename )
    {
        try
        {
            StringTokenizer st = new StringTokenizer( strFilename, "." );
            strBackupFileName = st.nextToken() + ".bak";
            // this.strBackupFileName = strBackupFile;
            this.strFilename = strFilename;
            fleFileName = new File( strFilename );
            if ( fleFileName.exists() )
            {
                if ( fleFileName.length() > FILESIZE )
                    createBackup();
            }
            else{
            	String subFolderTmp = strFilename.substring(0, strFilename.lastIndexOf("/") ) ;
            	System.out.println( "Create folder "+ subFolderTmp ) ;
            	new File(subFolderTmp).mkdirs();
            }
            fleFileName.createNewFile();

        }
        catch ( IOException e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );
        }
        catch ( SecurityException e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );

        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            setStatus( 1 );
        }

    }

    /**
     * If filesize greater than 1mg (configurable within class) then rename to
     * backup. Creation date: (10/10/2002 9:09:12 AM)
     */
    public int createBackup()
    {

        File fleBackup = new File( strBackupFileName );
        if ( fleBackup.exists() )
            if ( !fleBackup.delete() )
                return 1;

        if ( !fleFileName.renameTo( fleBackup ) )
            return 1;

        return 0;
    }

    /**
     * Insert the method's description here. Creation date: (10/10/2002 11:05:58
     * AM)
     * 
     * @return int
     */
    public int getStatus()
    {
        return intStatus;
    }

    /**
     * 
     * Creation date: (10/10/2002 9:02:34 AM)
     * 
     * @param newMessage
     *            java.lang.String
     */
    public void log( java.lang.String newMessage )
    {
        try
        {

            if ( fleFileName.length() > FILESIZE )
                createBackup();

            PrintWriter pw = new PrintWriter(
                    new FileWriter( strFilename, true ) );

            SimpleDateFormat formatter = new SimpleDateFormat(
                    "MM/dd/yyyy HH:mm:ss" );

            GregorianCalendar greCal = new GregorianCalendar();
            formatter
                    .setTimeZone( TimeZone.getTimeZone( "America/Los_Angeles" ) );
            String timeStr = formatter.format( greCal.getTime() );

            pw.println( timeStr + " : " + newMessage );
            pw.close();
        }
        catch (IOException e)
        {
        }

    }
    
    public void logInMethod( java.lang.String newMessage )
    {
        try
        {

            if ( fleFileName.length() > FILESIZE )
                createBackup();

            PrintWriter pw = new PrintWriter(
                    new FileWriter( strFilename, true ) );

            SimpleDateFormat formatter = new SimpleDateFormat(
                    "MM/dd/yyyy HH:mm:ss" );

            GregorianCalendar greCal = new GregorianCalendar();
            formatter
                    .setTimeZone( TimeZone.getTimeZone( "America/Los_Angeles" ) );
            String timeStr = formatter.format( greCal.getTime() );

            pw.println( timeStr + " : [In Method]" + newMessage );
            pw.close();
        }
        catch (IOException e)
        {
        }
    }

    public void logOutMethod( java.lang.String newMessage )
    {
        try
        {

            if ( fleFileName.length() > FILESIZE )
                createBackup();

            PrintWriter pw = new PrintWriter(
                    new FileWriter( strFilename, true ) );

            SimpleDateFormat formatter = new SimpleDateFormat(
                    "MM/dd/yyyy HH:mm:ss" );

            GregorianCalendar greCal = new GregorianCalendar();
            formatter
                    .setTimeZone( TimeZone.getTimeZone( "America/Los_Angeles" ) );
            String timeStr = formatter.format( greCal.getTime() );

            pw.println( timeStr + " : [Out Method]" + newMessage );
            pw.close();
        }
        catch (IOException e)
        {
        }
    }
    /**
     * 
     * Creation date: (10/10/2002 9:02:34 AM)
     * 
     * @param newMessage
     *            java.lang.String
     */
    public void log( java.lang.String newMessage, Exception ex )
    {
        try
        {
            if ( fleFileName.length() > FILESIZE )
                createBackup();
            PrintWriter pw = new PrintWriter(
                    new FileWriter( strFilename, true ) );

            SimpleDateFormat formatter = new SimpleDateFormat(
                    "MM/dd/yyyy HH:mm:ss" );

            GregorianCalendar greCal = new GregorianCalendar();

            formatter
                    .setTimeZone( TimeZone.getTimeZone( "America/Los_Angeles" ) );
            String timeStr = formatter.format( greCal.getTime() );

            pw.println( timeStr + " : " + newMessage );
            if ( ex != null )
            {
                ex.printStackTrace( pw );
            }
            pw.close();

        }
        catch (IOException e)
        {
        }

    }

    /**
     * 
     * Creation date: (10/10/2002 11:05:58 AM)
     * 
     * @param newStatus
     *            int
     */
    public void setStatus( int newStatus )
    {
        intStatus = newStatus;
    }

    /**
     * 
     * Creation date: (10/10/2002 9:02:34 AM)
     * 
     * @param newMessage
     *            java.lang.String
     */
    public void lognodate( java.lang.String newMessage )
    {
        try
        {

            PrintWriter pw = new PrintWriter(
                    new FileWriter( strFilename, true ) );
            pw.println( newMessage );
            pw.close();
        }
        catch (IOException e)
        {
        }

    }
    
    /**
     *  To print messages to BEA log via standard output.
     *  @param msges
     *  string array
     */
    public static void stdPrintOut( String[] msges )
    {
        if ( msges != null && msges.length > 0 )
        {
            for ( int i = 1; i <= msges.length; i++ )
            {
                System.out.print( "STD-INFO idx[" + i + "]:" + msges[i - 1] + " " );
                stdPrintOutToLog( msges[i - 1] );
            }
            System.out.println();
        }
    }

    /**
     * To print message to BEA log via standard output.
     * 
     * @param msg
     *            string
     */
    public static void stdPrintOut( String msg )
    {
        System.out.println( "STD-INFO:" + msg );
        stdPrintOutToLog( msg );
    }
    
    public static void stdPrintOutToLog( java.lang.String newMessage)
    {
        try
        {
            PrintWriter pw = new PrintWriter( new FileWriter( strFilename, true ) );

            SimpleDateFormat formatter = new SimpleDateFormat(
                    "MM/dd/yyyy HH:mm:ss" );

            GregorianCalendar greCal = new GregorianCalendar();

            formatter
                    .setTimeZone( TimeZone.getTimeZone( "America/Los_Angeles" ) );
            String timeStr = formatter.format( greCal.getTime() );

            pw.println( timeStr + " : " + newMessage );
            
            pw.close();

        }
        catch (IOException e)
        {
        }

    }
}
