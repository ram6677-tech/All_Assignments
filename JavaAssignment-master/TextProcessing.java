import java.util.Scanner;
public class TextProcessing{

    static String reverseString(String str){
        String rev = "";
        for(int i=str.length()-1; i>=0; i--){
            rev +=str.charAt(i);
        }
        return rev;
    }

    static boolean isPalindrome(String str){
        String rev = reverseString(str);
        return str.equalsIgnoreCase(rev);
    }

    static void countVowelsAndConsonants(String str){
        int vowels=0, consonants=0;
        str=str.toLowerCase();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch >='a' && ch<='z'){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    vowels++;
                }
                else{
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: "+vowels);
        System.out.println("Consonants: "+consonants);
    }

    static void convertCase(String str){
        System.out.println("UpperCase: "+str.toUpperCase());
        System.out.println("LowerCase: "+str.toLowerCase());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No.of String: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter String: "+(i+1)+":");
            arr[i]=sc.nextLine();
        }

        for(int i=0;i<n;i++){
            System.out.println("\nProcessing String: "+arr[i]);

            String reverse=reverseString(arr[i]);
            System.out.println("Reversed: "+reverse);

            if(isPalindrome(arr[i])){
                System.out.println("Palindrome: Yes");
            }
            else
            {
                System.out.println("Palindrome: No");
            }
            countVowelsAndConsonants(arr[i]);
            convertCase(arr[i]);
        }
        sc.close();
    }
}