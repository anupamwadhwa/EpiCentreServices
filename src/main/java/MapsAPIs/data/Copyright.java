package MapsAPIs.data;

public class Copyright {
    private String text;
    private String imageUrl;
    private String imageAltText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    @Override
    public String toString() {
        return "Copyright{" +
                "text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageAltText='" + imageAltText + '\'' +
                '}';
    }
}
