package F409;

public class GenericHashMapTester 
{
    public static void main(String[] args) 
    {
        GenericHashMap<String, String> ghm = new GenericHashMap<>();
        ghm.put("hello", "world");
        ghm.put("timothy", "le");
        System.out.println(ghm.get("hello"));
        System.out.println(ghm.get("timothy"));
        System.out.println(ghm.remove("hello", "world"));
        System.out.println(ghm.size());
        System.out.println(ghm.get("hello"));
    }
    
}
