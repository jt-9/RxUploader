package com.jagsaund.rxuploader.store;

import androidx.annotation.NonNull;
import java.util.Map;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;

/**
 * Uploads a multipart entity and optional metadata contents.
 *
 * @param <T> Defines the type of response payload returned by the upload operation
 */
public interface UploadService<T> {
    /**
     * Uploads multipart content to a remote endpoint.
     *
     * @param metadata Optional information to be associated with the upload operation
     * @param data A file to upload
     * @return The response received from the upload operation
     */
    Single<T> upload(@NonNull Map<String, Object> metadata, @NonNull MultipartBody.Part data);
}
