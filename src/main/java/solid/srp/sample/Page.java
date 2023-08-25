package solid.srp.sample;

public class Page {
    private final Integer number;
    private final String content;

    public Page(Integer number, String content) {
        this.number = number;
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

}
