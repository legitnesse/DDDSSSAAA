package F409;

public class BasicStringIntegerHashMapTester 
{
    public static void main(String[] args) {
        BasicStringIntegerHashMap bsihm = new BasicStringIntegerHashMap();
        bsihm.put("hello", 10);
        bsihm.put("hi", 5);
        System.out.println(bsihm.get("world"));
        System.out.println(bsihm.collisionCount);
        System.out.println(bsihm.size);
        bsihm.removeKey("hi");
    }
}
