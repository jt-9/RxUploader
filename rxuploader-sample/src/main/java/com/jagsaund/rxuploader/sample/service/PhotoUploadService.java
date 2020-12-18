package com.jagsaund.rxuploader.sample.service;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.jagsaund.rxuploader.sample.model.wire.PhotoJSONModel;
import com.jagsaund.rxuploader.sample.model.wire.UploadPhotoJSONModel;
import com.jagsaund.rxuploader.store.UploadService;
import java.util.Map;
import java.util.Objects;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;

public class PhotoUploadService implements UploadService<PhotoJSONModel> {
    @NonNull private final ApiService apiService;

    @VisibleForTesting
    PhotoUploadService(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    public static UploadService<PhotoJSONModel> create(@NonNull ApiService apiService) {
        return new PhotoUploadService(apiService);
    }

    @Override
    public Single<PhotoJSONModel> upload(@NonNull Map<String, Object> metadata,
                                         @NonNull MultipartBody.Part data) {
        final String name = (String) Objects.requireNonNull(metadata.get("name"));
        final String description = (String) Objects.requireNonNull(metadata.get("description"));
        final Double privacy = (Double) metadata.get("privacy");

        return apiService
                .uploadPhoto(name, description, privacy != null ? privacy.intValue() : 0, data)
                .map(UploadPhotoJSONModel::photo);
    }
}
