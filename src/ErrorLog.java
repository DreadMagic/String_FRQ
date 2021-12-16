public class ErrorLog {

    private String machineId;
    private String description;

    /** Precondition: message is a valid Error log entry */
    public ErrorLog(String message) {
        int x = message.indexOf(":");
        machineId = message.substring(0,x);
        description = message.substring(x+1);
    }

    /** Returns true if the description in this error log entry
     * contains keyword; false otherwise.
     * Postcondition: the description is unchanged
     */
    public boolean containsKey(String keyword) {
        int x = description.indexOf(keyword);
        int y = x+keyword.length();
        System.out.println(description);

        if(x==-1) return false;

        if(x==0) return (keyword.length()==description.length() || " ".equals(description.substring(y,y+1)));

        if(y == description.length()) return (" ".equals(description.substring(x-1,x)));

        return (" ".equals(description.substring(y,y+1)))&&(" ".equals(description.substring(x-1,x)));
    }

    public String getMachineId() { return machineId;}
    public String getDescription() { return description; }

    public static void main(String[] args) {
        ErrorLog er1 = new ErrorLog("CLIENT2:security alert");
        ErrorLog er2 = new ErrorLog("Webserver:disk offline");
        ErrorLog er3 = new ErrorLog("SERVER22:file not found on disk3");
        ErrorLog er4 = new ErrorLog("SERVER15:read error on disk DSK7");
        ErrorLog er5 = new ErrorLog("SERVER22:write error on disk");
        ErrorLog er6 = new ErrorLog("Webserver:error on /dev/disk");
        ErrorLog er7 = new ErrorLog("Webserver:disk");

        System.out.println("message 1 " + er1.containsKey("disk"));
        System.out.println("message 2 " + er2.containsKey("disk"));
        System.out.println("message 3 " + er3.containsKey("disk"));
        System.out.println("message 4 " + er4.containsKey("disk"));
        System.out.println("message 5 " + er5.containsKey("disk"));
        System.out.println("message 6 " + er6.containsKey("disk"));
        System.out.println("message 6 " + er6.containsKey("error"));
        System.out.println("message 7 " + er7.containsKey("disk"));


    }

}