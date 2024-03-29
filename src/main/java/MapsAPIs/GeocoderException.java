package MapsAPIs;

import java.io.IOException;

public class GeocoderException extends IOException {

    public static final int G_GEO_SUCCESS = 200;
    public static final int G_GEO_BAD_REQUEST = 400;
    public static final int G_GEO_SERVER_ERROR = 500;
    public static final int G_GEO_MISSING_QUERY = 601;
    public static final int G_GEO_UNKNOWN_ADDRESS = 602;
    public static final int G_GEO_UNAVAILABLE_ADDRESS = 603;
    public static final int G_GEO_UNKNOWN_DIRECTIONS = 604;
    public static final int G_GEO_BAD_KEY = 610;
    public static final int G_GEO_TOO_MANY_QUERIES = 620;
    private static final long serialVersionUID = 1L;
    private final int _status;

    public GeocoderException(int status) {
        super("Status " + status);

        _status = status;
    }

    public final int getStatus() {
        return _status;
    }

    public enum GeocoderStatus {

        ERROR,
        INVALID_REQUEST,
        OK,
        OVER_QUERY_LIMIT,
        REQUEST_DENIED,
        UNKNOWN_ERROR,
        ZERO_RESULTS
    }
}
