package MapsAPIs.data;

import java.util.List;

public class Information {
    private int statuscode;
    private Copyright copyright;
    private List<String> messages;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Information{" +
                "statuscode=" + statuscode +
                ", copyright=" + copyright +
                ", messages=" + messages +
                '}';
    }
}
