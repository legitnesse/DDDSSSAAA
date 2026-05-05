package F430;

public class Newspaper {
    
    private String content;
    private boolean isForPremium;
    public Newspaper(String content, boolean isForPremium)
    {
        this.content = content;
        this.isForPremium = isForPremium;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isForPremium() {
        return isForPremium;
    }
    public void setForPremium(boolean isForPremium) {
        this.isForPremium = isForPremium;
    }

    
}
