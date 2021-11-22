import java.text.DecimalFormat;
/**
 *
 * @author ADMIN
 */
public class ConvertNumToWords {
    
   private String result;
    
   public final String[] tens = {
        " mươi", //0
        " mươi mốt",//1
        " mươi hai",//2
        " mươi ba",//3
        " mươi tư",//4
        " mươi lăm",//5
        " muoi sáu",//6
        " mươi bảy",//7
        " mươi tám",//8
        " mươi chín"//9
    }; 

    public final String[] units = {
        "",//0
        " một",//1
        " hai",//2
        " ba",//3
        " bốn",//4
        " năm",//5
        " sáu",//6
        " bảy",//7
        " tám",//8
        " chín",//9
        " mười",//10
        " mười một",
        " mười hai",
        " mười ba",
        " mười bốn",
        " mười lăm",
        " mười sáu",
        " mười bảy",
        " mười tám",
        " mười chin",
    };
    
    public String lessthan1k(int n){
        String stc;
        if(n / 100 == 0){
            if(n < 20){
               stc = units[n % 100];
               n /= 100;
            }else{
               stc = units[n/10];
               stc =  stc + tens[n%10];
               n /= 100;
            }
           return stc;
         }else{
             if(n % 100 < 10){
                  if(n%10 !=0){
                      stc = " linh"+ units[n % 100];
                      n /= 100;                            
                  }else
                      return units[n/100]+ " trăm";
              }else if(n % 100 < 20){
                        stc = units[n % 100];
                        n /= 100;
                    }else{
                         stc = units[(n / 10)%10];
                         stc =  stc + tens[n%10];
                         n /= 100;
                     }
              return units[n] + " trăm" + stc;
         }  
    }

    public String convert(double n){
        if(n == 0) return " không";
        String snumber = Double.toString(n);
        
        DecimalFormat df = new DecimalFormat("000000000000000");//up to trăm nghìn tỉ
        snumber = df.format(n);
        
        int thousandsBillions = Integer.parseInt(snumber.substring(0,3));    
        int billions = Integer.parseInt(snumber.substring(3,6));
        int millions  = Integer.parseInt(snumber.substring(6,9));
        int thousands = Integer.parseInt(snumber.substring(9,12));
        int hundred = Integer.parseInt(snumber.substring(12,15));
        
        
        String tradThousandsBillions;
        switch (thousandsBillions){
            case 0:
              tradThousandsBillions = "";
              break;
            default :
              tradThousandsBillions = lessthan1k(thousandsBillions)+ " nghìn";
        }           
        result = tradThousandsBillions;
        
        String tradBillions;       
        switch (billions){
            case 0:
              tradBillions = "";
              break;
            default : 
                if(n >= 1000000000000l && billions < 100 && billions >= 10)
                    result = result + " không tram";  
                if(n >= 1000000000000l && billions < 10)
                    result = result + " không trăm linh"; 
                tradBillions = lessthan1k(billions)+ " tỉ";
        }     
        result = result + tradBillions;

        String tradMillions;     
        switch (millions) {
            case 0:
              tradMillions = "";
              break;
            default :
              if(n >= 1000000000l && millions < 100 && millions >= 10)
                result = result + " không trăm";
              if(n >= 1000000000l && millions < 10)
                result = result + " không trăm linh";   
              tradMillions = lessthan1k(millions) + " triệu";
        }          
        result =  result + tradMillions;

        String tradThousands;      
        switch(thousands){
            case 0:
              tradThousands = "";
              break;
            default :
                if(n >= 1000000 && thousands < 100 && thousands >= 10)
                    result = result + " không trăm";
                if(n >= 1000000 && thousands < 10)
                    result = result + " không trăm linh";             
              tradThousands = lessthan1k(thousands)+ " nghìn"; 
        }            
        result =  result + tradThousands;
        
        String tradHundred;  
        tradHundred = lessthan1k(hundred);
        if(n > 1000){
            if(hundred < 10 && hundred > 0)
                    result = result + " không trăm linh";
            if(hundred >= 10 && hundred < 100) 
                result = result + " không trăm";            
        }
        result = result + tradHundred;
        return result + " đồng";
    }
//end    
}
