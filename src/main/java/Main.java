import com.cloudinary.ApiClient;
import com.cloudinary.ApiException;
import com.cloudinary.Configuration;
import com.cloudinary.api.MediaSourceApi;
import com.cloudinary.model.MediaSource;
import com.cloudinary.model.MediaSourceConfig;
import com.cloudinary.model.MediaSourceCreatePayload;

import java.util.List;
import java.util.UUID;

public class Main {

    private static ApiClient cloudinaryClient;

    public static void main(String[] args) {
        initCloudinary();
        createMediaSource();
        System.out.println("=============================");
        listMediaSources();
    }

    private static void initCloudinary() {
        cloudinaryClient = Configuration.getDefaultApiClient("cloudinary://198135424637265:glcUNrk-lLo1zATNmCDyfS5_h_c@dhyrkkaqb");
        cloudinaryClient.setBasePath("https://api-staging.cloudinary.com/v2/dhyrkkaqb");
    }

    private static void createMediaSource() {
        MediaSourceApi apiInstance = new MediaSourceApi();

        MediaSourceCreatePayload mediaSourceCreatePayload = new MediaSourceCreatePayload();
        mediaSourceCreatePayload.setSourceType(MediaSourceCreatePayload.SourceTypeEnum.HTTP);
        mediaSourceCreatePayload.setDisplayName(UUID.randomUUID().toString());
        mediaSourceCreatePayload.setConfig(new MediaSourceConfig());
        try {
            MediaSource response = apiInstance.createMediaSource(mediaSourceCreatePayload);
            // System.out.println(response);
        } catch (ApiException e) {
            System.err.println("Exception when calling CacheApi#invalidate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    private static void listMediaSources() {
        MediaSourceApi apiInstance = new MediaSourceApi();
        try {
            List<MediaSource> mediaSources = apiInstance.getMediaSources();
            System.out.println(mediaSources);
        } catch (ApiException e) {
            System.err.println("Exception when calling CacheApi#invalidate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
