package F303;

import F226.Deck;

public class PalindromeChecker 
{
    public PalindromeChecker(){}
    //Old method
    /*public boolean checkPalindrome(String toBeChecked)
    {
        Deck<String> forwardWord = new Deck<>();
        Deck<String> backwardWord = new Deck<>();

        for(int i = 0; i < toBeChecked.length(); i++)
        {
            String s = toBeChecked.substring(i, i + 1);
            forwardWord.push(s);
        }
        for(int i = toBeChecked.length() - 1; i >= 0; i--)
        {
            String s = toBeChecked.substring(i, i + 1);
            backwardWord.push(s);
        }
        boolean isPalindrome = true;
        while(forwardWord.getSize() != 0 && backwardWord.getSize() != 0 && isPalindrome)
        {
            if(forwardWord.pop().equals(backwardWord.pop()))
            {
                isPalindrome = true;
            }
            else{
                return false;
            }
        } 
        return isPalindrome;
    }*/
   //IQ too high?
    public boolean checkPalindrome(String toBeChecked)
    {
        Deck<Character> forwardWord = new Deck<>();
        Deck<Character> backwardWord = new Deck<>();

        for(int i = 0; i < toBeChecked.length(); i++)
        {
            char c = toBeChecked.charAt(i);
            forwardWord.push(c);
        }
        for(int i = toBeChecked.length() - 1; i >= 0; i--)
        {
            char c = toBeChecked.charAt(i);
            backwardWord.push(c);
        }

        while(forwardWord.getSize() != 0 && backwardWord.getSize() != 0)
        {
            if(forwardWord.pop() != backwardWord.pop())
            {
                return false;
            }
        }
        return true;
    }
}
