package Telephony;

public class Smartphone implements Calling, Browsing{

    @Override
    public String browsing(String url) {
        for(int i = 0; i < url.length(); i++){
            if(url.charAt(i) >= '0' && url.charAt(i) <= '9'){
                return "Invalid URL!";
            }
        }
        return "Browsing: " + url + "!";
    }

    @Override
    public String calling(String number) {
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) < '0' || number.charAt(i) > '9'){
                return "Invalid number!";
            }
        }
        return "Calling... " + number;
    }
}
