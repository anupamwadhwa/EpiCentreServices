package MapsAPIs.data;

import java.util.List;

public class Response {
    private Information info;
    private Options options;
    private List<Result> results;

    public Information getInfo() {
        return info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Response{" +
                "info=" + info +
                ", options=" + options +
                ", results=" + results +
                '}';
    }
}
