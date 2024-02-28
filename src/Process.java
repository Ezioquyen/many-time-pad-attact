public class Process {

     /*Su dung de hien thi ket qua cuoi cung
    public static void outPut(String word, Integer cipherText) {
        String cipherTarget = xorHexStrings(Data.cipherTexts[cipherText - 1], Data.target);
        String wordHex = stringToHex(word);
        String wordCipher;
        System.out.println("Cipher: " + cipherText);
        wordCipher = xorHexStrings(wordHex, cipherTarget);
        System.out.println("  Word: \"" + hexToString(wordCipher)+"\"");
        System.out.println("-----");
    }*/

    public static void outPut(String word, Integer cipherText) {
        String cipherTarget = xorHexStrings(Data.cipherTexts[cipherText - 1], Data.target);
        String wordHex = stringToHex(word);
        String wordCipher;
        int index = 1;
        System.out.println("Cipher: " + cipherText);
        while (wordHex.length() <= cipherTarget.length()) {
            wordCipher = xorHexStrings(wordHex, cipherTarget);


                System.out.println("  Word: \"" + hexToString(wordCipher)+"\"");
                System.out.println(" ");
            index++;
            wordHex = "00" + wordHex;
        }
        System.out.println("-----");
    }

    private static String stringToHex(String input) {
        StringBuilder hexString = new StringBuilder();

        // Duyệt qua từng ký tự trong chuỗi từ
        for (int i = 0; i < input.length(); i++) {
            // Lấy ký tự tại vị trí i
            char c = input.charAt(i);
            // Chuyển đổi ký tự thành mã ASCII và chuyển đổi mã ASCII thành chuỗi hexa
            String hex = Integer.toHexString(c);
            // Nối chuỗi hexa vào chuỗi kết quả
            hexString.append(hex);
        }

        return hexString.toString();
    }

    private static String hexToString(String hexString) {
        StringBuilder result = new StringBuilder();
        // Duyệt qua từng cặp ký tự trong chuỗi hexa
        for (int i = 0; i < hexString.length(); i += 2) {
            // Lấy từng cặp ký tự
            String hexPair = hexString.substring(i, i + 2);
            // Chuyển đổi từ cặp ký tự hexa thành giá trị số nguyên
            int decimalValue = Integer.parseInt(hexPair, 16);
            // Chuyển đổi giá trị số nguyên thành ký tự và nối vào chuỗi kết quả
            result.append((char) decimalValue);
        }

        return result.toString();
    }

    private static String xorHexStrings(String hexString1, String hexString2) {

        // Chuyển đổi chuỗi hexa thành mảng byte
        byte[] bytes1 = hexStringToByteArray(hexString1);
        byte[] bytes2 = hexStringToByteArray(hexString2);

        // Kiểm tra độ dài của hai mảng byte và chọn mảng có độ dài nhỏ hơn để thực hiện XOR
        int minLength = Math.min(bytes1.length, bytes2.length);

        // Thực hiện phép XOR
        byte[] resultBytes = new byte[minLength];
        for (int i = 0; i < minLength; i++) {
            resultBytes[i] = (byte) (bytes1[i] ^ bytes2[i]);
        }
        // Chuyển đổi kết quả từ mảng byte thành chuỗi hexa
        StringBuilder resultHex = new StringBuilder();
        for (byte b : resultBytes) {
            resultHex.append(String.format("%02X", b));
        }
        return resultHex.toString();
    }

    // Phương thức chuyển đổi chuỗi hexa thành mảng byte
    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}
