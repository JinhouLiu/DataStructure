package org.example;

public class BinaryToDecimal {

    public static void main(String[] args){

      String s="0101";
      System.out.println(binaryToDecimal(s));

    }

    public static int Binary(String bianryStr){
        if(bianryStr==null||bianryStr.length()==0){
            return  0;
        }
        //获取标志位
          boolean positiveSign=bianryStr.charAt(0)=='1';
          int result=0;
          if(positiveSign){
              String  inverseCodeStr=toInverseCode(bianryStr);
              String   complateCode=toComplateCode(inverseCodeStr);
               result=-binaryToDecimal(complateCode);
          }else{
              binaryToDecimal(bianryStr);
          }
          return result;
    }

    /**
     * 二进制转化为十进制
     * @param binaryStr
     * @return
     */
    public static  int  binaryToDecimal(String  binaryStr){
        int sum=0;
        for(int i=binaryStr.length()-1,pow=0;i>=0;i--,pow++){
            sum+=(int)((binaryStr.charAt(i)-'0')*Math.pow(2,pow));
        }
        return sum;
    }


    /**
     * 将原来的字符串转化为反码
     * @param binaryStr
     * @return
     */
    public static String toInverseCode(String binaryStr) {
        StringBuilder inverseCode = new StringBuilder();

        // 遍历每一个字符并按位取反
        for (char bit : binaryStr.toCharArray()) {
            if (bit == '0') {
                inverseCode.append('1');
            } else if (bit == '1') {
                inverseCode.append('0');
            } else {
                throw new IllegalArgumentException("输入的二进制字符串包含非0或1的字符");
            }
        }

        return inverseCode.toString();
    }


    /**
     * 将反码转化为补码
     *
     * @param binaryStr
     * @return
     */
    public static String toComplateCode(String binaryStr) {

        StringBuilder sb = new StringBuilder();
        int curryOn = 1;
        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            int currentBit = binaryStr.charAt(i) - '0';
            int sum = currentBit + curryOn;
            if (sum == 2) {
                sb.append(0);
                curryOn = 1;
            } else {
                sb.append(sum);
                curryOn = 0;
            }
        }
        if (curryOn == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
