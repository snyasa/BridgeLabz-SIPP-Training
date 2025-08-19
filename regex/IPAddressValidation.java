public class IPAddressValidation {
    public static void main(String[] args) {
        String[] ips = {
            "192.168.1.1", 
            "255.255.255.255", 
            "256.100.50.25", 
            "192.168.01.1", 
            "123.45.67.89"
        };

        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])"
                     + "(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}$";

        for (String ip : ips) {
            if (ip.matches(regex)) {
                System.out.println(ip + " → Valid");
            } else {
                System.out.println(ip + " → Invalid");
            }
        }
    }
}
